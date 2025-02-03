package api
import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Extract
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test






class ApiTests {

    @Test
    fun `GET findByAvailableStatus`() {
        RestAssured.given()
            .baseUri(env1.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=available")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)
            .body("status", hasItem("available"))
            .body("status", not(hasItem("sold")))
            .body("status", not(hasItem("pending")))

    }

    @Test
    fun `GET findByPendingStatus`() {
        RestAssured.given()
            .baseUri(env1.baseURI)
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
            .baseUri(env1.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/pet/findByStatus?status=sold")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)

    }

    @Test
    fun `GET returnsAMapOfStatusCodesToQuantities`() {
        RestAssured.given()
            .baseUri(env1.baseURI)
            .log().all() // Логирование всех параметров запроса
            .`when`()
            .get("/v2/store/inventory")
            .then()
            .log().all() // Логирование всех параметров ответа
            .statusCode(200)

    }

    @Test
    fun `POST addANewPetToTheStore`() {
        val requestBody = mapOf(
            "id" to 0,
            "category" to mapOf(
                "id" to 0,
                "name" to "string"
            ),
            "name" to "MyPetMyPet",
            "photoUrls" to listOf("string"),
            "tags" to listOf(
                mapOf(
                    "id" to 0,
                    "name" to "string"
                )
            ),
            "status" to "available"
        )

        RestAssured
            .given()
            .baseUri(env1.baseURI)
            .contentType("application/json")
            .body(requestBody)
            .`when`()
            .post("/v2/pet")
            .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo("MyPetMyPet"))
            .body("status", equalTo("available"))


    }


    @Test
    fun `DELETE DeletesPet`() {
        val requestBody = mapOf(
            "id" to 0,
            "category" to mapOf(
                "id" to 0,
                "name" to "string"
            ),
            "name" to "MyPetMyPet",
            "photoUrls" to listOf("string"),
            "tags" to listOf(
                mapOf(
                    "id" to 0,
                    "name" to "string"
                )
            ),
            "status" to "available"
        )

        val petId: Long = RestAssured
            .given()
            .baseUri(env1.baseURI)
            .contentType("application/json")
            .body(requestBody)
            .`when`()
            .post("/v2/pet")
            .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo("MyPetMyPet"))
            .body("status", equalTo("available"))
            .extract()
            .path("id")

        RestAssured
            .given()
            .baseUri(env1.baseURI)
            .header("api_key", "special-key")
            .`when`()
            .delete("/v2/pet/$petId")
            .then()
            .log().all()
            .statusCode(200)

//        RestAssured.given()
//            .baseUri(env1.baseURI)
//            .log().all() // Логирование всех параметров запроса
//            .`when`()
//            .get("/v2/pet/$petId")
//            .then()
//            .log().all() // Логирование всех параметров ответа
//            .statusCode(404)
    }






//    @Test
//    fun `GET findPet`() {
//        RestAssured.given()
//            .baseUri(env1.baseURI)
//            .log().all() // Логирование всех параметров запроса
//            .`when`()
//            .get("/v2/pet/9223372036854091958")
//            .then()
//            .log().all() // Логирование всех параметров ответа
//            .statusCode(200)
//    }



}