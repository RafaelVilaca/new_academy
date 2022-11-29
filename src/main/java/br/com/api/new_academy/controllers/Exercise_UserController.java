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

import br.com.api.new_academy.entities.Exercise_User;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.services.Exercise_UserServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/exercise_user")
public class Exercise_UserController {

    @Autowired
    private Exercise_UserServices eus;

    @GetMapping("/")
    public String rota() {
        return "API do treino do usuário funcionando!";
    }

    @GetMapping("/listar")
    public Iterable<Exercise_User> listar() {
        return eus.listar();
    }

    @GetMapping("/buscar/{codigo}")
    public Exercise_User buscar(@PathVariable long codigo) {
        return eus.buscar(codigo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Exercise_User u) {
        return eus.cadastrarAlterar(u, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Exercise_User u) {
        return eus.cadastrarAlterar(u, "alterar");
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<ResponseModel> deletar(@PathVariable long codigo) {
        return eus.deletar(codigo);
    }
}
