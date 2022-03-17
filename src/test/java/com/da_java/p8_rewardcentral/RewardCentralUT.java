package com.da_java.p8_rewardcentral;

import org.junit.jupiter.api.Test;
import rewardCentral.RewardCentral;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RewardCentralUT {

    RewardCentral rewardCentralUT = new RewardCentral();
    @Test
    void whenGetAttractionRewardPointWithValidUUIDsThenReturnIntegerPoint() {
        UUID attractionId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        assertThat(rewardCentralUT.getAttractionRewardPoints(attractionId,
                userId)).isBetween(1, 1000);
    }
}
