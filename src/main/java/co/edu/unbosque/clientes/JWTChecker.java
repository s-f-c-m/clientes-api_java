package co.edu.unbosque.clientes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JWTChecker {

    public JWTChecker() {}

    public boolean doFilter(Map<String, String> headers) {
        String authorizationHeader = headers.get("authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{

                String token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(("nA4QjrndALVotmHd0gG2fUHxLcJ6BA9IW0gPUkREMsykPUP-IA-Q6s_a_CUanCE0BpfVpGIlzGNg9QhYly2m7ZtSaNmhRyrdZBHYuoTR1qTFg5CNNjp0-5Tym75K5YNH3nWGXIgy-dfy3wsh3Dwm-8Aaj4xtIqNqacyRMcrPTck").getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decoded = verifier.verify(token);
                String username = decoded.getSubject();
                String[] roles = decoded.getClaim("roles").asArray(String.class);
                if (username != null){
                    return true;
                }
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
            }
        return false;
        }
    }
