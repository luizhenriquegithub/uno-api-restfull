package br.net.uno.repository

import br.net.uno.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByLogin(login: String): Usuario?

    @Query(nativeQuery = true,value = "SELECT * FROM usuarios WHERE id_loja = :id")
    fun listar(@Param("id") id: Int): List<Usuario>

    //fun findByNome(idLoja: Int, nome: String): Usuario?

    //@Query(nativeQuery = true,value = "SELECT * FROM usuarios WHERE id_loja = :id")
    //fun findAllByIdLoja(@Param("id") id: Int): List<Usuario>

    //@Query("select u from usuarios u")
    //fun listarUsuarios(): List<Usuario>

}