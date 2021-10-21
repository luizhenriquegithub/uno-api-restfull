package br.net.uno.service

import br.net.uno.entity.Usuario
import br.net.uno.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class UsuarioServiceImpl(private val usuarioRepository: UsuarioRepository) : UsuarioService {

    override fun create(usuarios: Usuario): Usuario {
        return usuarioRepository.save(usuarios)
    }

    override fun getAll(idLoja: Int): List<Usuario> {
        return usuarioRepository.findAll()
    }

    override fun getById(id: Long): Optional<Usuario> {
        return usuarioRepository.findById(id)
    }

    override fun findByLogin(idLoja: Int, login: String): Usuario? {
        return usuarioRepository.findByLogin(idLoja, login)
    }

    override fun findByNome(idLoja: Int, nome: String): Usuario? {
        return usuarioRepository.findByNome(idLoja, nome)
    }

    override fun update(id: Long, usuarios: Usuario): Usuario {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
       usuarioRepository.findById(id).map {
           usuarioRepository.delete(it)
       }.orElseThrow{ throw RuntimeException("delete not found $id")}
    }



}