package com.example.gymaths

import android.app.Application
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent

class GymathsApp : Application()
{
    override fun onCreate() {
        super.onCreate();
        Instabug.Builder(this, "cd4f5356f3ebc2e24a42eb3836610c64").build();
    }
}