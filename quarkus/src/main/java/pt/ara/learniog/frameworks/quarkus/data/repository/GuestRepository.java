package pt.ara.learniog.frameworks.quarkus.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pt.ara.learniog.frameworks.quarkus.data.entity.GuestEntity;

@ApplicationScoped
public class GuestRepository implements PanacheRepository<GuestEntity> {
}
