package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService foyerService;
    @Operation(description = "récupérer toutes les foyers de la base de données")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyer() {
        List<Foyer> listFoyer = foyerService.getFoyers();
        return listFoyer;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long fId) {
        Foyer foyer = foyerService.GetFoyerById(fId);
        return foyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        Foyer foyer1 = foyerService.addFoyer(foyer);
        return foyer1;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long fId ) {
        foyerService.deleteFoyer(fId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-foyer
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        Foyer foyer1 = foyerService.updateFoyer(foyer);
        return foyer;
    }
}