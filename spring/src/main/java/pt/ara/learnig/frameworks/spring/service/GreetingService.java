package pt.ara.learnig.frameworks.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pt.ara.learnig.frameworks.spring.data.entity.GuestEntity;
import pt.ara.learnig.frameworks.spring.data.entity.RoomEntity;
import pt.ara.learnig.frameworks.spring.data.repository.GuestRepository;
import pt.ara.learnig.frameworks.spring.data.repository.RoomRepository;
import pt.ara.learnig.frameworks.spring.model.GreetingResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingService {

    @Value("${greeting.text}")
    private String greeting;

    private final DieRollerService dieRollerService;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public GreetingService(DieRollerService dieRollerService, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.dieRollerService = dieRollerService;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    public GreetingResponse getGreeting(){
        GreetingResponse response = new GreetingResponse();
        response.setGreeting(this.greeting);
        response.setDieRoll(this.dieRollerService.getRoll());
        Iterable<RoomEntity> rooms = this.roomRepository.findAll();
        List<String> roomNumbers = new ArrayList<>();
        rooms.forEach(room->roomNumbers.add(room.getRoomNumber()));
        response.setRoomNumbers(roomNumbers);
        Iterable<GuestEntity> guests = this.guestRepository.findAll();
        List<String> emailAddresses = new ArrayList<>();
        guests.forEach(guest->emailAddresses.add(guest.getEmailAddress()));
        response.setEmailAddresses(emailAddresses);
        return response;
    }
}
