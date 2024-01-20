package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalNoticeService {

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    public WithdrawalNotice createWithdrawal(WithdrawalNotice withdrawalNotice) {
        return withdrawalNoticeRepository.save(withdrawalNotice);
    }

    // Additional methods as needed
}
