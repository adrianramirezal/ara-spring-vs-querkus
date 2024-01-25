package pt.ara.learniog.frameworks.quarkus.data.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pt.ara.learniog.frameworks.quarkus.data.entity.RoomEntity;

@ApplicationScoped
public class RoomRepository implements PanacheRepository<RoomEntity> {
}
