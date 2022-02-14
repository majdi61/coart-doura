package com.coart.doura.service;


import com.coart.doura.client.RemoteClient;
import com.coart.doura.domain.Mark;
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
public class MarkService {

    private final MarkRepository markRepository;


    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;

    }

    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    public Page<Mark> getMarksPage(Document document, Pageable pageable) {
        document = Optional.ofNullable(document).orElse(new Document());

        return markRepository.filter(document, pageable);
    }

    public Optional<Mark> getMarkById(String id) {
        return markRepository.findById(id);
    }


    public void deleteMark(String id) {
        markRepository.findById(id).ifPresent(markRepository::delete);
    }


}
