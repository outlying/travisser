package com.antyzero.travisser.core.module.logged

interface Logged {

    suspend fun active(): List<String>

    suspend fun builds(): List<String>
}