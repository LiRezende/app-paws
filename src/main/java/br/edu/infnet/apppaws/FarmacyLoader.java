package br.edu.infnet.apppaws;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import br.edu.infnet.apppaws.models.services.FarmacyService;
import br.edu.infnet.apppaws.models.services.SalesmanService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class FarmacyLoader implements ApplicationRunner {

    private FarmacyService farmacyService;

    private SalesmanService salesmanService;

    public FarmacyLoader(FarmacyService farmacyService, SalesmanService salesmanService) {
        this.farmacyService = farmacyService;
        this.salesmanService = salesmanService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/farmacy.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] attribute = null;

        while(line != null) {

            attribute = line.split(";");

            Farmacy farmacy = new Farmacy();
            farmacy.setName(attribute[0]);
            farmacy.setDescription(attribute[1]);
            farmacy.setPrice(Float.valueOf(attribute[2]));
            farmacy.setInventory(Boolean.valueOf(attribute[3]));
            farmacy.setDosage(attribute[4]);
            farmacy.setLaboratory(attribute[5]);

            var salesman = salesmanService.findSalesmanByEmail(attribute[6]);
            farmacy.setSalesman(salesman);

            farmacyService.include(farmacy);

            line = reader.readLine();
        }

        for(Farmacy farmacy: farmacyService.getAllList()) {
            System.out.println("[Farmacy] " + farmacy);
        }

        reader.close();
    }
}
