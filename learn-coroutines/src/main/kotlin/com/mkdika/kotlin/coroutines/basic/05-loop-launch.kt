package com.mkdika.kotlin.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.nio.charset.Charset
import kotlin.random.Random

// The idea of this demo is:
// the make several async launch to emulate heavy computation
// text file writer.

// main thread
fun main() {
    GlobalScope.launch {
        writeTextFile(Random.nextInt(9,10),"test1.txt")
    }
    GlobalScope.launch {
        writeTextFile(Random.nextInt(2,5),"test2.txt")
    }
    GlobalScope.launch {
        writeTextFile(Random.nextInt(4,5),"test3.txt")
    }
    GlobalScope.launch {
        // this will created first
        writeTextFile(Random.nextInt(1,1),"test4.txt")
    }

    while(true)
    {
        println("Processing..")
        Thread.sleep(1000)
    }
}

suspend fun writeTextFile(rndTime: Int, fileName: String) {
    delay((rndTime*1000).toLong())
    File(fileName).writeText("Hello World!", Charset.defaultCharset())
}