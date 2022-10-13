package br.com.auth.rest;

import br.com.auth.dtos.TokenDto;
import br.com.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.auth.dtos.RequestDto;
import br.com.auth.dtos.ResponseDto;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping(path = "/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> newToken(@RequestBody final RequestDto requestDto) {
        final ResponseDto responseDto = this.tokenService.generateToken(requestDto);
        final ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<ResponseDto>(responseDto,
                responseDto.getResponseHeaders(), HttpStatus.ACCEPTED);
        return responseEntity;
    }
    @PostMapping(path = "/check", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> check(@RequestBody final TokenDto tokenDto) {
        if (this.tokenService.checkToken(tokenDto.getToken())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}