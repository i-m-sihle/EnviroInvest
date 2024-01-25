package com.enviro365.enviroinvests.repository;

import com.enviro365.enviroinvests.entity.Product;
import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {

    // Custom query method to find withdrawal notices by product
    List<WithdrawalNotice> findByProduct(Product product);

    // Custom query method to find withdrawal notices by product and withdrawal amount
    List<WithdrawalNotice> findByProductAndWithdrawalAmount(Product product, double withdrawalAmount);

    // Custom query method to find withdrawal notices by product and withdrawal date
    List<WithdrawalNotice> findByProductAndWithdrawalDate(Product product, LocalDateTime withdrawalDate);

    // Add additional query methods if needed
}
