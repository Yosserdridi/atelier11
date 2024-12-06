package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc GetBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public List<Bloc> getBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBlocAndFoyerToAssign(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void assignFoyerToBloc(Long blocId, Long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        Foyer foyer = foyerRepository.findById(foyerId).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }
    @Override
    public void removeBlocFromFoyer(Long blocId, Long foyerId) {
        Bloc b = blocRepository.findById(blocId).get();
        b.setFoyer(null);
        blocRepository.save(b);
    }

    @Override
    public List<Bloc> findByFoyerIsNull() {
        return blocRepository.findByFoyerIsNull();
    }

    @Override
    public List<Bloc> findByFoyerCapaciteFoyerGreaterThan(Long capaciteFoyer) {
        return blocRepository.findByFoyerCapaciteFoyerGreaterThan(capaciteFoyer);
    }

    @Override
    public List<Bloc> findByNomBlocStartingWith(String nomBloc) {
        return blocRepository.findByNomBlocStartingWith(nomBloc);
    }

    @Override
    public List<Bloc> findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(Long capaciteFoyer, String nomBloc) {
        return blocRepository.findByFoyerCapaciteFoyerGreaterThanAndNomBlocStartingWith(capaciteFoyer,nomBloc);
    }
}
