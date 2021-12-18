package com.epam.tc.hw9api.steps;

import static com.epam.tc.hw9api.constants.Constants.BOARDS_ENDPOINT;
import static com.epam.tc.hw9api.constants.Constants.MEMBER_ENDPOINT;
import static com.epam.tc.hw9api.specifications.BaseService.goodResponseSpecification;
import static com.epam.tc.hw9api.specifications.BoardService.boardRequestBuilder;
import static com.epam.tc.hw9api.specifications.BoardService.parseBoard;
import static com.epam.tc.hw9api.utils.PropertiesReader.getProperty;
import static com.epam.tc.hw9api.utils.RandomString.generateRandomName;
import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.POST;

import com.epam.tc.hw9api.beans.Board;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.List;

public class BoardSteps {

    @Step("Create Board")
    public static Board createBoard() {
        String randomString = generateRandomName();
        Response response = boardRequestBuilder()
            .setMethod(POST)
            .setName(randomString)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT)
            .then().extract().response();
        return parseBoard(response);
    }

    @Step
    public static Response getDeletedBoard(String boardId) {
        return boardRequestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + boardId)
            .then()
            .extract().response();
    }

    @Step("Delete Board")
    public static void deleteBoard(String boardId) {
        boardRequestBuilder()
            .setMethod(DELETE)
            .setId(boardId)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + boardId)
            .then()
            .spec(goodResponseSpecification());
    }

    @Step("Delete All Boards")
    public static void deleteAllBoards() {
        for (String boardId : getAllIdBoards()
        ) {
            deleteBoard(boardId);
        }
    }

    @Step("Get All Boards")
    public static List<String> getAllIdBoards() {
        return boardRequestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(MEMBER_ENDPOINT + getProperty("userId") + BOARDS_ENDPOINT)
            .then().assertThat()
            .spec(goodResponseSpecification())
            .extract().response().jsonPath().getList("id");
    }
}
