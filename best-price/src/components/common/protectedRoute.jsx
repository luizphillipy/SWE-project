import React from "react";
import {Redirect, Route} from "react-router-dom";

const ProtectedRoute = ({path, component: Component, render, ...rest}) => {
    return (<Route
        {...rest}
        render={(props) => {
            if (!localStorage.getItem("user")) return (<Redirect
                to={{
                    pathname: "/LogIn", state: {from: props.location},
                }}
            />);
            return Component ? <Component {...props} /> : render(props);
        }}
    />);
};

export default ProtectedRoute;
