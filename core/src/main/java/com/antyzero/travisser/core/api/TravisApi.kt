package com.antyzero.travisser.core.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface TravisApi {

    companion object {

        fun create() {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.travis-ci.com/")
                .client(createClient("asd"))
                .build()

        }

        private fun createClient(token: String) = OkHttpClient.Builder()
            .addNetworkInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "token $token")
                    .build()

                it.proceed(request)
            }
            .build()
    }
}