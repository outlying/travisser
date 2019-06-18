package com.antyzero.travisser.app

import android.app.Application
import com.antyzero.travisser.core.Travisser
import com.antyzero.travisser.core.repository.Repository
import com.antyzero.travisser.core.repository.StandardRepository
import com.antyzero.travisser.core.ui.TravisserUi

class TravisserApplication : Application() {

    private val travisser: Travisser by lazy { Travisser() }

    val travisserUi: TravisserUi by lazy { TravisserUi(travisser) }

    override fun onCreate() {
        super.onCreate()

    }
}