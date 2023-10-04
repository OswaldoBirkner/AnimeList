package br.com.animelist.dto;
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
public class AnimeListDTO implements Serializable {
    private static final long serialVersionUID = 42L;

    private Long id;

    @NotBlank(message = "O campo 'name' não pode estar em branco.")
    @NotEmpty(message = "O campo 'name' não pode estar vazio.")
    private String name;

    @NotBlank(message = "O campo 'genre' não pode estar em branco.")
    @NotEmpty(message = "O campo 'genre' não pode estar vazio.")
    private String genre;

    @NotBlank(message = "O campo 'description' não pode estar em branco.")
    @NotEmpty(message = "O campo 'description' não pode estar vazio.")
    private String description;

    @NotBlank(message = "O campo 'studio' não pode estar em branco.")
    @NotEmpty(message = "O campo 'studio' não pode estar vazio.")
    private String studio;

    @NotBlank(message = "O campo 'releaseDate' não pode estar em branco.")
    @NotEmpty(message = "O campo 'releaseDate' não pode estar vazio.")
    private String releaseDate;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate = new Date();

    private String updatedBy;

    private Date updatedDate = new Date();

}
