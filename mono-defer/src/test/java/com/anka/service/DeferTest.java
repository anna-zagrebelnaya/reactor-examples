package com.anka.service;

import org.junit.Test;
import reactor.core.publisher.Flux;


public class DeferTest {

    @Test
    public void testDefer() {
        Flux<Long> fluxWithDefer = Flux.defer(this::getCurrentTime);
        Flux<Long> flux = getCurrentTime();
        Flux<Long> fluxWithDeferAndCache = Flux.defer(this::getCurrentTime).cache();

        fluxWithDefer.subscribe(l -> System.out.println("1 fluxWithDefer:" + l));
        flux.subscribe(l -> System.out.println("1 flux:" + l));
        fluxWithDeferAndCache.subscribe(l -> System.out.println("1 fluxWithDeferAndCache:" + l));

        fluxWithDefer.subscribe(l -> System.out.println("2 fluxWithDefer:" + l));
        flux.subscribe(l -> System.out.println("2 flux:" + l));
        fluxWithDeferAndCache.subscribe(l -> System.out.println("2 fluxWithDeferAndCache:" + l));

        /* output:
        1 fluxWithDefer:        1526239255393
        1 flux:                 1526239255377
        1 fluxWithDeferAndCache:1526239255413

        2 fluxWithDefer:        1526239255413
        2 flux:                 1526239255377
        2 fluxWithDeferAndCache:1526239255413
         */
    }

    private Flux<Long> getCurrentTime() {
        return Flux.just(System.currentTimeMillis());
    }

}
