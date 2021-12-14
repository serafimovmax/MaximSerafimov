package com.epam.tc.hw9api.steps;

import static com.epam.tc.hw9api.constants.Constants.BOARDS_ENDPOINT;
import static com.epam.tc.hw9api.constants.Constants.LISTS_ENDPOINT;
import static com.epam.tc.hw9api.specifications.ListService.listRequestBuilder;
import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ListSteps {

    @Step("Create List")
    public static Response createList(String boardId, String listName) {
        return listRequestBuilder()
            .setMethod(POST)
            .setName(listName)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + boardId + LISTS_ENDPOINT);
    }

    @Step("Get Lists")
    public static Response getLists(String boardId) {
        return listRequestBuilder()
            .setMethod(GET)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + boardId + LISTS_ENDPOINT);
    }

    @Step("Delete List")
    public static void deleteList(String listId) {
        listRequestBuilder()
            .setMethod(DELETE)
            .buildRequest()
            .sendRequest(LISTS_ENDPOINT + listId);
    }
}
