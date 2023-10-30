package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Salesman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SalesmanRepository extends CrudRepository<Salesman, Integer> {

    Optional<Salesman> findFirstByEmail(String email);
}
