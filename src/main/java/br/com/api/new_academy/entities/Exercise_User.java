package br.com.api.new_academy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//getter e setter são configurados automaticamente por conta do lombok
@Entity
@Table(name = "exercicios_usuario")
@Getter
@Setter
public class Exercise_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Integer repeticoes;
    private Integer numeroSerie;
    private Boolean ativo;
    private Long exercicio_codigo;
    private Long usuario_codigo;
}
