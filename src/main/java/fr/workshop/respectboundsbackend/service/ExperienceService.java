package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.repo.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceService {


    private final ExperienceRepository experienceRepository;


    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
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
}
