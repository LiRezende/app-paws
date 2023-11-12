package br.edu.infnet.apppaws.clients;

import br.edu.infnet.apppaws.models.domains.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "addressClient")
public interface AddressClientInterface {

    @GetMapping(value = "/{cep}/json/")
    public Address buscarCep(@PathVariable String cep);
}
