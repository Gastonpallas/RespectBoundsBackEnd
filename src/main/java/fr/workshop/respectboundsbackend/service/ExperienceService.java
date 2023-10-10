package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.repo.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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



}
