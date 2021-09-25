package com.ashi.learning.heathchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;



@Component
public class CustomHeathIndicator implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		boolean isTrue = true;
		if(isTrue) {
			return Health.down().withDetail("error", 123).build();
		}
		return Health.up().build();
	}

}