package com.antyzero.travisser.core.network

import okhttp3.Request

interface RequestTransformerManager {

    fun registerTransformer(key: Any, transformer: (Request.Builder) -> Request.Builder)

    fun deregisterTransformer(key: Any)

    fun transformers(): Collection<(Request.Builder) -> Request.Builder>
}