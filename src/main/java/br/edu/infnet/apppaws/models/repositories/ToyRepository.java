package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Toy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ToyRepository extends CrudRepository<Toy, UUID> {
}
