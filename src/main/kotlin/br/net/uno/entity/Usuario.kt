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
    val nome: String,

    @Column(nullable = false,length = 15)
    val celular: String,

    @Column(nullable = false,length = 1)
    val admin: String = "N",

    @Column(nullable = false,length = 30)
    val login: String,

    @Column(nullable = false, length = 30)
    val senha: String,

    @Column(nullable = false,length = 1)
    val ativo: String = "S"
)