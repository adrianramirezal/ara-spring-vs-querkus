package pt.ara.learnig.frameworks.spring.webservise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ara.learnig.frameworks.spring.model.GreetingResponse;
import pt.ara.learnig.frameworks.spring.service.GreetingService;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public GreetingResponse getGreeting(){
        return this.greetingService.getGreeting();
    }
}
