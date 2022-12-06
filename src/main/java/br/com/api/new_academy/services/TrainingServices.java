package br.com.api.new_academy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.new_academy.entities.Exercise;
import br.com.api.new_academy.entities.Training;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.repositories.TrainingRepository;

@Service
public class TrainingServices {

    @Autowired
    private TrainingRepository tr;

    @Autowired
    private ResponseModel rm;

    // Método para listar os usuários existentes
    public Iterable<Training> listar() {
        return tr.findAll();
    }

    // Método para listar os usuários existentes
    public Training buscar(long codigo) {
        return tr.findById(codigo).orElse(new Training());
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(Training t, String acao) {
        if (t.getMusculoFocal().equals("")) {
            rm.setMessage("O Musculo Focal é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (acao == "cadastrar") {
            return new ResponseEntity<Training>(tr.save(t), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Training>(tr.save(t), HttpStatus.OK);
        }
    }

    public ResponseEntity<Training> desativarAtivar(long codigo) {
        Training oldTraining = tr.findById(codigo).orElse(new Training());
        oldTraining.setAtivo(!oldTraining.getAtivo());
        return new ResponseEntity<Training>(tr.save(oldTraining), HttpStatus.OK);
    }

    public List<Training> trainingActives() {
        Iterable<Training> trainings = tr.findAll();
        List<Training> trainingActives = new ArrayList<Training>();
        trainings.forEach(ex -> {
            if (ex.getAtivo()) {
                trainingActives.add(ex);
            }
        });
        return trainingActives;
    }

    public List<Exercise> seeAllExercisesOfTraining(Long codigo) {
        List<Exercise> exercises = er.findByTreinoCodigo(codigo);
        return exercises;
    }
}
