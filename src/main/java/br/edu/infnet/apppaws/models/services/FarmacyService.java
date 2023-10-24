package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FarmacyService {

    private Map<String, Farmacy> mapFarmacy = new HashMap<String, Farmacy>();

    public void include(Farmacy toy) {
        mapFarmacy.put(toy.getCodId(), toy);
    }

    public Collection<Farmacy> getList(){
        return mapFarmacy.values();
    }
}
