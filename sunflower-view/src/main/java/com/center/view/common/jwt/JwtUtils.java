package com.center.view.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Date;

public class JwtUtils {

    /**
     * 过期时间为1分钟
     */
    private static final long expiredTimeMillis = 1000 * 60;

    /**
     * 密钥key
     */
    private static final String secretKey = "357ff1e8-8795-47ea-9bd0-e8416e629f52";

    public static String createJwt(String jsonSubject) {

        long currentTimeMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(new Date(currentTimeMillis))
                .setSubject(jsonSubject)
                .signWith(SignatureAlgorithm.HS256, createKey());

        builder.setExpiration(new Date(currentTimeMillis + expiredTimeMillis));

        return builder.compact();

    }

    public static Claims parsingJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(createKey()) // 设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置解析jwt
    }

    private static SecretKey createKey() {
        byte[] encodedKey = Base64.decodeBase64(secretKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

}
