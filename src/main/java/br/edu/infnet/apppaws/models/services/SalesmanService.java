package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Salesman;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SalesmanService {

    private Map<String, Salesman> mapSalesman = new HashMap<String, Salesman>();

    public void incluir(Salesman salesman) {
        mapSalesman.put(salesman.getDocumentCpf(), salesman);
    }

    public Collection<Salesman> getList(){
        return mapSalesman.values();
    }
}
