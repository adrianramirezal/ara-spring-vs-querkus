package pt.ara.learniog.frameworks.quarkus.mode;

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
