package desafio.viviane.api.controller;

import desafio.viviane.api.domain.Comment;
import desafio.viviane.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @PostMapping
    public ResponseEntity<Comment> cadastrar(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return ResponseEntity.status(201).body(comment);
    }
}
