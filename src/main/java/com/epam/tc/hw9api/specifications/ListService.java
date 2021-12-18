package com.epam.tc.hw9api.specifications;

import com.epam.tc.hw9api.beans.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class ListService extends BaseService {

    public ListService(Method requestMethod, Map<String, String> parameters) {
        super(parameters, requestMethod);
    }

    public static ListRequestBuilder listRequestBuilder() {
        return new ListRequestBuilder();
    }

    public static Lists parseList(Response rs) {
        return new Gson().fromJson(rs.asString().trim(), new TypeToken<Lists>() {
        }.getType());
    }

    public static class ListRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ListRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ListRequestBuilder setId(String id) {
            parameters.put(ID, id);
            return this;
        }

        public ListRequestBuilder setName(String name) {
            parameters.put(NAME, name);
            return this;
        }

        public ListService buildRequest() {
            return new ListService(requestMethod, parameters);
        }
    }
}
