//package br.edu.infnet.apppaws;
//
//import br.edu.infnet.apppaws.models.domains.Farmacy;
//import br.edu.infnet.apppaws.models.services.FarmacyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.UUID;
//
//@Order(4)
//@Component
//public class FarmacyLoader implements ApplicationRunner {
//
//    @Autowired
//    private FarmacyService farmacyService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        FileReader file = new FileReader("files/farmacy.txt");
//        BufferedReader reader = new BufferedReader(file);
//
//        String line = reader.readLine();
//
//        String[] attribute = null;
//
//        while(line != null) {
//
//            attribute = line.split(";");
//
//            Farmacy farmacy = new Farmacy();
//
//            farmacy.setCodId(UUID.fromString(attribute[0]));
//            farmacy.setName(attribute[1]);
//            farmacy.setDescription(attribute[2]);
//            farmacy.setPrice(Float.valueOf(attribute[3]));
//            farmacy.setInventory(Boolean.valueOf(attribute[4]));
//            farmacy.setDosage(attribute[5]);
//            farmacy.setLaboratory(attribute[6]);
//
//            farmacyService.include(farmacy);
//
//            line = reader.readLine();
//        }
//
//        for(Farmacy farmacy: farmacyService.getAllList()) {
//            System.out.println("[Farmacy] " + farmacy);
//        }
//
//        reader.close();
//    }
//}
