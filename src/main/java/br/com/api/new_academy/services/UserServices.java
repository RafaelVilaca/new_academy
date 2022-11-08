package br.com.api.new_academy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.new_academy.entities.User;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository ur;

    @Autowired
    private ResponseModel rm;

    // Método para listar os usuários existentes
    public Iterable<User> listar() {
        return ur.findAll();
    }

    // Método para listar os usuários existentes
    public User buscar(long codigo) {
        return ur.findById(codigo).orElse(new User());
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(User u, String acao) {
        if (u.getNome().equals("")) {
            rm.setMessage("O Nome do usuário é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (u.getLogin().equals("")) {
            rm.setMessage("O Login do usuário é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (u.getSenha().equals("")) {
            rm.setMessage("A Senha do usuário é obrigatória!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (u.getDocumento().equals("")) {
            rm.setMessage("O Documento do usuário é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (acao == "cadastrar") {
            return new ResponseEntity<User>(ur.save(u), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(ur.save(u), HttpStatus.OK);
        }
    }

    // Método para remover usuário
    public ResponseEntity<ResponseModel> remover(long codigo) {
        ur.deleteById(codigo);

        rm.setMessage("O usuário foi removido com sucesso!");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }

}
