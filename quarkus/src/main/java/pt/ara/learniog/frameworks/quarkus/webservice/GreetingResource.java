package pt.ara.learniog.frameworks.quarkus.webservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import pt.ara.learniog.frameworks.quarkus.mode.GreetingResponse;
import pt.ara.learniog.frameworks.quarkus.service.GreetingService;

@Path("/hello")
public class GreetingResource {

    private final GreetingService greetingService;

    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GET
    public GreetingResponse hello() {
        return this.greetingService.getGreeting();
    }
}
