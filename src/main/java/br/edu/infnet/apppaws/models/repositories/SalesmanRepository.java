package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Integer> {

    Optional<Salesman> findFirstByEmail(String email);
}
