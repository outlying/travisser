package com.antyzero.travisser.core.api

import com.antyzero.travisser.core.api.model.ActiveResponse
import com.antyzero.travisser.core.api.model.BuildsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TravisApi {

    @GET("builds")
    suspend fun builds(): BuildsResponse

    @GET("owner/{owner}/active")
    suspend fun active(@Path("owner") owner: String): ActiveResponse

    enum class Url(internal val url: String) {

        COM("https://api.travis-ci.com/"),

        ORG("https://api.travis-ci.org/")
    }

    companion object {

        /**
         *
         */
        fun create(okHttpClient: OkHttpClient, url: Url): TravisApi {

            val retrofit = Retrofit.Builder()
                .baseUrl(url.url)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit.create(TravisApi::class.java)
        }
    }
}