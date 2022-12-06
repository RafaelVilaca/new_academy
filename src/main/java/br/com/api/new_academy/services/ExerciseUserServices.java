package br.com.api.new_academy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.new_academy.entities.ExerciseUser;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.repositories.ExerciseUserRepository;

@Service
public class ExerciseUserServices {

    @Autowired
    private ExerciseUserRepository eur;

    @Autowired
    private ResponseModel rm;

    // Método para listar os usuários existentes
    public Iterable<ExerciseUser> listar() {
        return eur.findAll();
    }

    // Método para listar os usuários existentes
    public ExerciseUser buscar(long codigo) {
        return eur.findById(codigo).orElse(new ExerciseUser());
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ExerciseUser t, String acao) {
        if (t.getRepeticoes().equals("")) {
            rm.setMessage("O Número de Repetições é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (t.getNumeroSerie().equals("")) {
            rm.setMessage("O Número de Séries é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (acao == "cadastrar") {
            return new ResponseEntity<ExerciseUser>(eur.save(t), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ExerciseUser>(eur.save(t), HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseModel> deletar(long codigo) {
        eur.deleteById(codigo);
        rm.setMessage("O exercício foi removido com sucesso para este usuário");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
