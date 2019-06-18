package com.antyzero.travisser.core

import com.antyzero.travisser.core.section.Logged
import com.antyzero.travisser.core.section.StandardLogged
import okhttp3.OkHttpClient


class Travisser() {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            it.proceed(it.request().newBuilder().apply {

            }.build())
        }
        .build()

    var travisToken: String? = null
        set(value) {
            logged = StandardLogged()
            field = value
        }

    private var logged: Logged? = null

    /**
     * Access to tokenized part of data
     */
    fun logged(): Logged = logged ?: throw IllegalStateException("")
}