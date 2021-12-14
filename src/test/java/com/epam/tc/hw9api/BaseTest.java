package com.epam.tc.hw9api;

import static com.epam.tc.hw9api.steps.BoardSteps.deleteAllBoards;

import com.epam.tc.hw9api.beans.Board;
import com.epam.tc.hw9api.beans.Lists;
import org.testng.annotations.AfterClass;

public class BaseTest {
    Board board;
    Lists lists;

    @AfterClass
    public void tearDown() {
        deleteAllBoards();
    }
}
