package com.brother.of.all.bombs.ftpimageclient.di;

import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class SchedulerModule {
    @Provides
    @Singleton
    ISchedulerProvider getSchedulerProvider() {
        return new SchedulerProvider();
    }
}
