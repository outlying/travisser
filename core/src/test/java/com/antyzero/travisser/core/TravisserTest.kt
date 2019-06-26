package com.antyzero.travisser.core

import com.antyzero.travisser.core.module.Module
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class TravisserTest {

    @Test
    internal fun init() {
        val travisser = Travisser()

        travisser.travisToken = "asd"

        with(travisser.logged()) {
            when (this) {
                is Module.Available -> assert(true)
                else -> assert(false)
            }
        }
    }

    @Test
    internal fun `call for data`() {

        val travisser = Travisser()

        travisser.travisToken = "QOhE_9TP6xCmb4Xf87yCVA"


        when (val logged = travisser.logged()) {
            is Module.Available -> {
                val result = runBlocking {
                    logged.instance.active()
                }
                result.forEach { println(it) }
            }

            else -> {
                throw IllegalStateException("Something failed")
            }
        }
    }
}