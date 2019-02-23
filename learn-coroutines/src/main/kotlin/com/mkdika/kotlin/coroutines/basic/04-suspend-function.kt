package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


// This is coroutine async demo
// now we use suspend function and move previous demo 03-coroutines-async
// to suspend function.
fun main() {
    val elapsedTime = measureTimeMillis {
        val deferred = (1..1_000_000).map {
            GlobalScope.async {
                workload(it)
            }
        }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            println("Sum: $sum") // 1784293664
        }
    }
    println("Elapsed Time: $elapsedTime msecs")
}

// special explicit suspend function to make it suitable
// to be called from a coroutines block
suspend fun workload(n: Int): Int {
    delay(1000)
    return n
}
