package br.com.jborges.clientesapi

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "clientes")
data class ClienteModel (
    @Id @GeneratedValue
    var id: Long? = null,
    val nome: String,
    val telefone: String,
    val endereco: String
)