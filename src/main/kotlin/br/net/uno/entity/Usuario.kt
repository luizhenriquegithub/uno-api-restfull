package br.net.uno.entity

import javax.persistence.*

@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @Column(nullable = false)
    val idLoja: Int = 1,

    @Column(nullable = false,length = 60)
    var nome: String,

    @Column(nullable = false,length = 15)
    var celular: String,

    @Column(nullable = false,length = 1)
    var admin: String = "N",

    @Column(nullable = false,length = 30)
    var login: String,

    @Column(nullable = false, length = 30)
    var senha: String,

    @Column(nullable = false,length = 1)
    var ativo: String = "S"
)