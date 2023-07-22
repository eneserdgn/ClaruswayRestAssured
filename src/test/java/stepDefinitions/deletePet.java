package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.deletePet.Response.deletePetResponse;
import utils.requestSpecificationFactory;

import static org.hamcrest.Matchers.lessThan;

public class deletePet {

    RequestSpecification request = requestSpecificationFactory.getRequestSpecification();
    Response response;

    @When("delete requesti çalıştırılır {int}")
    public void deleteRequestiÇalıştırılır(int id) {
        response = request.baseUri("https://petstore.swagger.io/v2").pathParam("petId", id).when().delete("/pet/{petId}");
    }

    @Then("responseun başarıyla geldiği kontrol edilir")
    public void responseunBaşarıylaGeldiğiKontrolEdilir() {
        response
                .then()
                .statusCode(200)
                .time(lessThan(2000L)).log().all();

        deletePetResponse deletePetResponse = response.as(pojo.deletePet.Response.deletePetResponse.class);
        Assert.assertEquals(deletePetResponse.getCode(), 200, "hata mesajı");
        Assert.assertEquals(deletePetResponse.getMessage(), "145782", "hata mesajı");
        Assert.assertEquals(deletePetResponse.getType(), "unknown", "hata mesajı");
    }
}
