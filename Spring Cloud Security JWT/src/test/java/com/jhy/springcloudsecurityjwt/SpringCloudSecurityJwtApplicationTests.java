package com.jhy.springcloudsecurityjwt;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class SpringCloudSecurityJwtApplicationTests {

    @Test
    void contextLoads() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTY2NzYyNzAsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiNzQxMTk5OGUtNzAwOC00MjRlLTlmYWQtZTZiNDcxMzg4MjAwIiwiY2xpZW50X2lkIjoiYWRtaW4iLCJzY29wZSI6WyJhbGwiXX0.O-X_vUEeADmxSIZCrlkZHcdLkFP3TDAZ4JlpifR8ph8";

        Object obj = Jwts.parser()
                .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();

        System.out.println(obj);
    }

}
