package com.example.camelElastic;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelElasticConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(CamelElasticConfig.class);

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {


            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                LOGGER.info("*** beforeApplicationStart ***");
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                LOGGER.info("*** afterApplicationStart ***");
            }
        };
    }
}
