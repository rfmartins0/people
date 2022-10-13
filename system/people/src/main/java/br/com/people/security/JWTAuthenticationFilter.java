package br.com.people.security;

import br.com.people.dto.TokenDto;
import br.com.people.exception.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends GenericFilterBean {

    private static final String AUTH_HEADER = "Authorization";

    @Value("${jwt.url}")
    private String urlAuth;

    @Value("${jwt.filter.less}")
    private String filterLess;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, request.getServletContext());
        final HttpServletRequest requestHttp = (HttpServletRequest) request;
        final String token = requestHttp.getHeader(AUTH_HEADER);
        var restTemplate = new RestTemplate();
        if (isShouldFilter(requestHttp)) {
            try {
                var tokenDto = new TokenDto();
                tokenDto.setToken(token);
                HttpEntity<TokenDto> tokenHttpEntity= new HttpEntity<>(tokenDto);
                ResponseEntity<TokenDto> result = restTemplate.postForEntity(urlAuth, tokenHttpEntity, TokenDto.class);
                if (!result.getStatusCode().is2xxSuccessful()) {
                    throw new TokenException("Token Inválido");
                }
            } catch (Exception e) {
                throw e;
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean isShouldFilter(final HttpServletRequest requestHttp) {
        final String[] filterArray = this.filterLess.split(",");
        for (String filter : filterArray) {
            if (requestHttp.getRequestURL().indexOf(filter) != -1) {
                return false;
            }
        }
        return true;
    }

}