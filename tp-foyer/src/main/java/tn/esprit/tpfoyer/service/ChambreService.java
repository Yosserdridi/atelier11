package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
    BlocService blocService;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre GetChambreById(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    //@Scheduled(fixedDelay = 15000)
    //@Scheduled(fixedRate = 15000)
    //@Scheduled(cron = "45 58 10 * * *" )
    @Override
    public List<Chambre> getChambres() {
        List <Chambre> listChambres = chambreRepository.findAll();
        log.info("liste des chambres" + listChambres);
        return  listChambres;
    }

    @Override
    public List<Chambre> findByTypeC(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public Chambre findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Override
    public Chambre findByEtudiantByCin(Long cin) {
        return chambreRepository.findByEtudiantByCin(cin);
    }

  //  @Scheduled(cron = "0 */1 * * * *")
    @Override
    public void listeChambresParBloc() {
        List<Bloc> blocs = blocService.getBlocs(); // Remplacez par une méthode réelle pour récupérer les blocs

        for (Bloc bloc : blocs) {
            log.info("Bloc => {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());
            Set<Chambre> chambres = bloc.getChambres();

            if (chambres.isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                log.info("La liste des chambres pour ce bloc:");
                for (Chambre chambre : chambres) {
                    log.info("NumChambre: {} type: {}", chambre.getNumeroChambre(), chambre.getTypeC());
                }
            }
            log.info("************************");
        }
    }

   // @Scheduled(cron = "0 */1 * * * *") // Every 5 minutes
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll(); // Fetch all chambres

        int totalChambres = chambres.size();
        log.info("Nombre total des chambres: {}", totalChambres);

        if (totalChambres > 0) {
            // Count occurrences of each type
            Map<TypeChambre, Integer> chambresByType = new HashMap<>();

            for (Chambre chambre : chambres) {
                TypeChambre type = chambre.getTypeC();
                chambresByType.put(type, chambresByType.getOrDefault(type, 0) + 1);
            }

            // Calculate and log percentages
            for (Map.Entry<TypeChambre, Integer> entry : chambresByType.entrySet()) {
                TypeChambre type = entry.getKey();
                int count = entry.getValue();
                double percentage = (count * 100.0) / totalChambres;
                log.info("Le pourcentage des chambres pour le type {} est égale à {}%", type, String.format("%.1f", percentage));
            }
        } else {
            log.info("Aucune chambre trouvée.");
        }
    }
    //@Scheduled(cron = "0 */1 * * * *")
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAll(); // Fetch all rooms

        for (Chambre chambre : chambres) {
            // Determine the total capacity based on the type of the room
            int totalCapacity = switch (chambre.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };

            // Count the number of valid reservations for this room
            int occupiedPlaces = (int) chambre.getReservations().stream()
                    .filter(Reservation::isEstValide) // Only count valid reservations
                    .count();

            // Calculate available places
            int availablePlaces = totalCapacity - occupiedPlaces;

            // Log the results
            if (availablePlaces <= 0) {
                log.info("La chambre {} est complète", chambre.getTypeC());
            } else {
                log.info("Le nombre de places disponible pour la chambre {} est {}",
                        chambre.getTypeC(), availablePlaces);
            }
        }
    }
}
