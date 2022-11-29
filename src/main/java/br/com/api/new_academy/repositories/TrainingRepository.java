package br.com.api.new_academy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.new_academy.entities.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

}
