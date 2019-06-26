package com.antyzero.travisser.core.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// @JsonClass(generateAdapter = true)
data class ActiveResponse(
    @Json(name = "builds")
    val builds: List<Build>,
    @Json(name = "@type")
    val type: String,
    @Json(name = "@href")
    val href: String,
    @Json(name = "@representation")
    val representation: String
) {
    // @JsonClass(generateAdapter = true)
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
        val duration: Any,
        @Json(name = "event_type")
        val eventType: String,
        @Json(name = "finished_at")
        val finishedAt: Any,
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
        @Json(name = "@permissions")
        val permissions: Permissions
    ) {
        // @JsonClass(generateAdapter = true)
        data class Permissions(
            @Json(name = "cancel")
            val cancel: Boolean,
            @Json(name = "read")
            val read: Boolean,
            @Json(name = "restart")
            val restart: Boolean
        )

        // @JsonClass(generateAdapter = true)
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

        // @JsonClass(generateAdapter = true)
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

        // @JsonClass(generateAdapter = true)
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

        // @JsonClass(generateAdapter = true)
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

        // @JsonClass(generateAdapter = true)
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
    }
}