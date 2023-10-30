package br.edu.infnet.apppaws;

import br.edu.infnet.apppaws.models.domains.Toy;
import br.edu.infnet.apppaws.models.services.SalesmanService;
import br.edu.infnet.apppaws.models.services.ToyService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class ToyLoader implements ApplicationRunner {

    private ToyService toyService;

    private SalesmanService salesmanService;

    public ToyLoader(ToyService toyService, SalesmanService salesmanService) {
        this.toyService = toyService;
        this.salesmanService = salesmanService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/toy.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] attribute = null;

        while(line != null) {

            attribute = line.split(";");

            Toy toy = new Toy();
            toy.setName(attribute[0]);
            toy.setDescription(attribute[1]);
            toy.setPrice(Float.valueOf(attribute[2]));
            toy.setInventory(Boolean.valueOf(attribute[3]));
            toy.setForPuppies(Boolean.valueOf(attribute[4]));
            toy.setMaterial(attribute[5]);

            toy.setSalesman(salesmanService.findSalesmanByEmail(attribute[6]));

            toyService.include(toy);

            line = reader.readLine();
        }

        for(Toy toy: toyService.getAllList()) {
            System.out.println("[Toy] " + toy);
        }

        reader.close();
    }
}
