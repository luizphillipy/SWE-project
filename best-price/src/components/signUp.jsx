import React from "react";
import * as Joi from "joi-browser";
import {FaSignInAlt} from "react-icons/fa";
import {ToastContainer, toast} from "react-toastify";
import Form from "./common/form";

class SignUp extends Form {
    state = {
        data: {email: "", name: "", phoneNumber: undefined, password: ""}, errors: {},
    };

    schema = {
        email: Joi.string().required().email().label("Email"),
        name: Joi.string().required().label("User Name"),
        phoneNumber: Joi.number().required().label("Phone Number"),
        password: Joi.string().required().label("Password"),
    };

    doSubmit = async () => {
      //TODO api request to log the user in
    };

    render() {
        // const user = JSON.parse(localStorage.getItem("user"));
        // if (user) {
        //     return checkIfLoggedIn();
        // }
        return (<div className="center-box">
            <div className="login__box">
                <div className="login__form">
                    <h2 className="login__heading">
                        <FaSignInAlt className="login__icon"/>
                        SignUp
                    </h2>
                    <form noValidate autoComplete="off">
                        <div className="row">
                            <div className="col p-2">
                                {this.renderInput("email", "Email", "email")}
                            </div>
                            <div className="col p-2">
                                {this.renderInput("name", "Name")}
                            </div>
                        </div>
                        <div className="row">
                            <div className="col p-2">
                                {this.renderInput("phoneNumber", "Phone Number", "number")}
                            </div>
                            <div className="col p-2">
                                {this.renderInput("password", "Password", "password")}
                            </div>
                        </div>
                        <div className="row sigin-button__container">
                            <div className="col-4 sigin__button">
                                {this.renderButton("Submit")}
                            </div>
                        </div>
                    </form>
                </div>
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

export default SignUp;
