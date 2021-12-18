package com.epam.tc.hw9api;

import static com.epam.tc.hw9api.constants.Constants.LISTS_ENDPOINT;
import static com.epam.tc.hw9api.specifications.ListService.listRequestBuilder;
import static com.epam.tc.hw9api.specifications.ListService.parseList;
import static com.epam.tc.hw9api.steps.BoardSteps.createBoard;
import static com.epam.tc.hw9api.steps.ListSteps.createList;
import static com.epam.tc.hw9api.utils.RandomString.generateRandomName;
import static io.restassured.http.Method.PUT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9api.beans.Board;
import com.epam.tc.hw9api.beans.Lists;
import org.testng.annotations.Test;

public class ListsTest extends BaseTest {
    Board board;
    Lists lists;

    @Test
    public void createListTest() {
        String randomName = generateRandomName();
        board = createBoard();
        lists = parseList(createList(board.getId(), randomName));
        assertThat(lists.getName(), equalTo(randomName));
    }

    @Test
    public void changeListName() {
        String randomName = generateRandomName();
        board = createBoard();
        lists = parseList(createList(board.getId(), randomName));
        lists = parseList(listRequestBuilder()
            .setMethod(PUT)
            .setName(randomName)
            .buildRequest()
            .sendRequest(LISTS_ENDPOINT + lists.getId())
            .then().extract().response());
        assertThat(lists.getName(), equalTo(randomName));
    }
}
