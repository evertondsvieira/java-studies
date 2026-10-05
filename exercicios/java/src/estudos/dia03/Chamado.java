package estudos.dia03;

public class Chamado {
  private static long proximoId = 1;

  private final long id;
  private String titulo;
  private PrioridadeEnum prioridade;

  public Chamado(String titulo, PrioridadeEnum prioridade) {
    setTitulo(titulo);
    setPrioridade(prioridade);

    this.id = proximoId++;
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

  public PrioridadeEnum getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(PrioridadeEnum prioridade) {
    if (prioridade == null) {
      throw new IllegalArgumentException("A prioridade não pode ser nula.");
    }

    this.prioridade = prioridade;
  }

}
