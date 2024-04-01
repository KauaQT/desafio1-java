package desafio.viviane.api.controller;

import desafio.viviane.api.domain.Livro;
import desafio.viviane.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        livroRepository.save(livro);
        return ResponseEntity.status(201).body(livro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> exibir() {
        if (livroRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livroRepository.findAll());
    }

    @GetMapping("/busca-titulo")
    public ResponseEntity<Livro> buscarPorTitulo(@RequestParam String titulo) {
        List<Livro> livros = livroRepository.findAll();

        for (Livro l : livros) {
            if (l.getTitulo().equals(titulo)) {
                return ResponseEntity.status(200).body(l);
            }
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/busca-ator")
    public ResponseEntity<Livro> buscarPorAutor(@RequestParam String autor) {
        List<Livro> livros = livroRepository.findAll();

        for (Livro l : livros) {
            if (l.getAutor().equals(autor)) {
                return ResponseEntity.status(200).body(l);
            }
        }
        return ResponseEntity.status(400).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable int id, @RequestBody Livro novoLivro) {
        List<Livro> livros = livroRepository.findAll();

        for (Livro l : livros) {
            if (livroRepository.existsById(id)) {
                l.setTitulo(novoLivro.getTitulo());
                l.setAutor(novoLivro.getAutor());
                l.setDataPublicacao(novoLivro.getDataPublicacao());
                l.setComentarios(novoLivro.getComentarios());
                l.setClassificacoes(novoLivro.getClassificacoes());
                return ResponseEntity.status(200).body(l);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}