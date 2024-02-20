package br.com.jborges.clientesapi.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "clientes")
data class ClienteModel (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, length = 80) val nome: String,
    @Column(nullable = false, length = 14) val telefone: String,
    @Column(nullable = false, length = 150) val endereco: String
)