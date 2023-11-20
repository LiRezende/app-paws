package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.clients.InformationClientInterface;
import br.edu.infnet.apppaws.models.domains.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {

    @Autowired
    private InformationClientInterface informationClient;

    public List<Information> getList(){
        return informationClient.getList();
    }

    public Information save(Information information) {
        return informationClient.save(information);
    }
}
