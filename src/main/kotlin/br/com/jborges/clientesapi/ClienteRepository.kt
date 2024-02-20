package br.com.jborges.clientesapi

import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<ClienteModel, Long> {
}