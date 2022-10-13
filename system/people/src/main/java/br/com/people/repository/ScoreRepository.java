package br.com.people.repository;

import br.com.people.domain.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreEntity, String> {
}