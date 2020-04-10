package rs.java.ocrsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.java.ocrsystem.model.Graphic;

@Repository
public interface GraphicRepository extends CrudRepository<Graphic, Integer> {
}
