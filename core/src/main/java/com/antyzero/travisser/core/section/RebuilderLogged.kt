package com.antyzero.travisser.core.section

import com.antyzero.travisser.core.network.RequestTransformerManager
import okhttp3.OkHttpClient

class RebuilderLogged(
    token: String,
    private val okHttpClient: OkHttpClient,
    private val requestTransformerManager: RequestTransformerManager
) : Logged {

    init {
        rebuild(token)
    }

    fun rebuild(token: String) {
        requestTransformerManager.registerTransformer(this) {
            it.addHeader("Token", token)
        }
    }

    fun destroy() {
        requestTransformerManager.deregisterTransformer(this)
    }
}