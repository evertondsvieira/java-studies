package estudos.dia03;

public class ChamadoService {
  private final ChamadoRepository repository;

  public ChamadoService(ChamadoRepository repository) {
    this.repository = repository;
  }

  public Chamado criarChamado(String titulo, PrioridadeEnum prioridade) {
    Chamado chamado = new Chamado(titulo, prioridade);
    repository.inserirChamado(chamado);
    return chamado;
  }
}
