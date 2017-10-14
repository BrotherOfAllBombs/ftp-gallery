package com.brother.of.all.bombs.ftpimageclient.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class SchedulerProvider implements ISchedulerProvider {
    @Override
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler getBackgroundThread() {
        return Schedulers.computation();
    }
}
