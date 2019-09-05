/*
package com.example.cloudgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Map;

*/
/**
 * @ClassName TokenFilter
 * @Descripion GateWay全局过滤器
 * @Author wangchen
 * @Date 2019/8/15 9:41
 * @Version 1.0
 *//*

@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //请求参数携带token
        //String token = exchange.getRequest().getQueryParams().getFirst("token");
        //获得请求头token
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (token == null || token.isEmpty()) {
            log.info("token is null");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            byte[] bytes = "{\"statusCode\":\"401\",\"msg\":\"没有权限\"}".getBytes(StandardCharsets.UTF_8);
            return exchange.getResponse().writeWith(Flux.just(exchange.getResponse().bufferFactory().wrap(bytes)));
        }

        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }
}




*/
