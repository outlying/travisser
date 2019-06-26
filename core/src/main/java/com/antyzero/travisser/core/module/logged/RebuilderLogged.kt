package com.antyzero.travisser.core.module.logged

import com.antyzero.travisser.core.api.TravisApi
import com.antyzero.travisser.core.network.RequestTransformerManager
import okhttp3.OkHttpClient
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Allows to rebuild underlying [Logged] implementation
 */
class RebuilderLogged(
    token: String,
    private val okHttpClient: OkHttpClient,
    private val requestTransformerManager: RequestTransformerManager
) : Logged {

    private val destroyed: AtomicBoolean = AtomicBoolean(true)
    private lateinit var travisApi: TravisApi

    init {
        rebuild(token)
    }

    override suspend fun active(): List<String> {
        if (destroyed.get()) {
            throw IllegalStateException("Destroyed, need to rebuild with new token")
        } else {
            return travisApi.active("outlying").builds.map { it.repository.name }
        }
    }

    override suspend fun builds(): List<String> {
        if (destroyed.get()) {
            throw IllegalStateException("Destroyed, need to rebuild with new token")
        } else {
            return travisApi.builds().builds.map { it.repository.name }
        }
    }

    fun rebuild(token: String) {
        travisApi = TravisApi.create(okHttpClient, TravisApi.Url.ORG)
        requestTransformerManager.registerTransformer(this) {
            it.addHeader("Authorization", "token $token")
            it.addHeader("Travis-API-Version", "3")
        }
        destroyed.set(false)
    }

    fun destroy() {
        destroyed.set(true)
        requestTransformerManager.deregisterTransformer(this)
    }
}