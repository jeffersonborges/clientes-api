package br.com.jborges.clientesapi.repositories

import br.com.jborges.clientesapi.models.ClienteModel
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<ClienteModel, Long> {
}