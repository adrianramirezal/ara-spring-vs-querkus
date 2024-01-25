package pt.ara.learniog.frameworks.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pt.ara.learniog.frameworks.quarkus.mode.GreetingResponse;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name="greeting.text")
    String greeting;

    private final DieRollerService dieRollerService;

    public GreetingService(DieRollerService dieRollerService) {
        this.dieRollerService = dieRollerService;
    }

    public GreetingResponse getGreeting(){
        GreetingResponse response = new GreetingResponse();
        response.setGreeting(this.greeting);
        response.setDieRoll(this.dieRollerService.getRoll());
        return response;
    }
}
