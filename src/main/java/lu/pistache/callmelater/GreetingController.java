package lu.pistache.callmelater;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);
    final static String DEX_PROD = "api.dexcom.com";
    final static String DEX_SAND = "sandbox-api.dexcom.com";
    static final String REDIRECT_URI = "https://callmelater.herokuapp.com/greeting";
    String DEX_HOST = DEX_SAND;


    @GetMapping("/greeting")
    public void greeting(@RequestParam(value = "code") String code, @RequestParam(value = "state", defaultValue = "") String state) throws IOException {
        logger.info("Got code " + code);
        OkHttpClient client = new OkHttpClient();

        String clientId = "weP9DT4racO6xmu5iDG94M7j73bpqbW5";
        String clientSecret = "mpoSSYGpd5owOmvX";

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_secret=" +
                clientSecret +
                "&client_id=" +
                clientId +
                "&code=" +
                code +
                "&grant_type=authorization_code&redirect_uri=" +
                REDIRECT_URI +
                "");
        Request request = new Request.Builder()
                .url("https://" + DEX_HOST + "/v2/oauth2/token")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        logger.info("Got access token response " + response.toString());
    }
}