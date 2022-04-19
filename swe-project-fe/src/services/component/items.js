import http from "../generic/http";
import {baseURL} from "../../config.json";

const url = baseURL + "/items";

export const getItemsById = (data) => {
    return http.get(url + `/GetBySubCategoryIdUserList`, {params: data});
};

export const getSellerItemsBySellerId = (id) => {
    return http.get(url + "/GetSellerItemsSellerById?id=" + id);
};

export const sellersItemApproveReject = (id, statusId) => {
    return http.post(`${url}/SellersItemApproveReject?id= + ${id}&statusId=${statusId}`);
};
