package com.antyzero.travisser.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class BuildsResponse(
    @Json(name = "builds")
    val builds: List<Any>,
    @Json(name = "@type")
    val type: String,
    @Json(name = "@href")
    val href: String,
    @Json(name = "@representation")
    val representation: String,
    @Json(name = "@pagination")
    val pagination: Pagination
) {

    @JsonClass(generateAdapter = true)
    data class Pagination(
        @Json(name = "count")
        val count: Int,
        @Json(name = "first")
        val first: Position,
        @Json(name = "is_first")
        val isFirst: Boolean,
        @Json(name = "is_last")
        val isLast: Boolean,
        @Json(name = "last")
        val last: Position,
        @Json(name = "limit")
        val limit: Int,
        @Json(name = "next")
        val next: Any?,
        @Json(name = "offset")
        val offset: Int,
        @Json(name = "prev")
        val prev: Any?
    ) {
        @JsonClass(generateAdapter = true)
        data class Position(
            @Json(name = "limit")
            val limit: Int,
            @Json(name = "offset")
            val offset: Int,
            @Json(name = "@href")
            val href: String
        )
    }
}