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

import br.com.api.new_academy.entities.Training;
import br.com.api.new_academy.entities.TrainingExercises;
import br.com.api.new_academy.services.TrainingServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/training")
public class TrainingController {

    @Autowired
    private TrainingServices ts;

    @GetMapping("/")
    public String rota() {
        return "API de treino funcionando!";
    }

    @GetMapping("/listar")
    public Iterable<Training> listar() {
        return ts.listar();
    }

    @GetMapping("/buscar/{codigo}")
    public Training buscar(@PathVariable long codigo) {
        return ts.buscar(codigo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Training u) {
        return ts.cadastrarAlterar(u, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Training u) {
        return ts.cadastrarAlterar(u, "alterar");
    }

    @PutMapping("/desativarAtivar/{codigo}")
    public ResponseEntity<Training> desativarAtivar(@PathVariable long codigo) {
        return ts.desativarAtivar(codigo);
    }

    @GetMapping("/trainingActives")
    public List<Training> trainingActives() {
        return ts.trainingActives();
    }

    @GetMapping("/see-all-exercises-of-training/{codigo}")
    public TrainingExercises seeAllExercisesOfTraining(@PathVariable long codigo) {
        return ts.seeAllExercisesOfTraining(codigo);
    }
}
