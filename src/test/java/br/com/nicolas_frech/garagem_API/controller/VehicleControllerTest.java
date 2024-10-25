package br.com.nicolas_frech.garagem_API.controller;

import br.com.nicolas_frech.garagem_API.repository.VehicleRepository;
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

@AutoConfigureMockMvc
@SpringBootTest
class VehicleControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    VehicleRepository vehicleRepository;

    @Test
    @DisplayName("Deveria retornar código 400 para registro de veículo com erros")
    void scenary01() throws Exception {
        //ARRANGE
        String json = "{}";

        //ACT
        var response = mvc.perform(
                post("/veiculos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT

        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Deveria retornar código 200 para registro de veiculo sem erros")
    void scenary02() throws Exception {
        //ARRANGE
        String json = """
                {
                	"brand" : "veiculo",
                	"model" : "XM",
                	"color" : "Vermelho",
                	"plate" : "2345642",
                	"type" : "CAR"
                }
                """;

        //ACT
        var response = mvc.perform(
                post("/veiculos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(200, response.getStatus());
    }
}