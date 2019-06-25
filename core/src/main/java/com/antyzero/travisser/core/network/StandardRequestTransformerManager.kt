package com.antyzero.travisser.core.network

import okhttp3.Request

/**
 * Simple manager
 */
class StandardRequestTransformerManager : RequestTransformerManager {

    internal val map: MutableMap<Any, (Request.Builder) -> Request.Builder> = mutableMapOf()

    override fun registerTransformer(key: Any, transformer: (Request.Builder) -> Request.Builder) {
        map[key] = transformer
    }

    override fun deregisterTransformer(key: Any) {
        map.remove(key)
    }

    override fun transformers(): Collection<(Request.Builder) -> Request.Builder> {
        return map.values
    }
}