package br.edu.infnet.apppaws.models.services;

import br.edu.infnet.apppaws.models.domains.Product;
import br.edu.infnet.apppaws.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void include(Product product) {
        productRepository.save(product);
    }

    public Collection<Product> getAllList(){
        return (Collection<Product>) productRepository.findAll();
    }
}
