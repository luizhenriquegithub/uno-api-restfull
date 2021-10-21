package br.net.uno.service

import br.net.uno.entity.Usuario
import java.util.*


interface UsuarioService {

    fun create(usuarios: Usuario): Usuario

    fun getAll(idLoja: Int): List<Usuario>

    fun getById(id: Long): Optional<Usuario>

    fun findByLogin(idLoja: Int, login: String): Usuario?

    fun findByNome(idLoja: Int, nome: String): Usuario?

    fun update(id: Long, usuarios: Usuario): Usuario

    fun delete(id: Long)

}