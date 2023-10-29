package br.edu.infnet.apppaws;

import br.edu.infnet.apppaws.models.domains.Salesman;
import br.edu.infnet.apppaws.models.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

@Order(1)
@Component
public class SalesmanLoder implements ApplicationRunner {

    @Autowired
    private SalesmanService salesmanService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/salesman.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] attribute = null;

        while(line != null) {

            attribute = line.split(";");

            Salesman salesman = new Salesman();

            salesman.setCodId(UUID.fromString(attribute[0]));
            salesman.setFirstName(attribute[1]);
            salesman.setLastName(attribute[2]);
            salesman.setDocumentCpf(attribute[3]);
            salesman.setEmail(attribute[4]);

            salesmanService.include(salesman);

            line = reader.readLine();
        }

        for(Salesman salesman: salesmanService.getList()) {
            System.out.println("[Salesman] " + salesman);
        }

        reader.close();
    }
}
