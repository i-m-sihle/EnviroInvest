package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor getInvestorById(Long investorId) {
        Optional<Investor> optionalInvestor = investorRepository.findById(investorId);
        return optionalInvestor.orElse(null);
    }

    public Investor createInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    public Investor updateInvestor(Long investorId, Investor updatedInvestor) {
        Optional<Investor> optionalInvestor = investorRepository.findById(investorId);

        if (optionalInvestor.isPresent()) {
            Investor existingInvestor = optionalInvestor.get();
            // Update existingInvestor with fields from updatedInvestor
            existingInvestor.setName(updatedInvestor.getName());
            existingInvestor.setAddress(updatedInvestor.getAddress());
            existingInvestor.setContact(updatedInvestor.getContact());
            existingInvestor.setAge(updatedInvestor.getAge());

            return investorRepository.save(existingInvestor);
        }

        return null; // or throw an exception indicating investor not found
    }

    public void deleteInvestor(Long investorId) {
        investorRepository.deleteById(investorId);
    }

    public List<WithdrawalNotice> getWithdrawalNoticesForInvestor(Long investorId) {
        // Assuming you have a service method that retrieves withdrawal notices by investorId
        WithdrawalNoticeService withdrawalNoticeService = new WithdrawalNoticeService();
        return withdrawalNoticeService.getWithdrawalNoticesByInvestorId(investorId);
    }
}
