package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.addNewPet.Request.Category;
import pojo.addNewPet.Request.Tag;
import pojo.addNewPet.Request.addNewPetRequest;
import utils.requestSpecificationFactory;

import java.util.ArrayList;

import static org.hamcrest.Matchers.lessThan;

public class findPetByStatus {

    RequestSpecification request = requestSpecificationFactory.getRequestSpecification();
    Response response;
    @Given("set baseURI {string}")
    public void setBaseURI(String url) {
        request.baseUri(url);
    }

    @Given("set param {string}, {string}")
    public void setParam(String paramKey, String paramValue) {
        request.pathParam(paramKey, paramValue);
    }

    @Given("set queryParam {string}, {string}")
    public void setQueryParam(String queryKey, String queryParam) {
        request.queryParam(queryKey, queryParam);
    }

    @Given("set header {string}, {string}")
    public void setHeader(String headerKey, String headerValue) {
        request.header(headerKey, headerValue);
    }

    @Given("set body {string}")
    public void setBody(String body) {
        request.body(body);
    }

    @When("send get request {string}")
    public void sendGetRequest(String url) {
        request.when().get(url);
    }

    @When("send post request {string}")
    public void sendPostRequest(String url) {
        response = request.when().post(url);
    }

    @When("send put request {string}")
    public void sendPutRequest(String url) {
        request.when().put(url);
    }

    @When("send delete request {string}")
    public void sendDeleteRequest(String url) {
        request.when().delete(url);
    }

    @Then("check status code {int}")
    public void checkStatusCode(int status) {
        request.then().statusCode(status);
    }

    @Then("check time less than {string}")
    public void checkTimeLessThan(String time) {
        request.then().time(lessThan(Long.valueOf(time)));
    }

    @Then("check schema validation")
    public void checkSchemaValidation() {
    }

    @Then("check body {string}, {string}")
    public void checkBody(String arg0, String arg1) {
    }


    @Given("set body for add a new pet to store {int}")
    public void setBodyForAddANewPetToStore(int id) {
        addNewPetRequest addNewPetRequest = new addNewPetRequest();
        addNewPetRequest.setId(id);
        addNewPetRequest.setName("Karabaş");
        addNewPetRequest.setStatus("available");

        ArrayList<Tag> tagList = new ArrayList<>();
        Tag tag1 = new Tag();
        tag1.setId(1);
        tag1.setName("Kopek");
        Tag tag2 = new Tag();
        tag2.setId(2);
        tag2.setName("blabla");
        tagList.add(tag1);
        tagList.add(tag2);
        addNewPetRequest.setTags(tagList);

        ArrayList<String> photoUrlList = new ArrayList<>();
        photoUrlList.add("dsasadsad");
        photoUrlList.add("sadsadsadsa");
        photoUrlList.add("asddsadasdsadsa");
        addNewPetRequest.setPhotoUrls(photoUrlList);


        Category category = new Category();
        category.setId(1);
        category.setName("Çoban Köpeği");
        addNewPetRequest.setCategory(category);

        request.body(addNewPetRequest);
    }

    @Then("check response body find pet by status")
    public void checkResponseBodyFindPetByStatus() {

    }

    @Then("check response body add a new pet")
    public void checkResponseBodyAddANewPet() {
        response.prettyPrint();
    }

    @Given("{int} idli köpek oluşturulur")
    public void idliKöpekOluşturulur(int id) {
        addNewPetRequest addNewPetRequest = new addNewPetRequest();
        addNewPetRequest.setId(id);
        addNewPetRequest.setName("Karabaş");
        addNewPetRequest.setStatus("available");

        ArrayList<Tag> tagList = new ArrayList<>();
        Tag tag1 = new Tag();
        tag1.setId(1);
        tag1.setName("Kopek");
        Tag tag2 = new Tag();
        tag2.setId(2);
        tag2.setName("blabla");
        tagList.add(tag1);
        tagList.add(tag2);
        addNewPetRequest.setTags(tagList);

        ArrayList<String> photoUrlList = new ArrayList<>();
        photoUrlList.add("dsasadsad");
        photoUrlList.add("sadsadsadsa");
        photoUrlList.add("asddsadasdsadsa");
        addNewPetRequest.setPhotoUrls(photoUrlList);


        Category category = new Category();
        category.setId(id);
        category.setName("Çoban Köpeği");
        addNewPetRequest.setCategory(category);

        request.baseUri("https://petstore.swagger.io/v2").header("Content-Type","application/json").body(addNewPetRequest).when().post("/pet");
    }
}
