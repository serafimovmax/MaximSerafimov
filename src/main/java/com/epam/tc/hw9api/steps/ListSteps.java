package com.epam.tc.hw9api.steps;

import static com.epam.tc.hw9api.specifications.ListService.listRequestBuilder;
import static com.epam.tc.hw9api.specifications.ListService.parseList;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;

import com.epam.tc.hw9api.beans.Lists;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ListSteps {
    public static String BOARDS_ENDPOINT = "/boards/";
    public static String LISTS_ENDPOINT = "/lists/";

    @Step("Create List")
    public static Lists createList(String boardId, String listName) {
        Response response =  listRequestBuilder()
            .setMethod(POST)
            .setName(listName)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + boardId + LISTS_ENDPOINT);
        return parseList(response);
    }

    @Step("Get Lists")
    public static Lists getList(String listId) {
        Response response = listRequestBuilder()
            .setMethod(GET)
            .setId(listId)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + listId)
            .then().extract().response();
        return parseList(response);
    }
}
