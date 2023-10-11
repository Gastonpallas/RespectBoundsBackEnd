package fr.workshop.respectboundsbackend.repo;

import fr.workshop.respectboundsbackend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long> {

}
