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
import pt.ara.learnig.frameworks.spring.data.entity.GuestEntity;
import pt.ara.learnig.frameworks.spring.data.repository.GuestRepository;
import pt.ara.learnig.frameworks.spring.exception.BadRequestException;
import pt.ara.learnig.frameworks.spring.exception.NotFoundException;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Iterable<GuestEntity> getGuests(){
        return this.guestRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public GuestEntity addGuest(@RequestBody GuestEntity guest){
        return this.guestRepository.save(guest);
    }
    
    @GetMapping("/{id}")
    public GuestEntity getGuest(@PathVariable(value = "id")long id){
        Optional<GuestEntity> guest = this.guestRepository.findById(id);
        if(guest.isEmpty()){
            throw new NotFoundException("guest not found: id " + id);
        }
        return guest.get();
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGuest(@PathVariable(value="id")long id, @RequestBody GuestEntity guest){
        if(guest.getGuestId() != id){
            throw new BadRequestException("incoming id does not match model");
        }
        this.guestRepository.save(guest);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable(value="id")long id){
        this.guestRepository.deleteById(id);
    }
}
