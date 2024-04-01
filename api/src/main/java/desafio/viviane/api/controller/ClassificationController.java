package desafio.viviane.api.controller;

import desafio.viviane.api.domain.Classification;
import desafio.viviane.api.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classificacoes")
public class ClassificationController {

    @Autowired
    ClassificationRepository classificationRepository;

    @PostMapping
    public ResponseEntity<Classification> cadastrar(@RequestBody Classification classification) {
        classificationRepository.save(classification);
        return ResponseEntity.status(201).body(classification);
    }
}
