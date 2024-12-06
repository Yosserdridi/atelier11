package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    Bloc GetBlocById(Long idBloc);
    List<Bloc> getBlocs();
    Bloc addBlocAndFoyerToAssign(Bloc bloc);
    void assignFoyerToBloc(Long blocId,Long foyerId);
    void removeBlocFromFoyer(Long idBloc, Long idFoyer);
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByFoyerCapaciteFoyerGreaterThan(Long capaciteFoyer);
    List<Bloc> findByNomBlocStartingWith(String nomBloc);
    List<Bloc> findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(Long capaciteFoyer,String nomBloc);
}
