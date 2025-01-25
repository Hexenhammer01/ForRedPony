package api
import io.restassured.RestAssured
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test


class ApiTest {

    @Test
    fun `validate GET endpoint`() {
        RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/todos/1")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
            .body("userId", equalTo(1))
            .body("id", equalTo(1))
            .body("title", equalTo("delectus aut autem"))
            .body("completed", equalTo(false))
    }
}