package br.net.uno.controller

import br.net.uno.entity.Usuario
import br.net.uno.repository.UsuarioRepository
import br.net.uno.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody usuarios: Usuario): Usuario = usuarioService.create(usuarios)

    @GetMapping("/{idloja}")
    fun getAll(@PathVariable("idloja") idloja: Int): List<Usuario> {
        return usuarioService.getAll(idloja)
    }


}