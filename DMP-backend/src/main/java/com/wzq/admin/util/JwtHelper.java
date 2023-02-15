package com.wzq.admin.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

/**
 * jwt : json-web-token
 * <p>
 * 用户登陆时，后端会根据用户信息来生成一个JWT令牌并返回给前端，
 * 前端的后续请求就可以带着JWT令牌来向后端发送请求
 * <p>
 * 无需重复登陆
 *
 * @author wzq
 * @create 2023-02-13 16:29
 */
public class JwtHelper {

    private static long tokenExpiration = 7L * 24 * 60 * 60 * 1000;
    private static Key key = Keys.hmacShaKeyFor("abcdefghijklmnopqrstuvwxyzasdfasdfsadfasdfasdf".getBytes());

    public static String createToken(Long userId, String userName) {
        return Jwts.builder()
                .setSubject("P2P-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(key)
                .compact();
    }

    public static Long getUserId(String token) {
        try {
            if (token == null) {
                return null;
            }

            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String userId = claims.get("userId").toString();
            return Long.parseLong(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserName(String token) {
        try {
            if (token == null) {
                return null;
            }

            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String userName = claims.get("userName").toString();
            return userName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
