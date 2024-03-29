package com.antyzero.travisser.core.api.model


import com.squareup.moshi.Json

data class
BuildsResponse(
    @Json(name = "builds")
    val builds: List<Build>,
    @Json(name = "@type")
    val type: String,
    @Json(name = "@href")
    val href: String,
    @Json(name = "@representation")
    val representation: String,
    @Json(name = "pagination")
    val pagination: Pagination
) {
    data class Pagination(
        @Json(name = "count")
        val count: Int,
        @Json(name = "first")
        val first: First,
        @Json(name = "is_first")
        val isFirst: Boolean,
        @Json(name = "is_last")
        val isLast: Boolean,
        @Json(name = "last")
        val last: Last,
        @Json(name = "limit")
        val limit: Int,
        @Json(name = "next")
        val next: Next,
        @Json(name = "offset")
        val offset: Int,
        @Json(name = "prev")
        val prev: Any
    ) {
        data class Next(
            @Json(name = "limit")
            val limit: Int,
            @Json(name = "offset")
            val offset: Int,
            @Json(name = "@href")
            val href: String
        )

        data class First(
            @Json(name = "limit")
            val limit: Int,
            @Json(name = "offset")
            val offset: Int,
            @Json(name = "@href")
            val href: String
        )

        data class Last(
            @Json(name = "limit")
            val limit: Int,
            @Json(name = "offset")
            val offset: Int,
            @Json(name = "@href")
            val href: String
        )
    }

    data class Build(
        @Json(name = "private")
        val `private`: Boolean,
        @Json(name = "branch")
        val branch: Branch,
        @Json(name = "commit")
        val commit: Commit,
        @Json(name = "created_by")
        val createdBy: CreatedBy,
        @Json(name = "duration")
        val duration: Int,
        @Json(name = "event_type")
        val eventType: String,
        @Json(name = "finished_at")
        val finishedAt: String,
        @Json(name = "id")
        val id: Int,
        @Json(name = "jobs")
        val jobs: List<Job>,
        @Json(name = "number")
        val number: String,
        @Json(name = "previous_state")
        val previousState: String,
        @Json(name = "pull_request_number")
        val pullRequestNumber: Any,
        @Json(name = "pull_request_title")
        val pullRequestTitle: Any,
        @Json(name = "repository")
        val repository: Repository,
        @Json(name = "stages")
        val stages: List<Any>,
        @Json(name = "started_at")
        val startedAt: String,
        @Json(name = "state")
        val state: String,
        @Json(name = "tag")
        val tag: Any,
        @Json(name = "updated_at")
        val updatedAt: String,
        @Json(name = "@type")
        val type: String,
        @Json(name = "@href")
        val href: String,
        @Json(name = "@representation")
        val representation: String,
        @Json(name = "permissions ")
        val permissions: Permissions
    ) {
        data class Permissions(
            @Json(name = "cancel")
            val cancel: Boolean,
            @Json(name = "read")
            val read: Boolean,
            @Json(name = "restart")
            val restart: Boolean
        )

        data class Job(
            @Json(name = "id")
            val id: Int,
            @Json(name = "@type")
            val type: String,
            @Json(name = "@href")
            val href: String,
            @Json(name = "@representation")
            val representation: String
        )

        data class Repository(
            @Json(name = "id")
            val id: Int,
            @Json(name = "name")
            val name: String,
            @Json(name = "slug")
            val slug: String,
            @Json(name = "@type")
            val type: String,
            @Json(name = "@href")
            val href: String,
            @Json(name = "@representation")
            val representation: String
        )

        data class CreatedBy(
            @Json(name = "id")
            val id: Int,
            @Json(name = "login")
            val login: String,
            @Json(name = "@type")
            val type: String,
            @Json(name = "@href")
            val href: String,
            @Json(name = "@representation")
            val representation: String
        )

        data class Branch(
            @Json(name = "name")
            val name: String,
            @Json(name = "@type")
            val type: String,
            @Json(name = "@href")
            val href: String,
            @Json(name = "@representation")
            val representation: String
        )

        data class Commit(
            @Json(name = "committed_at")
            val committedAt: String,
            @Json(name = "compare_url")
            val compareUrl: String,
            @Json(name = "id")
            val id: Int,
            @Json(name = "message")
            val message: String,
            @Json(name = "ref")
            val ref: Any,
            @Json(name = "sha")
            val sha: String,
            @Json(name = "@type")
            val type: String,
            @Json(name = "@representation")
            val representation: String
        )
    }
}