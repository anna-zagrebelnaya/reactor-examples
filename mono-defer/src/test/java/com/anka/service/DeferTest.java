package com.anka.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

import java.time.Clock;
import java.time.Instant;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeferTest {

    private static final Instant instant1 = Instant.ofEpochMilli(1L);
    private static final Instant instant2 = Instant.ofEpochMilli(2L);

    @Mock
    private Clock clock;

    @Before
    public void init() {
        when(clock.instant()).thenReturn(instant1).thenReturn(instant2);
    }

    @Test
    public void testJustFlux() {
        Flux<Instant> flux = getCurrentTime();

        flux.subscribe(i -> Assert.assertEquals(instant1, i));
        flux.subscribe(i -> Assert.assertEquals(instant1, i));
    }

    @Test
    public void testDefer() {
        Flux<Instant> flux = Flux.defer(this::getCurrentTime);

        flux.subscribe(i -> Assert.assertEquals(instant1, i));
        flux.subscribe(i -> Assert.assertEquals(instant2, i));
    }

    @Test
    public void testDeferAndCache() {
        Flux<Instant> flux = Flux.defer(this::getCurrentTime).cache();

        flux.subscribe(i -> Assert.assertEquals(instant1, i));
        flux.subscribe(i -> Assert.assertEquals(instant1, i));
    }

    private Flux<Instant> getCurrentTime() {
        return Flux.just(clock.instant());
    }

}
