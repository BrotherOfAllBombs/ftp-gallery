package com.brother.of.all.bombs.ftpimageclient;

import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class TestSchedulerProvider implements ISchedulerProvider {
    @Override
    public Scheduler getMainThread() {
        return Schedulers.single();
    }

    @Override
    public Scheduler getBackgroundThread() {
        return Schedulers.single();
    }
}
