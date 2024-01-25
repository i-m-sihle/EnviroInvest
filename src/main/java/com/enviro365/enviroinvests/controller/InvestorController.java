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

    @GetMapping
    public ResponseEntity<List<Investor>> getAllInvestors() {
        List<Investor> investors = investorService.getAllInvestors();
        return ResponseEntity.ok(investors);
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long investorId) {
        Investor investor = investorService.getInvestorById(investorId);
        return ResponseEntity.ok(investor);
    }

    @GetMapping("/{investorId}/withdrawal-notices")
    public ResponseEntity<List<WithdrawalNotice>> getWithdrawalNoticesForInvestor(@PathVariable Long investorId) {
        List<WithdrawalNotice> withdrawalNotices = investorService.getWithdrawalNoticesForInvestor(investorId);
        return ResponseEntity.ok(withdrawalNotices);
    }

    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        Investor createdInvestor = investorService.createInvestor(investor);
        return ResponseEntity.ok(createdInvestor);
    }

    @PutMapping("/{investorId}")
    public ResponseEntity<Investor> updateInvestor(
            @PathVariable Long investorId,
            @RequestBody Investor updatedInvestor
    ) {
        Investor updatedInvestorResult = investorService.updateInvestor(investorId, updatedInvestor);
        return ResponseEntity.ok(updatedInvestorResult);
    }

    @DeleteMapping("/{investorId}")
    public ResponseEntity<Void> deleteInvestor(@PathVariable Long investorId) {
        investorService.deleteInvestor(investorId);
        return ResponseEntity.noContent().build();
    }
}
