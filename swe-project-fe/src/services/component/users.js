import http from "../generic/http";
import {baseURL} from "../../config.json";

const url = baseURL + "/users";

export const addUser = (newUser) => {
    return http.post(url + "/Add", newUser);
};

export const logIn = (user) => {
    return http.post(url + `/LogIn?email=${user.email}&password=${user.password}`);
};
