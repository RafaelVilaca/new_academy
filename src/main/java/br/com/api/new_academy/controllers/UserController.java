package br.com.api.new_academy.controllers;

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

import br.com.api.new_academy.entities.Login;
import br.com.api.new_academy.entities.User;
import br.com.api.new_academy.services.UserServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServices us;

    @GetMapping("/")
    public String rota() {
        return "API de usuário funcionando!";
    }

    @GetMapping("/listar")
    public Iterable<User> listar() {
        return us.listar();
    }

    @GetMapping("/buscar/{codigo}")
    public User buscar(@PathVariable long codigo) {
        return us.buscar(codigo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody User u) {
        return us.cadastrarAlterar(u, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody User u) {
        return us.cadastrarAlterar(u, "alterar");
    }

    @PutMapping("/desativarAtivar/{codigo}")
    public ResponseEntity<User> desativarAtivar(@PathVariable long codigo) {
        return us.desativarAtivar(codigo);
    }

    @PutMapping("/login")
    public ResponseEntity<User> canLogin(@RequestBody Login login) {
        return us.canLogin(login);
    }

}
