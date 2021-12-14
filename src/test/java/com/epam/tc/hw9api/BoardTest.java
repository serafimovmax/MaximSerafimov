package com.epam.tc.hw9api;

import static com.epam.tc.hw9api.constants.Constants.BOARDS_ENDPOINT;
import static com.epam.tc.hw9api.specifications.BaseService.badResponseSpec;
import static com.epam.tc.hw9api.specifications.BoardService.boardRequestBuilder;
import static com.epam.tc.hw9api.specifications.BoardService.parseBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.createBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.deleteBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.getBoard;
import static com.epam.tc.hw9api.utils.RandomString.generateRandomName;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BoardTest extends BaseTest {

    @Test
    public void createBoardTest() {
        String randomString = generateRandomName();
        board = parseBoard(boardRequestBuilder()
            .setMethod(POST)
            .setName(randomString)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT)
            .then()
            .extract().response());
        assertThat(board.getName(), equalTo(randomString));

    }

    @Test
    public void changeBoardNameTest() {
        String randomString = generateRandomName();
        board = createBoard();
        board = parseBoard(boardRequestBuilder()
            .setMethod(PUT)
            .setName(randomString)
            .buildRequest()
            .sendRequest(BOARDS_ENDPOINT + board.getId())
            .then()
            .extract().response());
        assertThat(board.getName(), equalTo(randomString));
    }

    @Test
    public void boardDeleteTest() {
        board = createBoard();
        deleteBoard(board.getId());
        getBoard(board.getId())
            .then().assertThat()
            .spec(badResponseSpec());
    }
}
