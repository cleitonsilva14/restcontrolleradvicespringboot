package io.dev.restcontrolleradvicespringboot.dto;

import io.dev.restcontrolleradvicespringboot.enums.Categoria;
import io.dev.restcontrolleradvicespringboot.enums.Idioma;
import io.dev.restcontrolleradvicespringboot.enums.Nivel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CursoRequest(@NotBlank String nome,
                           @NotBlank String descricao,
                           @NotNull Nivel nivel,
                           @NotNull Categoria categoria,
                           @NotNull Idioma idioma,
                           @NotNull @Min(0) BigDecimal preco
) {
}
