package com.example.camelElastic;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute  extends RouteBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRoute.class);

    @Autowired
    ProducerTemplate producerTemplate;

    @Autowired
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.start();

        from("timer://foo?fixedRate=true&period=60000")
                .to("direct:search");

        from("direct:search")
                .to("elasticsearch-rest://elasticsearch?operation=SEARCH&indexName=trkkei-kanri-keiyaku");


    }
}
