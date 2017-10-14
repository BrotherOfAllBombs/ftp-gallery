package com.brother.of.all.bombs.ftpimageclient.rx;

import io.reactivex.Scheduler;

/**
 *
 */

public interface ISchedulerProvider {
    Scheduler getMainThread();
    Scheduler getBackgroundThread();
}
