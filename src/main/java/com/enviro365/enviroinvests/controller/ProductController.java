package com.enviro365.enviroinvests.controller;

import com.enviro365.enviroinvests.entity.Product;
import com.enviro365.enviroinvests.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Retrieves a list of all products.
     *
     * @return ResponseEntity with a list of products.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves a specific product by ID.
     *
     * @param productId ID of the product to retrieve.
     * @return ResponseEntity with the retrieved product or not found response.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> productOptional = productService.getProductById(productId);

        return productOptional
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product.
     *
     * @param product The product information to create.
     * @return ResponseEntity with the created product.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Updates an existing product.
     *
     * @param productId      ID of the product to update.
     * @param updatedProduct The updated product information.
     * @return ResponseEntity with the updated product or not found response.
     */
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct
    ) {
        Product updatedProductResult = productService.updateProduct(productId, updatedProduct);
        return updatedProductResult != null
                ? ResponseEntity.ok(updatedProductResult)
                : ResponseEntity.notFound().build();
    }

    /**
     * Deletes a product by ID.
     *
     * @param productId ID of the product to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
