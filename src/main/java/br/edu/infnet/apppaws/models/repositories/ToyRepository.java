package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}
