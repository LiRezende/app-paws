package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.clients.AddressClientInterface;
import br.edu.infnet.apppaws.models.domains.Address;
import br.edu.infnet.apppaws.models.domains.Salesman;
import br.edu.infnet.apppaws.models.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private AddressClientInterface addressClient;

    public void include(Salesman salesman) {
        Address address = addressClient.buscarCep(salesman.getAddress().getCep());
        salesman.setAddress(address);
        salesmanRepository.save(salesman);
    }

    public Salesman findSalesmanByEmail(String email) {
        return salesmanRepository.findFirstByEmail(email).orElse(null);
    }

    public Salesman search(String documentCpf) {
        return salesmanRepository.findByDocumentCpf(documentCpf);
    }


    public Collection<Salesman> getAllList(){
        return (Collection<Salesman>) salesmanRepository.findAll();
    }

    public void exclude(Integer id) {
        salesmanRepository.deleteById(id);
    }

    public long getQuantity() {
        return salesmanRepository.count();
    }
}
