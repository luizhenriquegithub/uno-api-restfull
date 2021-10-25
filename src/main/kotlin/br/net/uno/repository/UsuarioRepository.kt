package br.net.uno.repository

import br.net.uno.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByLogin(login: String): Usuario?

    @Query(nativeQuery = true,value = "SELECT * FROM usuarios WHERE id_loja = :loja")
    fun listar(@Param("loja") id: Int): List<Usuario>

}