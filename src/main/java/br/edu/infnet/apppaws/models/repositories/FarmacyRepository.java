package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmacyRepository extends JpaRepository<Farmacy, Integer> {
}
