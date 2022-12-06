package br.com.api.new_academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.new_academy.entities.ExerciseUser;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.services.ExerciseUserServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/exercise_user")
public class ExerciseUserController {

    @Autowired
    private ExerciseUserServices eus;

    @GetMapping("/")
    public String rota() {
        return "API do treino do usuário funcionando!";
    }

    @GetMapping("/listar")
    public Iterable<ExerciseUser> listar() {
        return eus.listar();
    }

    @GetMapping("/buscar/{codigo}")
    public ExerciseUser buscar(@PathVariable long codigo) {
        return eus.buscar(codigo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ExerciseUser u) {
        return eus.cadastrarAlterar(u, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ExerciseUser u) {
        return eus.cadastrarAlterar(u, "alterar");
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<ResponseModel> deletar(@PathVariable long codigo) {
        return eus.deletar(codigo);
    }
}
