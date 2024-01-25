package com.enviro365.enviroinvests.repository;

import com.enviro365.enviroinvests.entity.Product;
import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {

    // Custom query method to find withdrawal notices by investor
    List<WithdrawalNotice> findByInvestorId(Long investorId);

    // Custom query method to find withdrawal notices by product
    List<WithdrawalNotice> findByProduct(Product product);

    // Custom query method to find withdrawal notices by product and withdrawal amount
    List<WithdrawalNotice> findByProductAndWithdrawalAmount(Product product, BigDecimal withdrawalAmount);

    // Custom query method to find withdrawal notices by product and date
    List<WithdrawalNotice> findByProductAndWithdrawalDate(Product product, LocalDateTime withdrawalDate);
}
