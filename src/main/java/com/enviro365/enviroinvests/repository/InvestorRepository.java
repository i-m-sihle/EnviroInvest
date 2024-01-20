package com.enviro365.enviroinvests.repository;

import com.enviro365.enviroinvests.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for handling Investor entities.
 */
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    // Custom queries if needed
}
