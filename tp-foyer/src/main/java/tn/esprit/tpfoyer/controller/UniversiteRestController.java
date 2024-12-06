package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;


import java.util.List;

@Tag(name = "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;
    @Operation(description = "récupérer toutes les universites de la base de données")
    @GetMapping ("/retrieve-AllUniversites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.getUniversites();
        return listUniversites;
    }

    @GetMapping ("/retrieve-Universite/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        Universite universite = universiteService.GetUniversiteById(id);
        return universite;
    }

    @PostMapping ("/add-Universite")
    public Universite addUniversite(@RequestBody Universite b) {
        Universite universite = universiteService.addUniversite(b);
        return universite;
    }

    @DeleteMapping ("/remove-Universite/{id}")
    public void removeUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    @PutMapping ("/modify-Universite")
    public Universite modifyUniversite(@RequestBody Universite b) {
        Universite universite = universiteService.updateUniversite(b);
        return universite;
    }
}