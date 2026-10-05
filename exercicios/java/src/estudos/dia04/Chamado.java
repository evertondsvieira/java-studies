package estudos.dia04;

public final class Chamado {
  private static long proximoId = 1;

  private final long id;
  private String titulo;
  private String responsavel;
  private PrioridadeEnum prioridade;
  private StatusEnum status;

  public Chamado(String titulo, String responsavel, PrioridadeEnum prioridade) {
    setTitulo(titulo);
    setResponsavel(responsavel);
    setPrioridade(prioridade);

    this.id = proximoId++;
    this.status = StatusEnum.ABERTO;
  }

  public long getId() {
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

  public String getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(String responsavel) {
    if (responsavel == null || responsavel.trim().isEmpty()) {
      throw new IllegalArgumentException("O responsável não pode estar vazio.");
    }

    this.responsavel = responsavel;
  }

  public PrioridadeEnum getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(PrioridadeEnum prioridade) {
    if (prioridade == null) {
      throw new IllegalArgumentException("A prioridade não pode ser nula.");
    }

    this.prioridade = prioridade;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void encerrar() {
    if (this.status == StatusEnum.ENCERRADO) {
      throw new IllegalStateException(
          "Não é possível encerrar um chamado que já está encerrado.");
    }

    this.status = StatusEnum.ENCERRADO;
  }

  @Override
  public String toString() {
    return "Chamado{" +
        "id=" + getId() +
        ", titulo='" + getTitulo() + '\'' +
        ", responsavel='" + getResponsavel() + '\'' +
        ", prioridade=" + getPrioridade() +
        ", status=" + getStatus() +
        '}';
  }
}
