package br.com.lanchonete.drivers.web.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.lanchonete.core.adapters.base.BaseController;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@Consumes(MediaType.APPLICATION_JSON + ";charsert=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charsert=utf-8")
@OpenAPIDefinition(info = @Info(title = "Exemplo API", version = "1.0.0"))
public abstract class RestBase<D extends BaseController> {

    @Inject
    protected D controller;

    @Inject
    ObjectMapper objectMapper;

    /*
     * @SuppressWarnings("unchecked")
     * 
     * @POST
     * public Response inserir(A atapter) {
     * controller.salvar(atapter);
     * return respostaSucesso();
     * }
     */
    protected Response respostaSucesso() {

        ObjectNode exceptionJson = objectMapper.createObjectNode();
        exceptionJson.put("messagem", "Inserido com Sucesso");
        exceptionJson.put("code", 201);

        return Response.status(201)
                .entity(exceptionJson)
                .build();
    }

    protected Response respostaSucesso(String messagem) {

        ObjectNode exceptionJson = objectMapper.createObjectNode();
        exceptionJson.put("messagem", messagem);
        exceptionJson.put("code", 201);

        return Response.status(201)
                .entity(exceptionJson)
                .build();
    }

    protected Response respostaSucesso(String messagem, Integer code) {
        ObjectNode exceptionJson = objectMapper.createObjectNode();
        exceptionJson.put("messagem", messagem);
        exceptionJson.put("code", code);

        return Response.status(code)
                .entity(exceptionJson)
                .build();
    }

    protected Response respostaErro() {

        ObjectNode exceptionJson = objectMapper.createObjectNode();
        exceptionJson.put("messagem", "Não foi possível atender à solicitação");
        exceptionJson.put("code", 400);

        return Response.status(400)
                .entity(exceptionJson)
                .build();
    }
}
