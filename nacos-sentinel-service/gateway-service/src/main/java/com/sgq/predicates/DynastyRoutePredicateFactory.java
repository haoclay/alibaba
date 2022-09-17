package com.sgq.predicates;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import javax.validation.constraints.NotEmpty;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

@Component
public class DynastyRoutePredicateFactory extends AbstractRoutePredicateFactory<DynastyRoutePredicateFactory.Config> {

        public static final String PARAM_KEY = "param";

        public static final String REGEXP_KEY = "regexp";


        public DynastyRoutePredicateFactory() {
                super(Config.class);
        }

        @Override
        public List<String> shortcutFieldOrder() {
                return Arrays.asList(PARAM_KEY,REGEXP_KEY);
        }

        @Override
        public Predicate<ServerWebExchange> apply(Config config) {

                return (GatewayPredicate) exchange -> {
                    System.out.println(config.getParam());

                    List<String> values = exchange.getRequest().getQueryParams()
                            .get(config.param);

                    if (values == null) {
                        return false;
                    }
                    for (String value : values) {
                        if (value != null && value.matches(config.regexp)) {
                            return true;
                        }
                    }
                    return false;
                };
        }

        @Validated
        public static class Config {

            @NotEmpty
            private String param;

            private String regexp;

            public String getParam() {
                return param;
            }

            public Config setParam(String param) {
                this.param = param;
                return this;
            }

            public String getRegexp() {
                return regexp;
            }

            public Config setRegexp(String regexp) {
                this.regexp = regexp;
                return this;
            }
        }

}
