package br.com.projeto.soap;

import localhost._8080.negocio.PostNegocioRequestPayload;
import localhost._8080.negocio.PostNegocioResponsePayload;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class NegocioResource{

    private static final String NAMESPACE_URI = "http://localhost:8080/negocio";

    @PayloadRoot(localPart = "postNegocioRequestPayload", namespace = NAMESPACE_URI)
    @ResponsePayload
    public PostNegocioResponsePayload lancarNegocios(@RequestPayload PostNegocioRequestPayload request){
        PostNegocioResponsePayload responsePayload = new PostNegocioResponsePayload();
        responsePayload.setStatus("Sucesso");
        return responsePayload;
    }

}
