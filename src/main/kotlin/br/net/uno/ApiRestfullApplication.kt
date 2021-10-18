package br.net.uno

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiRestfullApplication

fun main(args: Array<String>) {
	runApplication<ApiRestfullApplication>(*args)
}
