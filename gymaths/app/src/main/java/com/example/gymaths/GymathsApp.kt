package com.example.gymaths

import android.app.Application
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent

class GymathsApp : Application()
{
    override fun onCreate() {
        super.onCreate();
        Instabug.Builder(this, "37249dd332412e7f002966b57169fef9").build();
    }
}