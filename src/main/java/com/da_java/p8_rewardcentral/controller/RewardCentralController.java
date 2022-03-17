package com.da_java.p8_rewardcentral.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rewardCentral.RewardCentral;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rewardCentral")
public class RewardCentralController {

    private final RewardCentral rewardCentral;

    public RewardCentralController(RewardCentral rewardCentral) {
        this.rewardCentral = rewardCentral;
    }

    @GetMapping("/attractionRewardPoints")
    public ResponseEntity<Integer> getAttractionRewardPoints(@RequestParam String attractionId
            , @RequestParam String userId) {
        UUID attractionUUID;
        UUID userUUID;
        try {
            attractionUUID = UUID.fromString(attractionId);
            userUUID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(rewardCentral.getAttractionRewardPoints(attractionUUID, userUUID));
    }

}
