package com.epam.tc.hw9api.specifications;

import static com.epam.tc.hw9api.constants.Constants.ID;
import static com.epam.tc.hw9api.constants.Constants.NAME;

import com.epam.tc.hw9api.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BoardService extends BaseService {

    public BoardService(Method requestMethod, Map<String, String> parameters) {
        super(parameters, requestMethod);
    }

    public static Board parseBoard(Response rs) {
        return new Gson().fromJson(rs.asString().trim(), new TypeToken<Board>() {
        }.getType());
    }

    public static BoardRequestBuilder boardRequestBuilder() {
        return new BoardRequestBuilder();
    }

    public static class BoardRequestBuilder {

        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public BoardRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public BoardRequestBuilder setId(String id) {
            parameters.put(ID, id);
            return this;
        }

        public BoardRequestBuilder setName(String name) {
            parameters.put(NAME, name);
            return this;
        }

        public BoardService buildRequest() {
            return new BoardService(requestMethod, parameters);
        }

    }
}
