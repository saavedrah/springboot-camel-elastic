package com.example.camelElastic;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:search")
                .to("elasticsearch-rest://elasticsearch?operation=Search&indexName=twitter");
    }
}
