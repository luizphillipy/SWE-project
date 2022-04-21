import React, {Component} from "react";
import {getItemsById} from "../../services/component/items";
import {withTitleBar} from "../../hoc/withTitleBar";
import {isLoggedIn,} from "../../services/generic/currentUserValidation";
import UserContext from "../../context/userContext";
import {add, remove} from "../../services/component/orders";

class UserItems extends Component {
    static contextType = UserContext;
    state = {
        items: [],
    };

    async componentDidMount() {
        const {data: items} = await getItemsById({
            subCategoryId: this.props.match.params.id, userId: this.context.currentUser.customerId,
        });
        this.setState({items});
    }

    addToCart = async (item) => {
        await add({
            sellerItemId: item.id, userId: this.context.currentUser.customerId, quantity: 1,
        });
        let items = [...this.state.items];
        let selectedItem = items.find((selected) => selected.id === item.id);
        selectedItem.quantity += 1;
        selectedItem.isInBag = true;
        this.setState({items});
        this.context.updateNumber(++this.context.currentUser.bagItemsQuantity);
    };

    removeFromCart = async (item) => {
        await remove({
            sellerItemId: item.id, userId: this.context.currentUser.customerId, quantity: 1,
        });
        let items = [...this.state.items];
        let selectedItem = items.find((selected) => selected.id === item.id);
        selectedItem.quantity -= 1;
        selectedItem.isInBag = selectedItem.quantity !== 0;
        this.setState({items});
        this.context.updateNumber(--this.context.currentUser.bagItemsQuantity);
    };

    render() {
        const Hoc = withTitleBar(() => (<UserItemsComponent
            items={this.state.items}
            addToCart={this.addToCart}
            removeFromCart={this.removeFromCart}
        />), this.props.match.params.name);
        return <Hoc/>;
    }
}

const UserItemsComponent = (props) => {
    return (<div className="userItems__container">
        <div className="content__container">
            {props.items.map((item) => (<div className="card__item">
                <div className="item-card__labil">{item.name}</div>
                <div className="item-card__image__container">
                    <img
                        className="item-card__image"
                        src={`data:image/jpeg;base64,${item.attachmentURL}`}
                        alt=""
                    />
                </div>
                <div className="card__body">
                    <div className="card__description">{item.description}</div>
                    <div className="item__seller">Price: ${item.price}</div>
                    <div className="item__footer">
                        {isLoggedIn() && item.isInBag && (<button
                            className="buy__button"
                            onClick={() => props.removeFromCart(item)}
                        >
                            -
                        </button>)}
                        <div>{isLoggedIn() && item.isInBag && item.quantity + ""}</div>

                        {isLoggedIn() && (<button
                            className="buy__button"
                            onClick={() => props.addToCart(item)}
                        >
                            {!item.isInBag && "Add To Cart"}
                            {item.isInBag && "+"}
                        </button>)}
                    </div>
                </div>
            </div>))}
        </div>
    </div>);
};

export default UserItems;
