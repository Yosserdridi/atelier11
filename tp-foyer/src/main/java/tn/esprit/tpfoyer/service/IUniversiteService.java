package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    Universite GetUniversiteById(Long idUniversite);
    List<Universite> getUniversites();
}
