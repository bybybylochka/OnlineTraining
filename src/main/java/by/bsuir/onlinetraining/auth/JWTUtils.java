package by.bsuir.onlinetraining.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
@PropertySource(value = "classpath:jwt.properties")
public class JWTUtils {
    @Value("${spring.jwt.key}")
    private String key;
    @Value("${spring.jwt.expiration}")
    private long expiration;

    public String getTokenHeader() {
        return "Bearer ";
    }

    public String getAuthHeader() {
        return HttpHeaders.AUTHORIZATION;
    }

    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public Date extractExpirationDate(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("password", userDetails.getPassword());
        claims.put("role", userDetails.getAuthorities().toArray()[0]);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(key.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date(System.currentTimeMillis()));
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (userDetails.getUsername().equals(username)) && !isTokenExpired(token);
    }
}
