package com.antyzero.travisser.core.module

sealed class Module<T> {

    data class Available<T>(val instance: T) : Module<T>()

    data class Unavailable<T>(val reason: String) : Module<T>()
}