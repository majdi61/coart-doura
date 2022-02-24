package com.coart.doura.service;


import com.coart.doura.client.RemoteClient;
import com.coart.doura.domain.Itineraire;
import com.coart.doura.domain.Mark;
import com.coart.doura.repository.ItineraireRepository;
import com.coart.doura.repository.MarkRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Service
public class ItineraireService {

    private final ItineraireRepository itineraireRepository;

    private final MarkRepository markRepository;

    private final RemoteClient remoteClient;

    public ItineraireService(ItineraireRepository itineraireRepository, MarkRepository markRepository, RemoteClient remoteClient) {
        this.itineraireRepository = itineraireRepository;
        this.markRepository = markRepository;
        this.remoteClient = remoteClient;
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
        itineraireRepository.findById(id).ifPresent(itineraireRepository::delete);
    }

    public Object getRoutingPath(String id1, String id2) {

        Mark startMark = markRepository.findById(id1).get();
        Mark endMark = markRepository.findById(id2).get();
        return remoteClient.callRemoteAddressObject(URI.create("https://api.mapbox.com/directions/v5/mapbox/walking/" + startMark.getLatitude() + "," + startMark.getLongitude() + ";" + endMark.getLatitude() + "," + endMark.getLongitude() + "?geometries=geojson&access_token=pk.eyJ1IjoibWFhem91biIsImEiOiJja3lvYzhzZm4ycG4xMnBwMGhhdTd0dzJ1In0.SErz9UjpAZE6k_6tnYYmfA"));
    }

}
