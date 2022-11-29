package br.com.api.new_academy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.new_academy.entities.Exercise_User;

@Repository
public interface Exercise_UserRepository extends CrudRepository<Exercise_User, Long> {

}
