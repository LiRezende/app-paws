package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmacyRepository extends CrudRepository<Farmacy, Integer> {
}
