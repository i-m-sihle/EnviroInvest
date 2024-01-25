package com.enviro365.enviroinvests.repository;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query method to find products by investor
    List<Product> findByInvestor(Investor investor);


}
