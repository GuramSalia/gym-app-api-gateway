package com.epam.gymappapigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

    FilterUtility filterUtility;

    @Autowired
    public ResponseTraceFilter(FilterUtility filterUtility) {
        this.filterUtility = filterUtility;
    }

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            updateCorrelationId(exchange);
        }));
    }

    private void updateCorrelationId(ServerWebExchange exchange) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        String correlationId = filterUtility.getCorrelationId(requestHeaders);

        exchange.getResponse().getHeaders().add(FilterUtility.CORRELATION_ID, correlationId);
        HttpStatusCode code = exchange.getResponse().getStatusCode();
        logger.info("\n\nGATEWAY response -> Updated the correlation id: {}, http status: {} \n\n",
                    correlationId, code);
    }
}
