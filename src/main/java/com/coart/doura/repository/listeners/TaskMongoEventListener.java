package com.coart.doura.repository.listeners;

import com.coart.doura.domain.Task;
import com.coart.doura.repository.SequenceGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class TaskMongoEventListener extends AbstractMongoEventListener<Task> {

    private final SequenceGeneratorRepository sequenceGeneratorRepository;

    @Autowired
    public TaskMongoEventListener(SequenceGeneratorRepository sequenceGeneratorRepository) {
        this.sequenceGeneratorRepository = sequenceGeneratorRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Task> event) {
        if (event.getSource().getUiid() < 1) {
            event.getSource().setUiid(sequenceGeneratorRepository.generateSequence(Task.SEQUENCE_NAME_UIID));
        }
    }

}
