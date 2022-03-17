package com.da_java.p8_rewardcentral.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rewardCentral.RewardCentral;

import java.util.UUID;

@Api("API which provides the rewards point by attraction id.")

@RestController
@RequestMapping("/api/v1/rewardCentral")
public class RewardCentralController {

    private final RewardCentral rewardCentral;

    public RewardCentralController(RewardCentral rewardCentral) {
        this.rewardCentral = rewardCentral;
    }

    @ApiOperation(value = "Calculate the rewards points by attraction id.")
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
