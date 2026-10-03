package estudos.dia02;

public class ChamadoService {
  public Chamado criarChamado(String titulo, PrioridadeEnum prioridade) {
    Chamado chamado = new Chamado(titulo, prioridade);

    System.out.printf(
        "ID: %d | Título: %s | Prioridade: %s | Status: %s%n",
        chamado.getId(), chamado.getTitulo(), chamado.getPrioridade(), chamado.getStatus());

    return chamado;
  }

  public void reabrir(Chamado chamado) {
    chamado.reabrir();
  }
}
