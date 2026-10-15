package estudos.dia12.dto;

import jakarta.validation.constraints.NotBlank;

public record ChamadoRequest(
  @NotBlank(message = "O título não pode ser vazio.")
  String titulo,
  String descricao
) {}
