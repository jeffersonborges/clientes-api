package br.com.jborges.clientesapi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClienteController(private val repository: ClienteRepository) {

    @PostMapping
    fun create(@RequestBody clienteModel: ClienteModel): ClienteModel = repository.save(clienteModel)

    @GetMapping
    fun getAll(): List<ClienteModel> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long): ResponseEntity<ClienteModel> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody clienteModel: ClienteModel): ResponseEntity<ClienteModel> =
        repository.findById(id).map {
            val clienteToUpdate = it.copy(
                nome = clienteModel.nome,
                telefone = clienteModel.telefone,
                endereco = clienteModel.endereco
            )
            ResponseEntity.ok(repository.save(clienteToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}