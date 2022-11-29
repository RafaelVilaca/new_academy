package br.com.api.new_academy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.new_academy.entities.Exercise;
import br.com.api.new_academy.entities.ExerciseTraining;
import br.com.api.new_academy.models.ResponseModel;
import br.com.api.new_academy.repositories.ExerciseRepository;
import br.com.api.new_academy.repositories.TrainingRepository;

@Service
public class ExerciseServices {

    @Autowired
    private ExerciseRepository er;
    private TrainingRepository tr;

    @Autowired
    private ResponseModel rm;

    // Método para listar os usuários existentes
    public List<ExerciseTraining> listar() {
        Iterable<Exercise> exercises = er.findAll();
        List<ExerciseTraining> tExercise = new ArrayList<ExerciseTraining>();
        exercises.forEach(ex -> {
            tExercise.add(new ExerciseTraining(
                    ex.codigo,
                    ex.equipamento,
                    ex.numeroAparelho,
                    ex.ativo,
                    ex.treinoCodigo,
                    tr.findById(ex.treinoCodigo).orElse(null)));
        });
        return tExercise;
    }

    // Método para listar os usuários existentes
    public Exercise buscar(long codigo) {
        return er.findById(codigo).orElse(new Exercise());
    }

    // Método para cadaserar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(Exercise t, String acao) {
        if (t.getEquipamento().equals("")) {
            rm.setMessage("O Equipamento é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        if (t.getNumeroAparelho().equals("")) {
            rm.setMessage("O Musculo Focal é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }

        if (acao == "cadastrar") {
            return new ResponseEntity<Exercise>(er.save(t), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Exercise>(er.save(t), HttpStatus.OK);
        }
    }

    public ResponseEntity<Exercise> desativarAtivar(long codigo) {
        Exercise oldExercise = er.findById(codigo).orElse(new Exercise());
        oldExercise.setAtivo(!oldExercise.getAtivo());
        return new ResponseEntity<Exercise>(er.save(oldExercise), HttpStatus.OK);
    }

    public List<Exercise> seeAllExercisesOfTraining(Long codigo) {
        List<Exercise> exercises = er.findByTreinoCodigo(codigo);
        return exercises;
    }
}
