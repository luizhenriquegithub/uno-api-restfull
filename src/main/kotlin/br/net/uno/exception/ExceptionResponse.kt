package br.net.uno.exception

import org.springframework.http.HttpStatus

data class ExceptionResponse(
    val status: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    val message: String = "Algo de errado aconteceu, tente novamente !!"
)

data class ExceptionSucccess(
    val status: Int = HttpStatus.CREATED.value(),
    val message: String = "Registro processado com sucesso !!"
)

data class ExceptionNotFound(
    val status: Int = HttpStatus.NOT_FOUND.value(),
    val message: String = "Registro não encontrado !!"
)
