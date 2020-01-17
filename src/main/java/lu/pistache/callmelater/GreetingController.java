package lu.pistache.callmelater;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);


    @GetMapping("/greeting")
    public void greeting(@RequestParam(value = "code") String code, @RequestParam(value = "state", defaultValue = "") String state) {
        logger.info("Got code" + code);
    }
}