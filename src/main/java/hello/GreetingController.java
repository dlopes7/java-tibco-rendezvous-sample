package hello;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import com.dynatrace.oneagent.sdk.api.OneAgentSDK;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynatrace.oneagent.sdk.OneAgentSDKFactory;



@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public static OneAgentSDK oneAgentSdk = OneAgentSDKFactory.createInstance();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        SendObject t = new SendObject();

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
