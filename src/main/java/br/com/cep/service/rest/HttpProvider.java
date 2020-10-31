package br.com.cep.service.rest;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class HttpProvider {
	
	private final ObjectMapper objectMapper;
	
	@Autowired
	public HttpProvider(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public <R> R get(String baseUrl, Map<String, String> queryParams, Map<String, String> headers, Class<R> type) {
        try{
        	final String fullPath = baseUrl ;
            return WebClient.create(fullPath).get().headers(h -> h.setAll(headers)).retrieve().bodyToMono(type).block();
        } catch (WebClientResponseException e) {
            log.error("Erro na requisição", e);
            try {
                return objectMapper.readValue(e.getResponseBodyAsByteArray(), type);
            } catch (IOException ex) {
                log.error("Erro ao acessar api", ex);
                throw new RuntimeException(baseUrl, e);
            }
        }
    }

}
