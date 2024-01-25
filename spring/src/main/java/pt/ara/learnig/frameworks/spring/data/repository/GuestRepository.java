package pt.ara.learnig.frameworks.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import pt.ara.learnig.frameworks.spring.data.entity.GuestEntity;

public interface GuestRepository extends CrudRepository<GuestEntity, Long> {
}
