package pt.ara.learnig.frameworks.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DieRollerService {
    @Value("${die.sides}")
    private int sides;

    public int getRoll() {
        return (int) (Math.random() * sides) + 1;
    }
}
