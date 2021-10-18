package br.net.uno.controller

import br.net.uno.entity.Usuario
import br.net.uno.repository.UsuarioRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(private val usuarioRepository: UsuarioRepository) {

    @PostMapping("/save")
    fun save(): String {
        usuarioRepository.save(Usuario(nome = "Luiz", celular = "319 9920-0642", login = "luiz", senha = "12345"))
        usuarioRepository.save(Usuario(nome = "Flavia", celular = "319 9920-0642", login = "flavia", senha = "12345"))
        return "Done OK"
    }

    @GetMapping("/nome/{nome}")
    fun finByNome(@PathVariable nome: String): Usuario? {
        return usuarioRepository.findByNome(nome)
    }

    @GetMapping("login/{login}")
    fun findByLogin(@PathVariable login: String): Usuario? {
        return usuarioRepository.findByLogin(login)
    }


}