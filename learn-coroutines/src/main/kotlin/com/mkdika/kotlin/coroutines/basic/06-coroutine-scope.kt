package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// This is coroutineScope demo which is apply
// direcly into main method
suspend fun main() = coroutineScope{
    for (i in 1..10) {
        launch {
            delay(1000L - i * 10)
            print("❤️$i  ")
        }
    }
}
