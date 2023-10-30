package br.edu.infnet.apppaws.models.repositories;

import br.edu.infnet.apppaws.models.domains.Product;
import br.edu.infnet.apppaws.models.domains.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findBySalesman(Salesman salesman);
}
