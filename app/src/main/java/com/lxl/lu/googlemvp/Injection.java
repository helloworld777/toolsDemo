package com.lxl.lu.googlemvp;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lxl.lu.googlemvp.data.FakeTasksRemoteDataSource;
import com.lxl.lu.googlemvp.data.source.TasksRepository;
import com.lxl.lu.googlemvp.data.source.local.TasksLocalDataSource;
import static com.google.common.base.Preconditions.checkNotNull;

public class Injection {

    public static TasksRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        return TasksRepository.getInstance(FakeTasksRemoteDataSource.getInstance(),
                TasksLocalDataSource.getInstance(context));
    }
}