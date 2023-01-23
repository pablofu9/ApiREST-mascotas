package controller;

import entity.Dueno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DuenoService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/")
public class DuenoRestController {

    @Autowired
    private DuenoService service;

    @GetMapping("/dueno")
    public List<Dueno> findAllDuenos(){
        return service.findAllDuenos();
    }
    @GetMapping("/dueno/{duenoId}")
    public Dueno getUser(@PathVariable int duenoId){
        Dueno dueno = service.findByIdDueno(duenoId);

        if(dueno == null) {
            throw new RuntimeException("User id not found -"+duenoId);
        }
        //retornará al usuario con id pasado en la url
        return dueno;
    }
}
