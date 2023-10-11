package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.entity.Reponse;
import fr.workshop.respectboundsbackend.repo.ExperienceRepository;
import fr.workshop.respectboundsbackend.repo.ReponseRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {


    private final ExperienceRepository experienceRepository;

    private final ReponseRepository reponseRepository;


    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository, ReponseRepository reponseRepository) {
        this.experienceRepository = experienceRepository;
        this.reponseRepository = reponseRepository;
    }


    public Optional<Experience> getExperienceById(Long id){
        return experienceRepository.findById(id);
    }


    public ResponseEntity<Experience> addExperience(Experience experience) {
        if(experience == null || experience.getText() == null || experience.getType() == null ){
            return new ResponseEntity<Experience>(HttpStatus.NO_CONTENT);
        }
        experienceRepository.save(experience);
        return new ResponseEntity<Experience>(HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> getMoyenneExp(Long id) {

        Optional<Experience> experience = experienceRepository.findById(id);

        if(experience.isPresent()){
            List<Reponse> listOfReponse = reponseRepository.findByExperience(experience.get());
            if(!listOfReponse.isEmpty()){
                int total = 0;

                for (Reponse reponse : listOfReponse) {
                    total += reponse.getScore();
                }
                Integer moyenne =  total/ listOfReponse.size();
                return new ResponseEntity<>(moyenne, HttpStatus.OK);

            }else{
                return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
            }

        }else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);

        }
    }
}
