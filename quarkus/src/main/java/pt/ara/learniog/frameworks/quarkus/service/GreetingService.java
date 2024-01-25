package pt.ara.learniog.frameworks.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pt.ara.learniog.frameworks.quarkus.data.entity.RoomEntity;
import pt.ara.learniog.frameworks.quarkus.data.repository.RoomRepository;
import pt.ara.learniog.frameworks.quarkus.mode.GreetingResponse;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name="greeting.text")
    String greeting;

    private final DieRollerService dieRollerService;
    private final RoomRepository roomRepository;

    public GreetingService(DieRollerService dieRollerService, RoomRepository roomRepository) {
        this.dieRollerService = dieRollerService;
        this.roomRepository = roomRepository;
    }

    public GreetingResponse getGreeting(){
        GreetingResponse response = new GreetingResponse();
        response.setGreeting(this.greeting);
        response.setDieRoll(this.dieRollerService.getRoll());

        List<RoomEntity> rooms = this.roomRepository.listAll();
        List<String> roomNumbers = new ArrayList<>();
        rooms.forEach(room->roomNumbers.add(room.getRoomNumber()));
        response.setRoomNumbers(roomNumbers);
        return response;
    }
}
