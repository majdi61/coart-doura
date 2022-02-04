package com.coart.doura.service;


import com.coart.doura.domain.Itineraire;
import com.coart.doura.repository.ItineraireRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ItineraireService {

    private final ItineraireRepository itineraireRepository;

    public ItineraireService(ItineraireRepository itineraireRepository) {
        this.itineraireRepository = itineraireRepository;
    }

    public Itineraire saveItineraire(Itineraire itineraire) {
        return itineraireRepository.save(itineraire);
    }

    public Page<Itineraire> getItinerairesPage(Document document, Pageable pageable) {
        document = Optional.ofNullable(document).orElse(new Document());

        return itineraireRepository.filter(document, pageable);
    }

    public Optional<Itineraire> getItineraireByIdAndRemovedFalse(String id) {
        return itineraireRepository.findById(id);
    }

    public void deleteItineraire(String id) {
        itineraireRepository.findById(id).ifPresent(itineraire -> {
            itineraireRepository.delete(itineraire);
        });
    }

}
