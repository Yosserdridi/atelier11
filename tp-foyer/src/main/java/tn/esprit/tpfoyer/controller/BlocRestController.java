package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@Tag(name = "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.getBlocs();
        return listBlocs;
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blId) {
        Bloc bloc = blocService.GetBlocById(blId);
        return bloc;
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blId) {
        blocService.deleteBloc(blId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.updateBloc(b);
        return bloc;
    }
    @PostMapping("/addBlocAndFoyerToAssign")
    public Bloc addBlocAndFoyerToAssign(@RequestBody Bloc b){
        Bloc bloc = blocService.addBlocAndFoyerToAssign(b);
        return bloc;
    }
    @PutMapping("/assignFoyerToBloc/{blocId}/{foyerId}")
    public void assignFoyerToBloc(@PathVariable ("blocId") Long blocId,@PathVariable("foyerId") Long foyerId){
        blocService.assignFoyerToBloc(blocId,foyerId);
    }
    @PutMapping ("removeBlocFromFoyer/{blocId}/{foyerId}")
    public void removeBlocFromFoyer(@PathVariable("blocId")Long blocId, @PathVariable("foyerId")Long foyerId) {
        blocService.removeBlocFromFoyer(blocId, foyerId);
    }
    @GetMapping("/findByFoyerIsNull")
    public List<Bloc> findByFoyerIsNull(){
        List<Bloc> blocs = blocService.findByFoyerIsNull();
        return blocs;
    }
    @GetMapping("/findByFoyerCapaciteFoyerGreaterThan/{capaciteFoyer}")
    public List<Bloc> findByFoyerCapaciteFoyerGreaterThan(@PathVariable("capaciteFoyer") Long capaciteFoyer){
        List<Bloc> blocs = blocService.findByFoyerCapaciteFoyerGreaterThan(capaciteFoyer);
        return blocs;
    }
    @GetMapping("/findByNomBlocStartingWith/{nomBloc}")
    public List<Bloc> findByNomBlocStartingWith(@PathVariable("nomBloc") String nomBloc){
        List<Bloc> blocs = blocService.findByNomBlocStartingWith(nomBloc);
        return blocs;
    }
    @GetMapping("/findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith/{capaciteFoyer}/{nomBloc}")
    public List<Bloc> findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(@PathVariable("capaciteFoyer") Long capaciteFoyer,@PathVariable("nomBloc") String nomBloc){
        List<Bloc> blocs = blocService.findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(capaciteFoyer,nomBloc);
        return blocs;
    }
}
