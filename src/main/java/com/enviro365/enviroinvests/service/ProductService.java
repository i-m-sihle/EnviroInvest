package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.Product;
import com.enviro365.enviroinvests.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProductsByInvestor(Investor investor) {
        return productRepository.findByInvestor(investor);
    }

    public Product createProduct(Product product) {
        // Add business logic if needed before saving
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Update fields as needed
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setType(updatedProduct.getType());
            existingProduct.setBalance(updatedProduct.getBalance());

            // Add more updates as necessary

            return productRepository.save(existingProduct);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    // Add more methods as needed based on your business logic and requirements
}
