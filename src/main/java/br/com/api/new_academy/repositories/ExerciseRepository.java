package br.com.api.new_academy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.new_academy.entities.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
