package pt.ara.learnig.frameworks.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GreetingResponse {
    private String greeting;
    private int dieRoll;
    private List<String> roomNumbers;
}
