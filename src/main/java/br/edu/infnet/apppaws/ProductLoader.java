package br.edu.infnet.apppaws;

import br.edu.infnet.apppaws.models.domains.Farmacy;
import br.edu.infnet.apppaws.models.domains.Product;
import br.edu.infnet.apppaws.models.domains.Toy;
import br.edu.infnet.apppaws.models.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

@Order(2)
@Component
public class ProductLoader implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/products.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] attribute = null;

        while(line != null) {

            attribute = line.split(";");

            switch (attribute[6]) {
                case "T":
                    Toy toy = new Toy();
                    toy.setCodId(UUID.fromString(attribute[0]));
                    toy.setName(attribute[1]);
                    toy.setDescription(attribute[2]);
                    toy.setPrice(Float.valueOf(attribute[3]));
                    toy.setInventory(Boolean.valueOf(attribute[4]));
                    toy.setForPuppies(Boolean.valueOf(attribute[5]));
                    toy.setMaterial(attribute[6]);

                    productService.include(toy);

                    break;

                case "F":
                    Farmacy farmacy = new Farmacy();
                    farmacy.setCodId(UUID.fromString(attribute[0]));
                    farmacy.setName(attribute[1]);
                    farmacy.setDescription(attribute[2]);
                    farmacy.setPrice(Float.valueOf(attribute[3]));
                    farmacy.setInventory(Boolean.valueOf(attribute[4]));
                    farmacy.setDosage(attribute[4]);
                    farmacy.setLaboratory(attribute[4]);

                    productService.include(farmacy);

                    break;

                default:
                    break;
            }

            line = reader.readLine();
        }

        for(Product product: productService.getAllList()) {
            System.out.println("[Product] " + product);
        }

        reader.close();
    }
}
