package br.com.nicolas_frech.garagem_API.controller;

import br.com.nicolas_frech.garagem_API.service.ParkingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingService parkingService;

    @Test
    @DisplayName("Deve retornar código 400 para registro com erros")
    void scenary01() throws Exception {
        //ARRANGE
        String json = "{}";

        //ACT
        var response = mvc.perform(
                post("/estacionamento")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();


        //ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Deve retornar código 200 para registro sem erros")
    void scenary02() throws Exception {
        //ARRANGE
        String json = """
                {
                "name" : "Estacionamento",
               	"cnpj" : "81.474.316/0001-17",
               	"address" : {
               		"street" : "Rua das Flores",
               		"district" : "Vila Velha",
               		"cep" : "88345432",
               		"city" : "Curitiba",
               		"state" : "Paraná",
               		"number" : "222"
               	    },
               	"phone" : "47993456829",
               	"bikeSpace" : "10",
               	"carSpace" : "15"
               	}
                """;

        //ACT
        var response = mvc.perform(
                post("/estacionamento")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();


        //ASSERT
        assertEquals(200, response.getStatus());
    }

}