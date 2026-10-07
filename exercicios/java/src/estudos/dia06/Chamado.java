package estudos.dia06;

public final class Chamado {
  private static long proximoId = 1;

  private final Long id;
  private String titulo;
  private String descricao;
  private Usuario responsavel;

  public Chamado(String titulo, String descricao, Usuario responsavel) {
    setTitulo(titulo);
    setDescricao(descricao);
    setResponsavel(responsavel);

    this.id = proximoId++;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty()) {
      throw new IllegalArgumentException("O título não pode estar vazio.");
    }

    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    if (descricao != null && descricao.length() > 225) {
      throw new IllegalArgumentException("A descrição deve ter no máximo 225 caracteres.");
    }

    this.descricao = descricao;
  }

  public Usuario getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(Usuario responsavel) {
    if (responsavel == null) {
      throw new IllegalArgumentException("O título não pode estar vazio.");
    }

    this.responsavel = responsavel;
  }
}
