package br.edu.infnet.apppaws.clients;

import br.edu.infnet.apppaws.models.domains.Information;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "informationClient")
public interface InformationClientInterface {

    @GetMapping(value = "/lista")
    public List<Information> getList();

    @PostMapping(value = "/incluir")
    public Information save(Information information);
}
