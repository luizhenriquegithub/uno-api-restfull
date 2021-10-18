package br.net.uno.repository

import br.net.uno.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByLogin(login: String): Usuario?
    fun findByNome(nome: String): Usuario?

}