package pt.ara.learnig.frameworks.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingResponse {
    private String greeting;
    private int dieRoll;
}
