package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.*;

public class TestAPI {

    @Test
    public void testRequest() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        // Параметры запроса
        request.param("foo1", "bar1");
        request.param("foo2", "bar2");

        // Отправка запроса
        System.out.println("Отправка запроса");
        Response response = request.get("/get");

        // Проверка кода ответа
        try {
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);

            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args.foo1", equalTo("bar1"));
            response.then().body("args.foo2", equalTo("bar2"));
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.x-request-start", startsWith("t="));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));
            response.then().body("url", equalTo("http://postman-echo.com/get?foo1=bar1&foo2=bar2"));

            System.out.println("Успешно");
        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }


    @Test
    public void testPostRaw() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        //Строка для отправки в теле запроса.
        String requestBody = "This is expected to be sent back as part of response body.";

        System.out.println("Отправка POST запроса");
        Response response = request.body(requestBody).post("/post");

        try {

            // Проверка кода ответа
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);

            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args", is(emptyMap()));
            response.then().body("data", equalTo(requestBody));
            response.then().body("files", is(emptyMap()));
            response.then().body("form", is(emptyMap()));
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.content-length", equalTo("58"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));
            response.then().body("url", equalTo("http://postman-echo.com/post"));

            System.out.println("Успешно");

        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }


    @Test
    public void testFormData() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        // Данные для отправки в теле запроса
        String formParam1 = "bar1";
        String formParam2 = "bar2";

        request.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        // Отправка POST-запроса с формой
        System.out.println("Отправка POST-запроса");
        Response response = request
                .formParam("foo1", formParam1)
                .formParam("foo2", formParam2)
                .post("/post");

        try {

            // Проверка кода ответа
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);

            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args", is(emptyMap()));
            response.then().body("data", equalTo(""));
            response.then().body("files", is(emptyMap()));

            // Проверка для поля form
            response.then().body("form.foo1", equalTo(formParam1));
            response.then().body("form.foo2", equalTo(formParam2));

            // Исправленная проверка для поля json
            response.then().body("json.foo1", equalTo(formParam1));
            response.then().body("json.foo2", equalTo(formParam2));

            response.then().body("url", equalTo("http://postman-echo.com/post"));

            // Проверка заголовков
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));

            System.out.println("Успешно");

        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }


    @Test
    public void testPutRequest() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        // Данные для отправки в теле запроса
        String requestBody = "This is expected to be sent back as part of response body.";

        // Отправка POST-запроса
        System.out.println("Отправка POST-запроса");
        Response response = request.body(requestBody).post("/post");

        try {

            // Проверка кода ответа
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);

            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args", is(emptyMap()));
            response.then().body("data", equalTo(requestBody));
            response.then().body("files", is(emptyMap()));
            response.then().body("form", is(emptyMap()));
            response.then().body("json", is(nullValue()));
            response.then().body("url", equalTo("http://postman-echo.com/post"));

            // Проверка заголовков
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.content-length", equalTo("58"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));

            System.out.println("Успешно");

        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }

    @Test
    public void PatchRequest() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        // Данные для отправки в теле запроса
        String requestBody = "This is expected to be sent back as part of response body.";

        // Отправка PATCH-запроса
        System.out.println("Отправка PATCH-запроса");
        Response response = request.body(requestBody).patch("/patch");

        try {

            // Проверка кода ответа
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);


            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args", is(emptyMap()));
            response.then().body("data", equalTo(requestBody));
            response.then().body("files", is(emptyMap()));
            response.then().body("form", is(emptyMap()));
            response.then().body("json", is(nullValue()));
            response.then().body("url", equalTo("http://postman-echo.com/patch"));

            // Проверка заголовков
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.content-length", equalTo("58"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));

            System.out.println("Успешно");

        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }


    @Test
    public void testDeleteRequest() {

        // Базовый URL
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = given();

        // Отправка DELETE-запроса
        System.out.println("Отправка DELETE-запроса");
        Response response = request.delete("/delete");

        try {

            // Проверка кода ответа
            System.out.println("Проверка кода ответа");
            response.then().statusCode(200);

            // Проверка тела ответа
            System.out.println("Проверка тела ответа");
            response.then().body("args", is(emptyMap()));
            response.then().body("data", is(emptyMap()));
            response.then().body("files", is(emptyMap()));
            response.then().body("form", is(emptyMap()));
            response.then().body("json", is(nullValue()));
            response.then().body("url", equalTo("http://postman-echo.com/delete"));

            // Проверка заголовков
            response.then().body("headers.host", equalTo("postman-echo.com"));
            response.then().body("headers.x-forwarded-proto", equalTo("http"));
            response.then().body("headers.connection", equalTo("close"));
            response.then().body("headers.x-forwarded-port", equalTo("443"));
            response.then().body("headers.x-amzn-trace-id", startsWith("Root="));
            response.then().body("headers.accept", equalTo("*/*"));
            response.then().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.11)"));
            response.then().body("headers.accept-encoding", equalTo("gzip,deflate"));
            response.then().body("headers.content-type", equalTo("application/json"));

            System.out.println("Успешно");

        } catch (AssertionError e) {
            logError(response);
            throw e; // Пробрасываем исключение дальше, чтобы тест не прошел
        }
    }

    private void logError(Response response) {
        System.err.println("Ошибка в тесте:");
        System.err.println("Код ответа: " + response.getStatusCode());
        System.err.println("Тело ответа: " + response.getBody().asString());
    }
}
