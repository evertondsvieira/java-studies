package estudos.dia05;

import java.time.LocalDate;

public final class Chamado {
  private static long proximoId = 1;

  private final long id;
  private String titulo;
  private LocalDate criadoEm;

  public Chamado(String titulo, LocalDate criadoEm) {
    setTitulo(titulo);
    this.id = proximoId++;

    this.criadoEm = criadoEm;
  }

  public long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty()) {
      throw new RegraNegocioException("O título não pode estar vazio.");
    }
    this.titulo = titulo;
  }

  public LocalDate getCriadoEm() {
    return criadoEm;
  }

  public void setCriadoEm(LocalDate criadoEm) {
    this.criadoEm = criadoEm;
  }
}
