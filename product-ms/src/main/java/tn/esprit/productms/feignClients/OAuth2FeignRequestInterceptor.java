package tn.esprit.productms.feignClients;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;


@Configuration
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AbstractOAuth2Token accessToken = (AbstractOAuth2Token) authentication.getCredentials();
        template.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, accessToken.getTokenValue()));
    }
}