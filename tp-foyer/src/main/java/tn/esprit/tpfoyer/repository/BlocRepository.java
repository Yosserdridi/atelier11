package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByFoyerCapaciteFoyerGreaterThan(Long capaciteFoyer);
    List<Bloc> findByNomBlocStartingWith(String nomBloc);
    List<Bloc> findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(Long capaciteFoyer,String nomBloc);
}
