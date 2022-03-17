package com.da_java.p8_rewardcentral;

import com.da_java.p8_rewardcentral.controller.RewardCentralController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rewardCentral.RewardCentral;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RewardCentralControllerUT {

    @InjectMocks
    private RewardCentralController rewardCentralControllerUT;

    @Mock
    private RewardCentral rewardCentral;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenGetAttractionRewardPointsThenReturnOkAndInteger() {
        UUID attractionId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        when(rewardCentral.getAttractionRewardPoints(attractionId, userId)).thenReturn(234);

        ResponseEntity<Integer> response =
                rewardCentralControllerUT.getAttractionRewardPoints(attractionId.toString(), userId.toString());
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(234);
    }
}
