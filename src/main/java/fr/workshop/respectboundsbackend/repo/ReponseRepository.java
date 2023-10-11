package fr.workshop.respectboundsbackend.repo;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.entity.Reponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends CrudRepository<Reponse, Long> {
    List<Reponse> findByExperience (Experience experience);

}
