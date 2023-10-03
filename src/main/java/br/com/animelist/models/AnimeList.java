package br.com.animelist.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Detalhes de um anime na lista")
public class AnimeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID único do anime")
    private Long id;

    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "Nome do anime", required = true)
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(value = "Gênero do anime", required = true)
    private String genre;

    @Column(nullable = false)
    @ApiModelProperty(value = "Descrição do anime", required = true)
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(value = "Estúdio do anime", required = true)
    private String studio;

    @Column(nullable = false)
    @ApiModelProperty(value = "Data de lançamento do anime", required = true)
    private String releaseDate;

    @CreatedBy
    @ApiModelProperty(value = "Criado por", readOnly = true)
    private String createdBy;

    @CreatedDate
    @ApiModelProperty(value = "Data de criação", readOnly = true)
    private Date createdDate = new Date();

    @ApiModelProperty(value = "Atualizado por", readOnly = true)
    private String updatedBy;

    @ApiModelProperty(value = "Data de atualização", readOnly = true)
    private Date updatedDate = new Date();

}


