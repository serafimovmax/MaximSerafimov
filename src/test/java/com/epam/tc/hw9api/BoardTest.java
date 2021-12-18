package com.epam.tc.hw9api;

import static com.epam.tc.hw9api.constants.Constants.BOARDS_ENDPOINT;
import static com.epam.tc.hw9api.specifications.BaseService.notFoundResponseSpecification;
import static com.epam.tc.hw9api.specifications.BoardService.boardRequestBuilder;
import static com.epam.tc.hw9api.specifications.BoardService.parseBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.createBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.deleteBoard;
import static com.epam.tc.hw9api.steps.BoardSteps.getDeletedBoard;
import static com.epam.tc.hw9api.utils.RandomString.generateRandomName;
import static io.restassured.http.Method.PUT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9api.beans.Board;
import org.testng.annotations.Test;

public class BoardTest extends BaseTest {
    Board board;

    @Test
    public void createBoardTest() {
        board = createBoard();
        String createdBoard = board.getName();
        assertThat(board.getName(), equalTo(createdBoard));
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
    public void deleteBoardTest() {
        board = createBoard();
        deleteBoard(board.getId());
        getDeletedBoard(board.getId())
            .then()
            .assertThat()
            .spec(notFoundResponseSpecification());
    }
}
