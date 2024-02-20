package br.com.jborges.clientesapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientesApiApplication

fun main(args: Array<String>) {
	runApplication<ClientesApiApplication>(*args)
}
