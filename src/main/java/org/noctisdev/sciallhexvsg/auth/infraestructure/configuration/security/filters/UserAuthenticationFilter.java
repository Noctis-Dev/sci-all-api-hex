package org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.jwt.JwtConfig;
import org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user.UserAuthDto;
import org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user.UserDetailsImpl;
import org.noctisdev.sciallhexvsg.auth.infraestructure.dto.response.JwtResponse;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.sql.Date;

@AllArgsConstructor
public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        UserAuthDto userAuthDto;

        try {
            userAuthDto = new ObjectMapper().readValue(request.getReader(), UserAuthDto.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                userAuthDto.getEmail(),
                userAuthDto.getPassword()
        );

        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        Date expirationDate = jwtConfig.getExpirationDate();
        String token = Jwts.builder()
                .setSubject(userDetails.getName())
                .claim("authorities", userDetails.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(expirationDate)
                .signWith(secretKey).compact();

        Date refreshTokenExpirationDate = jwtConfig.getRefreshExpirationDate();
        String refreshToken = Jwts.builder()
                .setSubject(userDetails.getName())
                .setIssuedAt(new java.util.Date())
                .setExpiration(refreshTokenExpirationDate)
                .signWith(secretKey).compact();

        response.addHeader("Authorization", jwtConfig.getTokenPrefix() + token);

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(token);
        jwtResponse.setRefreshToken(refreshToken);

        BaseResponse baseResponse = BaseResponse.builder()
                .data(jwtResponse)
                .message("Successfully authenticated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(new ObjectMapper().writeValueAsString(baseResponse));
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }

}
