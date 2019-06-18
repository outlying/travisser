package com.antyzero.travisser.core.repository

import com.antyzero.travisser.core.api.TravisApi

class StandardRepository(
    private val travisApi: TravisApi
) : Repository {

    override fun buildList() {

    }
}