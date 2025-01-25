package api
import io.restassured.RestAssured
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test


class ApiTest {

    @Test
    fun `GET findByAvailableStatus`() {
        RestAssured.given()
            .baseUri(env.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=available")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
    }

    @Test
    fun `GET findByPendingStatus`() {
        RestAssured.given()
            .baseUri(env.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=pending")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
    }

    @Test
    fun `GET findBySoldStatus`() {
        RestAssured.given()
            .baseUri(env.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=sold")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
    }

    @Test
    fun `GET findPet`() {
        RestAssured.given()
            .baseUri(env.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/9223372036854769000")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
    }



}