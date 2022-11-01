import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {


    /*
    Matchers ile dataları doğrulayınız
            "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"

     */

    @Test
    public void test03() {

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        // Header test
        response.then().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        // Body test
        response.then().
                body("data[4].email",equalTo("charles.morris@reqres.in"),
                        "data[4].first_name",equalTo("Charles"),
                        "data[4].last_name",equalTo("Morris"),
                        "data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"));

    }

    @Test
    public void test04() {

        /*
        Matchers ile dataları doğrulayınız
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"

         */

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        // Header test
        response.then().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        // Body test
        response.then().
                body("data[1].email",equalTo("janet.weaver@reqres.in"),
                        "data[1].first_name",equalTo("Janet"),
                        "data[1].last_name",equalTo("Weaver"),
                        "data[1].avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));

    }
    @Test
    public void test05() {

         /*
        Matchers ile dataları doğrulayınız
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
            "avatar": "https://reqres.in/img/faces/3-image.jpg"
          */

        String url = "http://reqres.in/api/users";
        Response response = given().when().get(url);

        response.then().
                body("data[2].email",equalTo("emma.wong@reqres.in"),
                        "data[2].first_name",equalTo("Emma"),
                        "data[2].last_name",equalTo("Wong"),
                        "data[2].avatar",equalTo("https://reqres.in/img/faces/3-image.jpg"));

    }


}



