package com.da_java.p8_rewardcentral.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rewardCentral.RewardCentral;

@Configuration
public class MyConfiguration {

    @Bean
    public RewardCentral getRewardCentral() {
        return new RewardCentral();
    }
}
