package tecnling.euporia.restful.euporiarestful;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.json.JSONObject;
import tecnling.euporia.restful.euporiarestful.utils.LoginHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;

@Path("login")
public class LoginResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String authenticate(String json){
        JSONObject jsonObject = new JSONObject(json);
        boolean isLoggedIn = LoginHelper.login(jsonObject.getString("username"), jsonObject.getString("password"));
        if (isLoggedIn){
            try{
                Algorithm algorithm = Algorithm.HMAC256("euporia_restful");
                String token = JWT.create().withIssuer("euporiarestful").sign(algorithm);
                return new JSONObject()
                        .put("success", true)
                        .put("token", token).toString();
            } catch (UnsupportedEncodingException | JWTCreationException e){
                return new JSONObject().put("success", false).toString();
            }
        } else {
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String verifyToken(@QueryParam("token") String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("euporia_restful");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("euporiarestful")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return new JSONObject().put("success", true).toString();
        } catch (UnsupportedEncodingException | JWTVerificationException e){
            return new JSONObject().put("success", false).toString();
        }
    }
}
