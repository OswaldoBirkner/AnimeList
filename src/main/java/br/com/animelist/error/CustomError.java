package br.com.animelist.error;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@ApiModel(description = "Classe para representar uma resposta de erro personalizada")
public class CustomError {
    @ApiModelProperty(value = "Status HTTP da resposta de erro", example = "BAD_REQUEST")
    private HttpStatus status;

    @ApiModelProperty(value = "Mensagem de erro", example = "Ocorreu um erro ao processar a solicitação.")
    private String message;

    @ApiModelProperty(value = "Timestamp do erro", example = "2023-09-23T10:15:30")
    private LocalDateTime timestamp;

    public CustomError() {
    }

    public CustomError(HttpStatus status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
