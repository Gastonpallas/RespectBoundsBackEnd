package fr.workshop.respectboundsbackend.Controller;

import fr.workshop.respectboundsbackend.entity.Reponse;
import fr.workshop.respectboundsbackend.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/workshop/reponse")
@CrossOrigin
public class ReponseController {

    private final ReponseService reponseService;

    @Autowired
    public ReponseController(ReponseService reponseService) {
        this.reponseService = reponseService;
    }

    @PostMapping
    public ResponseEntity<Reponse> addReponse(@RequestBody Reponse reponse){

        return reponseService.addReponse(reponse);

    }


}
