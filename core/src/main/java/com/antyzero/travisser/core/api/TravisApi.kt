package com.antyzero.travisser.core.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface TravisApi {

    companion object {

        const val URL = "https://api.travis-ci.com/"

        /**
         *
         */
        fun create(okHttpClient: OkHttpClient) {

            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .build()
        }

        /**
         *
         */
        fun configureClient(okHttpClient: OkHttpClient.Builder, tokenProvider: TokenProvider) = okHttpClient
            .addNetworkInterceptor {

                // TODO compare

                val request = it.request().newBuilder()
                    .addHeader("Authorization", "token ${tokenProvider.provideTravisApiToken()}")
                    .build()

                it.proceed(request)
            }
            .build()
    }

    /**
     * Provides token for requests
     */
    interface TokenProvider {

        fun provideTravisApiToken()
    }
}