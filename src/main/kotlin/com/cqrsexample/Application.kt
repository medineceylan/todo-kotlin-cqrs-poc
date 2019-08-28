package com.cqrsexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
open class Application

fun main(args: Array<String>) {
    println(UUID.randomUUID())
    SpringApplication.run(Application::class.java, *args)
}
