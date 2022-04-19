import http from "../generic/http";
import { baseURL } from "../../config.json";

const url = baseURL + "/orders";

export const add = (order) => {
  return http.post(url + "/Add", order);
};

export const remove = (order) => {
  return http.post(url + "/Remove", order);
};

export const getOrderItems = (id) => {
  return http.get(url + "/Get?id=" + id);
};
