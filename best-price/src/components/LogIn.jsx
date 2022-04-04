import React from "react";
import * as Joi from "joi-browser";
import {ToastContainer, toast} from "react-toastify";
import {BsPeople} from "react-icons/bs";
import Form from "./common/form";
// import Form from "../../common/form";
// import { logIn } from "../../services/component/users";
// import { UsersTypes } from "../../config.json";
// import { checkIfLoggedIn } from "../../services/generic/currentUserValidation";

class LogIn extends Form {
    state = {
        data: {
            email: "",
            password: ""
        }, errors: {},
    };

    schema = {
        email: Joi.string().required().email().label("Email"), password: Joi.string().required().label("Password"),
    };

    doSubmit = async () => {
        // const loginData = {...this.state.data};
        // let {data: user} = await logIn(loginData);
        // if (user) {
        //     localStorage.setItem("user", JSON.stringify(user));
        //     this.redirect(user);
        // } else {
        // toast("Wrong Email Or Password");
        // }
    };

    redirect = (user) => {
        // const {
        //     user: userTypeId, admin: adminTypeId, seller: sellerTypeId,
        // } = UsersTypes;
        // this.props.onUpdateUserData(user);
        // if (user.userTypeId === userTypeId.toLowerCase()) {
        //     this.props.history.replace("/MainCategories");
        // } else if (user.userTypeId === sellerTypeId.toLowerCase()) {
        //     this.props.history.replace("/SellerItems");
        // } else if (user.userTypeId === adminTypeId.toLowerCase()) {
        //     this.props.history.replace("/AdminMain");
        // }
    };

    render() {
        // const user = JSON.parse(localStorage.getItem("user"));
        // if (user) {
        //     return checkIfLoggedIn();
        // }
        return (<div className="login__box">
            <div className="login__form">
                <h2 className="login__heading">
                    <BsPeople className="login__icon"/>
                    LogIn
                </h2>
                <form noValidate autoComplete="off">
                    <div className="row">
                        <div className="col p-2">
                            {this.renderInput("email", "Email", "email")}
                        </div>
                    </div>
                    <div className="row">
                        <div className="col p-2">
                            {this.renderInput("password", "Password", "password")}
                        </div>
                    </div>
                    <div className="row form__button">
                        <div className="col-4 login__button">
                            {this.renderButton("Login")}
                        </div>
                    </div>
                </form>
            </div>
            <ToastContainer
                position="top-center"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
            />
        </div>);
    }
}

export default LogIn;
