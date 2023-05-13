package com.example.kotlindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDemoApplicationApplication

fun main(args: Array<String>) {
    runApplication<KotlinDemoApplicationApplication>(*args)
}
