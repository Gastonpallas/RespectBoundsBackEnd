package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.Reponse;
import fr.workshop.respectboundsbackend.repo.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    private final ReponseRepository reponseRepository;

    @Autowired
    public ReponseService(ReponseRepository reponseRepository) {
        this.reponseRepository = reponseRepository;
    }


    public ResponseEntity<Reponse> addReponse(Reponse reponse) {

        if(reponse == null || reponse.getExperience() == null){
            return new ResponseEntity<Reponse>(HttpStatus.NO_CONTENT);
        }
        reponseRepository.save(reponse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
