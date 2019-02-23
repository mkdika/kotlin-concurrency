package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// This is coroutine async demo
fun main() {
    val elapsedTime = measureTimeMillis {
        val deferred = (1..1_000_000).map {
            GlobalScope.async {
                // we can put delay 1 sec, to make sure coroutine really
                // run in parallel. Conversely if the process only run
                // in single thread, it will take 1,000,000 sec to finish
                // and its about over 11.5 days!
                // But this only takes about 4 secs on my computer :)
                // remove this delay to make it process faster.
                delay(1000)
                it
            }
        }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            println("Sum: $sum") // 1784293664
        }
    }
    println("Elapsed Time: $elapsedTime msecs")
}

