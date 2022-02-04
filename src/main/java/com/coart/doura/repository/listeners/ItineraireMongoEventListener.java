package com.coart.doura.repository.listeners;

import com.coart.doura.domain.Itineraire;
import com.coart.doura.domain.Itineraire;
import com.coart.doura.repository.SequenceGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class ItineraireMongoEventListener extends AbstractMongoEventListener<Itineraire> {

    private final SequenceGeneratorRepository sequenceGeneratorRepository;

    @Autowired
    public ItineraireMongoEventListener(SequenceGeneratorRepository sequenceGeneratorRepository) {
        this.sequenceGeneratorRepository = sequenceGeneratorRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Itineraire> event) {
        if (event.getSource().getUiid() < 1) {
            event.getSource().setUiid(sequenceGeneratorRepository.generateSequence(Itineraire.SEQUENCE_NAME_UIID));
        }
    }

}
