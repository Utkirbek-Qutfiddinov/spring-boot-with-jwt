package uz.utkirbek.springbootwithjwt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: utkirbek.
 * Time: 19:51:59
 * Date: July 14, 2023, Friday
 */

@Component
public class JwtProvider {
    final long expireTime=3_600_000;//an hour
    final String secretKey="UtkirbekQutfiddinov14061998";

    public String generateToken(String username){
        long currentTimeMillis=System.currentTimeMillis();

        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis+expireTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getSubjectFromToken(String token){
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
