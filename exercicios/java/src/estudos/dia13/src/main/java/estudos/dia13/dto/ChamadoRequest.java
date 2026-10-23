package estudos.dia13.dto;

import jakarta.validation.constraints.NotBlank;

public record ChamadoRequest(
  @NotBlank(message = "Título é obrigatório") String titulo
) {}
