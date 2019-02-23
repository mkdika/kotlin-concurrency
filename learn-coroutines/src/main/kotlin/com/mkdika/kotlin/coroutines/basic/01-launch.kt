package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("Start")

    // Start a coroutine with GlobalScope.launch
    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }

    // wait for 2 seconds
    // block in main thread
    // remove thread.sleep will continue until finish
    // without wait the delay 1 secs coroutines to be
    // finished.
    Thread.sleep(2000)
    println("Stop")
}