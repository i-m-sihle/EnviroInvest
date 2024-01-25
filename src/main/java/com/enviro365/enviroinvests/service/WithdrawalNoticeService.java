package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling operations related to WithdrawalNotice entities.
 */
@Service
public class WithdrawalNoticeService {

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    /**
     * Creates a new withdrawal notice.
     *
     * @param withdrawalNotice The WithdrawalNotice entity to be created.
     * @return The created WithdrawalNotice entity.
     */
    public WithdrawalNotice createWithdrawal(WithdrawalNotice withdrawalNotice) {
        return withdrawalNoticeRepository.save(withdrawalNotice);
    }

    /**
     * Retrieves a list of withdrawal notices for a specific investor.
     *
     * @param investorId ID of the investor for whom withdrawal notices are retrieved.
     * @return List of WithdrawalNotice entities associated with the investor.
     */
    public List<WithdrawalNotice> getWithdrawalNoticesByInvestorId(Long investorId) {
        // Assuming you have a method in WithdrawalNoticeRepository to find notices by investorId
        return withdrawalNoticeRepository.findByInvestorId(investorId);
    }

    // Add more methods as needed based on your business logic and requirements
}
