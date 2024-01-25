package com.enviro365.enviroinvests.service;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to Investor entities.
 */
@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    /**
     * Retrieves a list of all investors.
     *
     * @return List of Investor entities.
     */
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    /**
     * Retrieves an investor by their ID.
     *
     * @param investorId ID of the investor.
     * @return Investor entity if found, otherwise null.
     */
    public Investor getInvestorById(Long investorId) {
        Optional<Investor> optionalInvestor = investorRepository.findById(investorId);
        return optionalInvestor.orElse(null);
    }

    /**
     * Creates a new investor.
     *
     * @param investor The Investor entity to be created.
     * @return The created Investor entity.
     */
    public Investor createInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    /**
     * Updates an existing investor.
     *
     * @param investorId    ID of the investor to be updated.
     * @param updatedInvestor Updated Investor entity with new data.
     * @return The updated Investor entity if found, otherwise null.
     */
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

    /**
     * Deletes an investor by their ID.
     *
     * @param investorId ID of the investor to be deleted.
     */
    public void deleteInvestor(Long investorId) {
        investorRepository.deleteById(investorId);
    }

    /**
     * Retrieves withdrawal notices for a specific investor.
     *
     * @param investorId ID of the investor.
     * @return List of WithdrawalNotice entities associated with the investor.
     */
    public List<WithdrawalNotice> getWithdrawalNoticesForInvestor(Long investorId) {
        // Assuming you have a service method that retrieves withdrawal notices by investorId
        WithdrawalNoticeService withdrawalNoticeService = new WithdrawalNoticeService();
        return withdrawalNoticeService.getWithdrawalNoticesByInvestorId(investorId);
    }
}
