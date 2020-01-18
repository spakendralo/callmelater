package lu.pistache.callmelater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lu.pistache.callmelater.model.AccessToken;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;


public class ModelTest {
    @Test
    void accessTokenDeserialize() throws JsonProcessingException {
        String accessTokenString = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IncyYUVpQmRlMXBfNnNjZmMzXzFpeHFvaDVqTSIsImtpZCI6IncyYUVpQmRlMXBfNnNjZmMzXzFpeHFvaDVqTSJ9";
        String string = "{\n" +
                "  \"access_token\": \"" + accessTokenString + "\",\n" +
                "  \"refresh_token\": \"refreshtoken1\",\n" +
                "  \"expires_in\": 600,\n" +
                "  \"token_type\": \"Bearer\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        AccessToken token = mapper.readValue(string, AccessToken.class);
        Assert.that(token.getAccessToken().equals(accessTokenString), "Can't parse correctly");


    }
}
