package com.camachoyury.marvelwiki

import androidx.lifecycle.LifecycleObserver
import android.os.Build.VERSION.SDK_INT
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent



class LifecycleSearch: LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {

    }
}