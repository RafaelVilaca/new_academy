package br.com.api.new_academy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.new_academy.entities.ExerciseUser;

@Repository
public interface ExerciseUserRepository extends CrudRepository<ExerciseUser, Long> {

}
