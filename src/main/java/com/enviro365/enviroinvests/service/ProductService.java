package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.Product;
import com.enviro365.enviroinvests.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to Product entities.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves a list of all products.
     *
     * @return List of Product entities.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId ID of the product.
     * @return Optional containing the Product entity if found, otherwise empty.
     */
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    /**
     * Retrieves a list of products associated with a specific investor.
     *
     * @param investor Investor entity.
     * @return List of Product entities associated with the investor.
     */
    public List<Product> getProductsByInvestor(Investor investor) {
        return productRepository.findByInvestor(investor);
    }

    /**
     * Creates a new product.
     *
     * @param product The Product entity to be created.
     * @return The created Product entity.
     */
    public Product createProduct(Product product) {
        // Add business logic if needed before saving
        return productRepository.save(product);
    }

    /**
     * Updates an existing product.
     *
     * @param productId      ID of the product to be updated.
     * @param updatedProduct Updated Product entity with new data.
     * @return The updated Product entity if found, otherwise null.
     */
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

    /**
     * Deletes a product by its ID.
     *
     * @param productId ID of the product to be deleted.
     */
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
