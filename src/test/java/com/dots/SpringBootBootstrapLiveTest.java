//package java.com.dots;
//
//import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
//import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import java.util.List;
//
//import com.dots.persistence.model.Category;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//
//import org.junit.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class SpringBootBootstrapLiveTest {
//
//    private static final String API_ROOT = "http://localhost:8080/api/categories";
//
//    @Test
//    public void whenGetAllCategories_thenOK() {
//        final Response response = RestAssured.get(API_ROOT);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//    }
//
//    @Test
//    public void whenGetCategoriesByName_thenOK() {
//        final Category category = createRandomCategory();
//        createCategoryAsUri(category);
//
//        final Response response = RestAssured.get(API_ROOT + "/title/" + book.getTitle());
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//        assertTrue(response.as(List.class).size() > 0);
//    }
//
//    @Test
//    public void whenGetCreatedCategoryById_thenOK() {
//        final Category category = createRandomCategory();
//        final String location = createCategoryAsUri(category);
//
//        final Response response = RestAssured.get(location);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//        assertEquals(category.getName_category(), response.jsonPath().get("name_category"));
//    }
//
//    @Test
//    public void whenGetNotExistCategoryById_thenNotFound() {
//        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
//        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
//    }
//
//    // POST
//    @Test
//    public void whenCreateNewCategory_thenCreated() {
//        final Category category = createRandomCategory();
//
//        final Response response = RestAssured.given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(category)
//                .post(API_ROOT);
//        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
//    }
//
//    @Test
//    public void whenInvalidCategory_thenError() {
//        final Category category = createRandomCategory();
//        category.setParcentage_value(0);
//
//        final Response response = RestAssured.given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(category)
//                .post(API_ROOT);
//        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
//    }
//
//    @Test
//    public void whenUpdateCreatedCategory_thenUpdated() {
//        final Category category = createRandomCategory();
//        final String location = createCategoryAsUri(category);
//
//        category.setId(Long.parseLong(location.split("api/categories/")[1]));
//        category.setParcentage_value(40);
//        Response response = RestAssured.given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(category)
//                .put(location);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//
//        response = RestAssured.get(location);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//        assertEquals(40, response.jsonPath()
//                .get(50));
//
//    }
//
//    @Test
//    public void whenDeleteCreatedCategory_thenOk() {
//        final Category category = createRandomCategory();
//        final String location = createCategoryAsUri(category);
//
//        Response response = RestAssured.delete(location);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//
//        response = RestAssured.get(location);
//        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
//    }
//
//    // ===============================
//
//    private Category createRandomCategory() {
//        final Category category = new Category();
//        category.setName_category(randomAlphabetic(10));
//        category.setParcentage_value(20);
//        return category;
//    }
//
//
//    private String createCategoryAsUri(Category category) {
//        final Response response = RestAssured.given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(category)
//                .post(API_ROOT);
//        return API_ROOT + "/" + response.jsonPath()
//                .get("id");
//    }
//
//}