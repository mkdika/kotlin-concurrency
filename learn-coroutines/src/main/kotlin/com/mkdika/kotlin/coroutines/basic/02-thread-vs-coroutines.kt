package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    val elapsedTime = measureTimeMillis {
//        runThread()
        runCoroutines()
    }
    println("Elapsed time: $elapsedTime msecs")
}

// concurrency using 1_000_000 thread demo
fun runThread() {
    val c = AtomicLong()

    for (i in 1..1_000_000L)
        thread(start = true) {
            c.addAndGet(i)
        }
    println(c.get())
}

// concurrency using 1_000_000 coroutines demo
fun runCoroutines() {
    val c = AtomicLong()

    for (i in 1..1_000_000L)
        GlobalScope.launch {
            c.addAndGet(i)
        }

    println(c.get())
}