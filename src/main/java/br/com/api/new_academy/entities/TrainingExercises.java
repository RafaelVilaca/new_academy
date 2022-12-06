package br.com.api.new_academy.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//getter e setter são configurados automaticamente por conta do lombok
@Getter
@Setter
public class TrainingExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String musculoFocal;
    private Boolean ativo;
    private List<Exercise> exercises;
}
