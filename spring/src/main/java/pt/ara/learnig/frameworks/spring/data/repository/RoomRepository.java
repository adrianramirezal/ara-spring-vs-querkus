package pt.ara.learnig.frameworks.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import pt.ara.learnig.frameworks.spring.data.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
}
