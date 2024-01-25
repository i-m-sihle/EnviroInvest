package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawalNoticeService {

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    public WithdrawalNotice createWithdrawal(WithdrawalNotice withdrawalNotice) {
        return withdrawalNoticeRepository.save(withdrawalNotice);
    }
    public List<WithdrawalNotice> getWithdrawalNoticesByInvestorId(Long investorId) {
        // Assuming you have a method in WithdrawalNoticeRepository to find notices by investorId
        return withdrawalNoticeRepository.findByInvestorId(investorId);
    }

    // Additional methods as needed
}
