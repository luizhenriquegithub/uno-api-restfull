package br.net.uno.service

import br.net.uno.entity.Usuario
import br.net.uno.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
open class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun create(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun findAll(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun findById(id: Long): Usuario {
        return usuarioRepository.findById(id).get()
    }

    fun getById(id: Long): Optional<Usuario> {
        return usuarioRepository.findById(id)
    }

    fun delete(id: Long) {
        usuarioRepository.deleteById(id)
    }

    fun existsById(id: Long):Boolean {
        return usuarioRepository.existsById(id)
    }

    @Transactional
    open fun update(id: Long, usuario: Usuario) {
        val userDB = findById(id)
        userDB.nome = usuario.nome
        userDB.celular = usuario.celular
        userDB.admin = usuario.admin
        userDB.login = usuario.login
        userDB.senha = usuario.senha
        userDB.ativo = usuario.ativo
        usuarioRepository.save(userDB)
    }

}