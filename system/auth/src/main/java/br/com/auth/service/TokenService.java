package br.com.auth.service;


import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.auth.dtos.RequestDto;
import br.com.auth.dtos.ResponseDto;
import br.com.auth.security.SecurityUtil;

@Service
public class TokenService {

    @Autowired
    private SecurityUtil securityUtil;

    private static Map<String, String> authMap = new HashMap<>();


    public ResponseDto generateToken(final RequestDto requestDto)  {
        final String hashPassword = securityUtil.createJWT(requestDto.getEmail());
        authMap.put(requestDto.getEmail(), hashPassword);
        var responseDto = new ResponseDto();
        responseDto.setToken(hashPassword);
        return responseDto;
    }

    public boolean checkToken(final String token) {
        String tokenFormat = token.trim();
        boolean bearer = tokenFormat.toLowerCase().contains("bearer ");
        if (bearer){
            tokenFormat = tokenFormat.substring(7, tokenFormat.length()).trim();
        }
        if(this.securityUtil.isExpired(tokenFormat)) {
            return false;
        }
        if (!authMap.containsValue(tokenFormat)) {
            return false;
        }
        return true;
    }
}