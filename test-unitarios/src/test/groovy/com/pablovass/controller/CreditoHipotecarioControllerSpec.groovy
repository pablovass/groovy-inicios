package com.pablovass.controller



import cl.bci.salesforce.client.dto.DocumentoDesistimientoResponseDTO
import cl.bci.salesforce.model.desistimiento.command.DocumentoDesistimientoCommand
import cl.bci.salesforce.model.desistimiento.usecase.DocDesistimientoUseCase
import cl.bci.mscore.logger.LogUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.test.context.support.WithMockUser
import spock.lang.Specification
import spock.lang.Subject
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = ["spring.cloud.vault.enabled=false"])
class CreditoHipotecarioControllerSpec extends Specification {

    @Subject
    CreditoHipotecarioController creditoHipotecarioController

    @MockBean
    DocDesistimientoUseCase docDesistimientoUseCase

    @Autowired
    MockMvc mockMvc

    def "Test para verificar el envío de desistimiento"() {
        given:
        DocumentoDesistimientoCommand documentoDesistimientoCommand = new DocumentoDesistimientoCommand( "12345678-9", "valor","dsd","dsd","sdsd","fdf","dsd","dsdsdsd")

        when:
        ResponseEntity<DocumentoDesistimientoResponseDTO> response = creditoHipotecarioController.enviarDesistimiento(documentoDesistimientoCommand)

        then:
        response.getStatusCodeValue() == 200
    }

    // Otros métodos de prueba
}
