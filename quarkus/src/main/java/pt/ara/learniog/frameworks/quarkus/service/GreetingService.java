package pt.ara.learniog.frameworks.quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pt.ara.learniog.frameworks.quarkus.data.entity.GuestEntity;
import pt.ara.learniog.frameworks.quarkus.data.entity.RoomEntity;
import pt.ara.learniog.frameworks.quarkus.data.repository.GuestRepository;
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
    final GuestRepository guestRepository;

    public GreetingService(DieRollerService dieRollerService, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.dieRollerService = dieRollerService;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    public GreetingResponse getGreeting(){
        GreetingResponse response = new GreetingResponse();
        response.setGreeting(this.greeting);
        response.setDieRoll(this.dieRollerService.getRoll());
        List<RoomEntity> rooms = this.roomRepository.listAll();
        List<String> roomNumbers = new ArrayList<>();
        rooms.forEach(room->roomNumbers.add(room.getRoomNumber()));
        response.setRoomNumbers(roomNumbers);
        List<GuestEntity> guests = this.guestRepository.listAll();
        List<String> emailAddresses = new ArrayList<>();
        guests.forEach(guest->emailAddresses.add(guest.getEmailAddress()));
        response.setEmailAddresses(emailAddresses);
        return response;
    }
}
