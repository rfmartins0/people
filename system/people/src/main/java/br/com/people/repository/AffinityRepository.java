package br.com.people.repository;

import br.com.people.domain.AffinityEntity;
import org.springframework.data.repository.CrudRepository;

public interface AffinityRepository extends CrudRepository<AffinityEntity, String> {
}