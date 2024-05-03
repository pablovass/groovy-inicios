package com.pablovass.controller


import com.fasterxml.jackson.databind.ObjectMapper
import com.pablovass.domain.Persona
import spock.lang.Specification
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class PersonaControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    def "Debería retornar una lista de personas cuando se llama al endpoint GET /personas"() {
        given:
        def expectedPersonas = [
                new Persona(id: 1L, nombre: "Juan", edad: 30),
                new Persona(id: 2L, nombre: "María", edad: 25)
        ]
        def personasJson = new ObjectMapper().writeValueAsString(expectedPersonas)

        when:
        def result = mockMvc.perform(get("/personas"))

        then:
        result.andExpect(status().isOk())
                .andExpect(content().json(personasJson))
    }
}
