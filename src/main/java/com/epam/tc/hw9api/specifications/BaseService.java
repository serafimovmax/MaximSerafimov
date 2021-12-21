package com.epam.tc.hw9api.specifications;

import static com.epam.tc.hw9api.utils.PropertiesReader.getProperty;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpStatus;

public class BaseService {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final URI BOARD_URI = URI.create(getProperty("baseUri"));
    protected Method requestMethod;
    protected Map<String, String> parameters;

    public BaseService(Map<String, String> parameters, Method requestMethod) {
        this.requestMethod = requestMethod;
        this.parameters = parameters;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .setBaseUri(BOARD_URI)
            .build();
    }

    public Response sendRequest(String path) {
        return RestAssured
            .given(requestSpecification()).log().ifValidationFails()
            .queryParams(parameters)
            .queryParam("key", getProperty("key"))
            .queryParam("token", getProperty("token"))
            .request(requestMethod, BOARD_URI + path)
            .prettyPeek();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectStatusCode(HttpStatus.SC_NOT_FOUND)
            .build();
    }
}
