package com.brother.of.all.bombs.ftpimageclient;

import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 *
 */

public class TestSchedulerProvider implements ISchedulerProvider {

    private TestScheduler testScheduler = new TestScheduler();

    @Override
    public Scheduler getMainThread() {
        return testScheduler;
    }

    @Override
    public Scheduler getBackgroundThread() {
        return testScheduler;
    }
}
