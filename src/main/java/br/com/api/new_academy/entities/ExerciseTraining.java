package br.com.api.new_academy.entities;

public class ExerciseTraining {
    private Long codigo;
    private String equipamento;
    private Long numeroAparelho;
    private Boolean ativo;
    private Long treinoCodigo;
    private Training treino;
}

public ExerciseTraining(Long codigo, String equipamento, Long numeroAparelho, Boolean ativo, Long treinoCodigo, Training treino) {
    this.codigo = codigo;
    this.equipamento = equipamento;
    this.numeroAparelho = numeroAparelho;
    this.ativo = ativo;
    this.treinoCodigo = treinoCodigo;
    this.treino = treino;
}
