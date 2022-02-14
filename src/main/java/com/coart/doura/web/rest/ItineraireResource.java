package com.coart.doura.web.rest;

import com.coart.doura.domain.Itineraire;
import com.coart.doura.service.ItineraireService;
import com.coart.doura.service.ItineraireService;
import com.turkraft.springfilter.boot.Filter;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;

import java.util.Optional;

@RestController
@RequestMapping("/api/itineraire")
public class ItineraireResource {

    private final ItineraireService itineraireService;


    public ItineraireResource(ItineraireService itineraireService) {
        this.itineraireService = itineraireService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Itineraire> saveItineraire(@RequestBody Itineraire itineraire) {
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(itineraireService.saveItineraire(itineraire)));
    }


    @GetMapping(path = "")
    public Page<Itineraire> getItinerairesPage(@Filter(entityClass = Itineraire.class) Document document, Pageable pageable) {
        return itineraireService.getItinerairesPage(document, pageable);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Itineraire> getItineraireByIdAndRemovedFalse(@PathVariable String id) {
        return ResponseUtil.wrapOrNotFound(itineraireService.getItineraireByIdAndRemovedFalse(id));
    }

    @GetMapping(path = "/rout/{id1}/{id2}")
    public Object getRoutingPath(@PathVariable String id1, @PathVariable String id2) {
        return itineraireService.getRoutingPath(id1, id2);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        itineraireService.deleteItineraire(id);
    }

}
