package br.com.auth.dtos;

import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ResponseDto {

    @JsonIgnore
    private MultiValueMap<String, String> responseHeaders = new LinkedMultiValueMap<String, String>();

    public MultiValueMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setToken(String token) {
        this.responseHeaders.add(HttpHeaders.AUTHORIZATION, token);
    }

}