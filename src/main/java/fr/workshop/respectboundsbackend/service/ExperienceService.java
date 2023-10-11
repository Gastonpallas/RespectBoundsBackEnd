package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.entity.Reponse;
import fr.workshop.respectboundsbackend.repo.ExperienceRepository;
import fr.workshop.respectboundsbackend.repo.ReponseRepository;
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        experienceRepository.save(experience);
        return new ResponseEntity<>(experience, HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> getMoyenneExp(Long id) {

        Optional<Experience> experience = experienceRepository.findById(id);

        if(experience.isPresent()){
            List<Reponse> listOfReponse = reponseRepository.findByExperience(experience.get());
            if(!listOfReponse.isEmpty()){
                Integer moyenne = calculMoyenne(listOfReponse);
                return new ResponseEntity<>(moyenne, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }


    private Integer calculMoyenne(List<Reponse> list){
        int total = 0;

        for (Reponse reponse : list) {
            total += reponse.getScore();
        }
        return  total / list.size();
    }

    public ResponseEntity<Integer> getMoyenneTotal(List<Long> listId) {

        if (!listId.isEmpty()){
            int totalTotal = 0;
            for(Long idExp : listId){
                Optional<Experience> experienceOptional = experienceRepository.findById(idExp);
                Experience experience = new Experience();
                if (experienceOptional.isPresent()){
                    experience = experienceOptional.get();
                }
                List<Reponse> listOfReponse = reponseRepository.findByExperience(experience);
                if(!listOfReponse.isEmpty()) {
                    totalTotal += calculMoyenne(listOfReponse);
                }
            }
            Integer moyenneTotal = totalTotal / listId.size();

            return new ResponseEntity<>(moyenneTotal, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
