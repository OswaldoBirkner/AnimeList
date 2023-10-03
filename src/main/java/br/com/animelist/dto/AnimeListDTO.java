package br.com.animelist.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO para representar um anime na lista")
public class AnimeListDTO implements Serializable {
    private static final long serialVersionUID = 42L;

    @ApiModelProperty(value = "ID do anime")
    private Long id;

    @ApiModelProperty(value = "Nome do anime", required = true)
    @NotBlank(message = "O campo 'name' não pode estar em branco.")
    @NotEmpty(message = "O campo 'name' não pode estar vazio.")
    private String name;

    @ApiModelProperty(value = "Gênero do anime", required = true)
    @NotBlank(message = "O campo 'genre' não pode estar em branco.")
    @NotEmpty(message = "O campo 'genre' não pode estar vazio.")
    private String genre;

    @ApiModelProperty(value = "Descrição do anime", required = true)
    @NotBlank(message = "O campo 'description' não pode estar em branco.")
    @NotEmpty(message = "O campo 'description' não pode estar vazio.")
    private String description;

    @ApiModelProperty(value = "Estúdio do anime", required = true)
    @NotBlank(message = "O campo 'studio' não pode estar em branco.")
    @NotEmpty(message = "O campo 'studio' não pode estar vazio.")
    private String studio;

    @ApiModelProperty(value = "Data de lançamento do anime", required = true)
    @NotBlank(message = "O campo 'releaseDate' não pode estar em branco.")
    @NotEmpty(message = "O campo 'releaseDate' não pode estar vazio.")
    private String releaseDate;

    @CreatedBy
    @ApiModelProperty(value = "Criado por", readOnly = true)
    private String createdBy;

    @CreatedDate
    @ApiModelProperty(value = "Data de criação", readOnly = true)
    private Date createdDate = new Date();

    private String updatedBy;

    private Date updatedDate = new Date();

}
