package tn.esprit.tpfoyer.service;

import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre GetChambreById(Long idChambre);
    List<Chambre> getChambres();
    List<Chambre> findByTypeC(TypeChambre typeC);
    Chambre findByNumeroChambre(Long numeroChambre);
    Chambre findByEtudiantByCin(@Param("cin") Long cin);
    void listeChambresParBloc();
    void pourcentageChambreParTypeChambre();
    void nbPlacesDisponibleParChambreAnneeEnCours();
}
