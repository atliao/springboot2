package com.la.springboot2.actuator.service.Impl;

import com.la.springboot2.actuator.service.IndexService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

/**
 * @author LA
 * @date 2022-11-18-17:03
 */
@Service
public class IndexServiceImpl implements IndexService {


    Counter counter;

    @Override
    public void show() {
        counter.increment();
        System.out.println("hello");
    }

    public IndexServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("indexService.show.count");
    }
}
