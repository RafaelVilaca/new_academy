package br.com.api.new_academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.new_academy.entities.Exercise;
import br.com.api.new_academy.entities.ExerciseTraining;
import br.com.api.new_academy.services.ExerciseServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseServices es;

    @GetMapping("/")
    public String rota() {
        return "API de exercícios funcionando!";
    }

    @GetMapping("/listar")
    public List<ExerciseTraining> listar() {
        return es.listar();
    }

    @GetMapping("/buscar/{codigo}")
    public Exercise buscar(@PathVariable long codigo) {
        return es.buscar(codigo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Exercise u) {
        return es.cadastrarAlterar(u, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Exercise u) {
        return es.cadastrarAlterar(u, "alterar");
    }

    @PutMapping("/desativarAtivar/{codigo}")
    public ResponseEntity<Exercise> desativarAtivar(@PathVariable long codigo) {
        return es.desativarAtivar(codigo);
    }
}
