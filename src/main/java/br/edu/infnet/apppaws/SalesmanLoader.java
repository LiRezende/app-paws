package br.edu.infnet.apppaws;

import br.edu.infnet.apppaws.models.domains.Address;
import br.edu.infnet.apppaws.models.domains.Salesman;
import br.edu.infnet.apppaws.models.services.SalesmanService;

import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class SalesmanLoader implements ApplicationRunner {

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
            salesman.setFirstName(attribute[0]);
            salesman.setLastName(attribute[1]);
            salesman.setDocumentCpf(attribute[2]);
            salesman.setEmail(attribute[3]);
            salesman.setAddress(new Address(attribute[4]));

            try {
                salesmanService.include(salesman);
            } catch (ConstraintViolationException e) {
                FileLogger.logException("[Salesman] " + salesman + " - " + e.getMessage());
            }

            line = reader.readLine();
        }

        for(Salesman salesman: salesmanService.getAllList()) {
            System.out.println("[Salesman] " + salesman);
        }

        reader.close();
    }
}
