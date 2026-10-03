package estudos.dia02;

public class Chamado {
  private static int proximoId = 1;

  private final int id;
  private String titulo;
  private PrioridadeEnum prioridade;
  private StatusEnum status;

  public Chamado(String titulo, PrioridadeEnum prioridade) {
    setTitulo(titulo);
    setPrioridade(prioridade);

    this.id = proximoId++;
    this.status = StatusEnum.ABERTO;
  }

  public int getId() {
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

  public PrioridadeEnum getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(PrioridadeEnum prioridade) {
    if (prioridade == null) {
      throw new IllegalArgumentException(
          "A prioridade não pode ser nula.");
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

  public void reabrir() {
    if (this.status == StatusEnum.ABERTO) {
      throw new IllegalStateException("Não é possível reabrir um chamado que já está aberto.");
    }

    this.status = StatusEnum.ABERTO;
  }
}
