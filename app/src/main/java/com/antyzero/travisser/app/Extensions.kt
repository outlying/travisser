package com.antyzero.travisser.app

import android.content.Context
import com.antyzero.travisser.core.ui.TravisserUi

val Context.travisserUi: TravisserUi
    get() = (this.applicationContext as TravisserApplication).travisserUi