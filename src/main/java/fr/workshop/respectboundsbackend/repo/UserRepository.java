package fr.workshop.respectboundsbackend.repo;

import fr.workshop.respectboundsbackend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
