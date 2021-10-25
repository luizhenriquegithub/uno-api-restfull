package br.net.uno.controller

import br.net.uno.entity.Usuario
import br.net.uno.exception.ExceptionNotFound
import br.net.uno.exception.ExceptionResponse
import br.net.uno.exception.ExceptionSucccess
import br.net.uno.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @PostMapping
    fun create(@RequestBody usuario: Usuario): ResponseEntity<Any> {
        usuarioService.create(usuario)
        return ResponseEntity(ExceptionSucccess(), HttpStatus.CREATED)
    }

    @GetMapping("/listAll/{loja}")
    fun findAll(@PathVariable("loja") loja: Int): ResponseEntity<Any> {
        val list = usuarioService.listar(loja)
        return if (!list.isEmpty()) {
            ResponseEntity(list,HttpStatus.OK)
        } else
            return ResponseEntity(ExceptionNotFound(),HttpStatus.NOT_FOUND)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val usuario = usuarioService.getById(id)
        return if (usuario.isPresent())
            ResponseEntity(usuario, HttpStatus.OK)
        else
            ResponseEntity(ExceptionNotFound(), HttpStatus.NOT_FOUND)
    }

    @GetMapping("/login/{login}")
    fun getByLogin(@PathVariable("login") login: String): ResponseEntity<Any> {
        val vLogin = usuarioService.getByLogin(login)
        return if (vLogin != null) {
            ResponseEntity(vLogin, HttpStatus.OK)
        } else
            ResponseEntity(ExceptionNotFound(), HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        if (usuarioService.existsById(id)) {
            usuarioService.delete(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity(ExceptionNotFound(), HttpStatus.NOT_FOUND)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody usuario: Usuario) {
        usuarioService.update(id, usuario)
    }


}