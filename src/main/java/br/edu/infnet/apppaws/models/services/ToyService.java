package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Toy;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ToyService {

    private Map<String, Toy> mapToy = new HashMap<String, Toy>();

    public void include(Toy toy) {
        mapToy.put(toy.getCodId(), toy);
    }

    public Collection<Toy> getList(){
        return mapToy.values();
    }
}
