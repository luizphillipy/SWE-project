import React, {Component} from "react";
import {getOrderItems} from "../../services/component/orders";
import UserContext from "../../context/userContext";

class UserOrderList extends Component {
    static contextType = UserContext;
    state = {
        items: [],
    };

    async componentDidMount() {
        const {data: items} = await getOrderItems(this.context.shoppingCartId);
        this.setState({items});
    }

    render() {
        return (<div className="order-page__container">
            <div className="order-page__content">
                <h2 className="table__head">Bag Items</h2>
                <div className="order-table-head__row">
                    <div className="order-table__columns">Name</div>

                    <div className="order-table__columns">Price</div>
                    <div className="order-table__columns">Quantity</div>
                    <div className="order-table__columns">Total</div>
                </div>

                {this.state.items.map(({product: {name, price, id}, quantity}) => (
                    <div className="order-table__row" key={id}>
                        <div className="order-table__columns">{name}</div>
                        <div className="order-table__columns">{price}</div>
                        <div className="order-table__columns">{quantity}</div>
                        <div className="order-table__columns">
                            {quantity * price}
                        </div>
                    </div>))}
            </div>
        </div>);
    }
}

export default UserOrderList;
