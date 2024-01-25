package pt.ara.learniog.frameworks.quarkus.mode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingResponse {
    private String greeting;
    private int dieRoll;
}
