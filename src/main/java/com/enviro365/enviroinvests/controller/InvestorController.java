package com.enviro365.enviroinvests.controller;

import com.enviro365.enviroinvests.entity.Investor;
import com.enviro365.enviroinvests.entity.WithdrawalNotice;
import com.enviro365.enviroinvests.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    /**
     * Retrieves a list of all investors.
     *
     * @return ResponseEntity with a list of investors.
     */
    @GetMapping
    public ResponseEntity<List<Investor>> getAllInvestors() {
        List<Investor> investors = investorService.getAllInvestors();
        return ResponseEntity.ok(investors);
    }

    /**
     * Retrieves a specific investor by ID.
     *
     * @param investorId ID of the investor to retrieve.
     * @return ResponseEntity with the retrieved investor.
     */
    @GetMapping("/{investorId}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long investorId) {
        Investor investor = investorService.getInvestorById(investorId);
        return ResponseEntity.ok(investor);
    }

    /**
     * Retrieves withdrawal notices for a specific investor.
     *
     * @param investorId ID of the investor to retrieve withdrawal notices for.
     * @return ResponseEntity with a list of withdrawal notices for the investor.
     */
    @GetMapping("/{investorId}/withdrawal-notices")
    public ResponseEntity<List<WithdrawalNotice>> getWithdrawalNoticesForInvestor(@PathVariable Long investorId) {
        List<WithdrawalNotice> withdrawalNotices = investorService.getWithdrawalNoticesForInvestor(investorId);
        return ResponseEntity.ok(withdrawalNotices);
    }

    /**
     * Creates a new investor.
     *
     * @param investor The investor information to create.
     * @return ResponseEntity with the created investor.
     */
    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        Investor createdInvestor = investorService.createInvestor(investor);
        return ResponseEntity.ok(createdInvestor);
    }

    /**
     * Updates an existing investor.
     *
     * @param investorId      ID of the investor to update.
     * @param updatedInvestor The updated investor information.
     * @return ResponseEntity with the updated investor.
     */
    @PutMapping("/{investorId}")
    public ResponseEntity<Investor> updateInvestor(
            @PathVariable Long investorId,
            @RequestBody Investor updatedInvestor
    ) {
        Investor updatedInvestorResult = investorService.updateInvestor(investorId, updatedInvestor);
        return ResponseEntity.ok(updatedInvestorResult);
    }

    /**
     * Deletes an investor by ID.
     *
     * @param investorId ID of the investor to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{investorId}")
    public ResponseEntity<Void> deleteInvestor(@PathVariable Long investorId) {
        investorService.deleteInvestor(investorId);
        return ResponseEntity.noContent().build();
    }
}
