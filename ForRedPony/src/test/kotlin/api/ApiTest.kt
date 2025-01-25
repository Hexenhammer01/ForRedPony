package api
import io.restassured.RestAssured
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test


class ApiTest {

    @Test
    fun `validate GET endpoint`() {
        RestAssured.given()
            .baseUri("https://petstore.swagger.io")
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=available")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
    }
}