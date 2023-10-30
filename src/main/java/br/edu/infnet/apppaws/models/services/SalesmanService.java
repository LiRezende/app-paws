package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Salesman;
import br.edu.infnet.apppaws.models.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    public void include(Salesman salesman) {
        salesmanRepository.save(salesman);
    }

    public Salesman findSalesmanByEmail(String email) {
        return salesmanRepository.findFirstByEmail(email).orElse(null);
    }

    public Collection<Salesman> getAllList(){
        return (Collection<Salesman>) salesmanRepository.findAll();
    }
}
