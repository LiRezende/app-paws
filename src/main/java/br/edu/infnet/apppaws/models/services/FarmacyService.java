package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import br.edu.infnet.apppaws.models.repositories.FarmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FarmacyService {

    @Autowired
    private FarmacyRepository farmacyRepository;

    public void include(Farmacy toy) {
        farmacyRepository.save(toy);
    }

    public Collection<Farmacy> getAllList(){
        return (Collection<Farmacy>) farmacyRepository.findAll();
    }

    public long getQuantity() {
        return farmacyRepository.count();
    }
}
