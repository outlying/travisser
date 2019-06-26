package com.antyzero.travisser.core

import com.antyzero.travisser.core.module.Module
import com.antyzero.travisser.core.network.RequestTransformerManager
import com.antyzero.travisser.core.network.StandardRequestTransformerManager
import com.antyzero.travisser.core.module.logged.Logged
import com.antyzero.travisser.core.module.logged.RebuilderLogged
import okhttp3.OkHttpClient


class Travisser {

    private val requestTransformerManager: RequestTransformerManager = StandardRequestTransformerManager()

    // TODO obviously this lacks some sort of sync access, but fuck it for now
    private var logged: RebuilderLogged? = null

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->

            System.err.println(chain.request().url())

            val newBuilder = chain.request().newBuilder()
            requestTransformerManager.transformers().forEach { it.invoke(newBuilder) }
            chain.proceed(newBuilder.build())
        }
        .build()

    var travisToken: String? = null
        set(value) {
            if (value != null) {
                with(logged) {
                    @Suppress("IfThenToElvis")
                    if (this == null) {
                        logged = RebuilderLogged(value, okHttpClient, requestTransformerManager)
                    } else {
                        this.rebuild(token = value)
                    }
                }
            } else {
                logged?.destroy()
            }
            field = value
        }

    /**
     * Access to tokenized part of data
     */
    fun logged(): Module<Logged> = with(logged) {
        if (this != null) {
            Module.Available(this)
        } else {
            Module.Unavailable("Missing Travis token")
        }
    }
}