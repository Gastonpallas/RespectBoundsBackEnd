package fr.workshop.respectboundsbackend.Controller;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/workshop/experience")
@CrossOrigin
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }


    @GetMapping
    public ResponseEntity<Experience> getById(@RequestParam Long id){
        Optional<Experience> experience = experienceService.getExperienceById(id);
        if(experience.isPresent()){
            return new ResponseEntity<Experience>(experience.get(), HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<Experience>(HttpStatusCode.valueOf(204));
    }

    @GetMapping("/getMoyenne")
    public ResponseEntity<Integer> getMoyenneExp(@RequestParam Long id){
        return experienceService.getMoyenneExp(id);
    }


    @PostMapping
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience){
        return experienceService.addExperience(experience);
    }

    @PostMapping("/getMoyenneTotal")
    public ResponseEntity<Integer> getMoyenneTotal(@RequestBody Map<String, List<Long>> requestBody) {
        List<Long> experienceIds = requestBody.get("experienceIds");

        return experienceService.getMoyenneTotal(experienceIds);
    }




}
