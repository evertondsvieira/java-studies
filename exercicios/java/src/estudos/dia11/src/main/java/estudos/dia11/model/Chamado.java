package estudos.dia11.model;

import java.util.concurrent.atomic.AtomicLong;

public class Chamado {
  private static final AtomicLong proximoId = new AtomicLong(1);

  private final Long id;
  private String titulo;
  private String descricao;

  public Chamado(String titulo, String descricao) {
    this.id = proximoId.getAndIncrement();
    this.titulo = titulo;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
