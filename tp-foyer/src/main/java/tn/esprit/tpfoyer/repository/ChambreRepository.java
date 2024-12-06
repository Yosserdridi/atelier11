package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeC(TypeChambre typeC);
    Chambre findByNumeroChambre(Long numeroChambre);
    @Query("SELECT chambre FROM Chambre chambre"
    + " JOIN chambre.reservations reservation"
            +" JOIN reservation.etudiants etudiant"
    + " WHERE etudiant.cin=:cin")
    Chambre findByEtudiantByCin(@Param("cin") Long cin);
}
