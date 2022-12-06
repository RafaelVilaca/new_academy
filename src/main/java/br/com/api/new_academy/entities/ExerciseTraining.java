package br.com.api.new_academy.entities;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseTraining {
    private Long codigo;
    private String equipamento;
    private Long numeroAparelho;
    private Boolean ativo;
    private Long treinoCodigo;
    private Optional<Training> treino;

    public ExerciseTraining(Long codigo, String equipamento, Long numeroAparelho, Boolean ativo, Long treinoCodigo,
            Optional<Training> optional) {
        this.codigo = codigo;
        this.equipamento = equipamento;
        this.numeroAparelho = numeroAparelho;
        this.ativo = ativo;
        this.treinoCodigo = treinoCodigo;
        this.treino = optional;
    }
}
