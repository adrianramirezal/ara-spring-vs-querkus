package pt.ara.learnig.frameworks.spring.webservise;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.ara.learnig.frameworks.spring.data.entity.RoomEntity;
import pt.ara.learnig.frameworks.spring.data.repository.RoomRepository;
import pt.ara.learnig.frameworks.spring.exception.BadRequestException;
import pt.ara.learnig.frameworks.spring.exception.NotFoundException;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public Iterable<RoomEntity> getRooms(){
        return this.roomRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public RoomEntity addRoom(@RequestBody RoomEntity room){
        return this.roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public RoomEntity getRoom(@PathVariable(value="id")long id){
        Optional<RoomEntity> room = this.roomRepository.findById(id);
        if (room.isEmpty()){
            throw new NotFoundException("room with id: " + id + " not found");
        }
        return room.get();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoom(@PathVariable(value="id") long id, @RequestBody RoomEntity room){
        if(room.getRoomId() != id){
            throw new BadRequestException("id mismatch on update");
        }
        this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value=HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable(value="id")long id){
        this.roomRepository.deleteById(id);
    }
}
