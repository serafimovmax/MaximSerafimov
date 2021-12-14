package com.epam.tc.hw9api.steps;

import static com.epam.tc.hw9api.constants.Constants.BOARDS_ENDPOINT;
import static com.epam.tc.hw9api.constants.Constants.MEMBER_ENDPOINT;
import static com.epam.tc.hw9api.specifications.BaseService.responseSpecification;
import static com.epam.tc.hw9api.specifications.BoardService.boardRequestBuilder;
import static com.epam.tc.hw9api.specifications.BoardService.parseBoard;
import static com.epam.tc.hw9api.utils.PropertiesReader.getProperty;
import static com.epam.tc.hw9api.utils.RandomString.generateRandomName;
import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;

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

    @Step("Get Board")
    public static Response getBoard(String id) {
        return boardRequestBuilder()
            .setMethod(GET)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + id)
            .then()
            .extract().response();
    }

    @Step("Update Board")
    public static Board changeBoardName(String id, String name) {
        return parseBoard(
            boardRequestBuilder()
                .setMethod(PUT)
                .setName(name)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id)
        );
    }

    @Step("Delete Board")
    public static Response deleteBoard(String id) {
        boardRequestBuilder()
            .setMethod(DELETE)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + id);
        return null;
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
            .spec(responseSpecification())
            .extract().response().jsonPath().getList("id");
    }

    @Step("Get response")
    public static Response getResponse(String id) {
        return  boardRequestBuilder()
            .setMethod(GET)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + id);
    }
}
