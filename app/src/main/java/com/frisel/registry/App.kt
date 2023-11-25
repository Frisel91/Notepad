package com.frisel.registry

import android.app.Application
import com.frisel.registry.db.AppDatabase

class App:Application() {
    val db by lazy { AppDatabase.createDataBase(this) }
}