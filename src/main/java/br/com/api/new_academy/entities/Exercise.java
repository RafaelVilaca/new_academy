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
@Table(name = "exercicios")
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;
    public String equipamento;
    public Long numeroAparelho;
    public Boolean ativo;
    public Long treinoCodigo;
}
