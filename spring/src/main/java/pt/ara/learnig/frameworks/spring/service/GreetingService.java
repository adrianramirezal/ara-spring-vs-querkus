package pt.ara.learnig.frameworks.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pt.ara.learnig.frameworks.spring.model.GreetingResponse;

@Service
public class GreetingService {

    @Value("${greeting.text}")
    private String greeting;

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
