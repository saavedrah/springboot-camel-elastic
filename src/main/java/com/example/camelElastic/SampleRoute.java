package com.example.camelElastic;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        CamelContext camelContext = new DefaultCamelContext();

        from("timer://foo?fixedRate=true&period=60000")
                .to("direct:search");

        from("direct:search")
                .to("elasticsearch-rest://elasticsearch?operation=Search&indexName=twitter");
    }
}
