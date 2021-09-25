package com.ashi.learning;

import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class ProductCacheConfig {

	public Config cacheConfig() {
		return new Config().setInstanceName("hazel-instance").addMapConfig(new MapConfig()
				.setName("product-cache")
				.setTimeToLiveSeconds(3000)
				);
	}
}
