package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class requestSpecificationFactory {

    public static ThreadLocal<RequestSpecification> threadLocal = new ThreadLocal<>();

    public static void initializeRequestSpecification() {
        threadLocal.set(RestAssured.given());
    }

    public static RequestSpecification getRequestSpecification() {
        return threadLocal.get();
    }

}
