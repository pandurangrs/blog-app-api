package com.blog.common.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {

	
	public static final long JWT_TOKEN_VALIDITY= 5 * 60 * 60;
	
	private String secret="jwtTokenKey";
	
	
	//retrive username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token,Claims::getSubject);
	}

	
	//retrive expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token,Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token,Function<Claims,T> claimsResolver) {
		final Claims claims=getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	
	//for retrieving any information form token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration=getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//generate token from user
	public String generateToken(UserDetails userDetails) {
		Map<String ,Object> cliams=new HashMap<>();
		return doGenerateToken(cliams,userDetails.getUsername());
		
	}
	
	
	//while creating the token
	//1.Define claims of the token, like Issuer,Expiration,Subject,and the ID
	//2.Sign the JWT using the HSS12 algirithm and secret key
	//3. According to Jws compact Serialization(https:..tools.ietf.org/html/draft-ietf-jose
	//compaction of the JWT to URL-safe string
	
	private String doGenerateToken(Map<String,Object> claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
	
	
	
	
	
}
