package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private Map<String, Product> mapProduct = new HashMap<String, Product>();

    public void include(Product product) {
        mapProduct.put(product.getCodId(), product);
    }

    public Collection<Product> getList(){
        return mapProduct.values();
    }
}
