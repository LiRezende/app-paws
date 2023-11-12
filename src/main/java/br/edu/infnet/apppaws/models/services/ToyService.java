package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Toy;
import br.edu.infnet.apppaws.models.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public void include(Toy toy) {
        toyRepository.save(toy);
    }

    public Collection<Toy> getAllList(){
        return (Collection<Toy>) toyRepository.findAll();
    }

    public long getQuantity() {
        return toyRepository.count();
    }
}
