public class Chamado {
  private static int proximoId = 1;

  private final int id;
  private String titulo;
  private String prioridade;
  private String status;

  public Chamado(String titulo, String prioridade, String status) {
    this.id = proximoId++;
    this.titulo = titulo;
    this.prioridade = prioridade;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(String prioridade) {
    this.prioridade = prioridade;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void encerrar() {
    this.status = "ENCERRADO";
  }
}
