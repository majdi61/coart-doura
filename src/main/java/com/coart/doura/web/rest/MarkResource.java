package com.coart.doura.web.rest;

import com.coart.doura.domain.Mark;
import com.coart.doura.service.MarkService;
import com.turkraft.springfilter.boot.Filter;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;

import java.util.Optional;

@RestController
@RequestMapping("/api/mark")
public class MarkResource {

    private final MarkService markService;


    public MarkResource(MarkService markService) {
        this.markService = markService;
    }
    @CrossOrigin("https://coart-doura.web.app/")
    @PostMapping(path = "")
    public ResponseEntity<Mark> saveMark(@RequestBody Mark mark) {
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(markService.saveMark(mark)));
    }

    @CrossOrigin("https://coart-doura.web.app/")
    @GetMapping(path = "")
    public Page<Mark> getMarksPage(@Filter(entityClass = Mark.class) Document document, Pageable pageable) {
        return markService.getMarksPage(document, pageable);
    }

    @CrossOrigin("https://coart-doura.web.app/")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Mark> getMarkById(@PathVariable String id) {
        return ResponseUtil.wrapOrNotFound(markService.getMarkById(id));
    }

    @CrossOrigin("https://coart-doura.web.app/")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        markService.deleteMark(id);
    }

}
