package Atividade.ProjetoIndividual.exception;

import java.time.LocalDateTime;

public record ErroResponse(String mensagem, int status, LocalDateTime timestamp) {
}
