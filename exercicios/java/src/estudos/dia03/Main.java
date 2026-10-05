package estudos.dia03;

public class Main {
  public static void main(String[] args) {
    ChamadoRepository repository = new ChamadoRepository();
    ChamadoService service = new ChamadoService(repository);

    Chamado chamado1 = service.criarChamado("Título 1", PrioridadeEnum.ALTA);
    service.criarChamado("Título 2", PrioridadeEnum.BAIXA);
    service.criarChamado("Título 3", PrioridadeEnum.MEDIA);

    Chamado encontrado = repository.buscarPorId(chamado1.getId());
    System.out.println("Encontrado: " + encontrado.getTitulo());

    repository.atualizarChamado(
        chamado1.getId(),
        "Novo Título",
        PrioridadeEnum.MEDIA);

    System.out.println(
        "Atualizado: "
            + repository.buscarPorId(chamado1.getId()).getTitulo());

    for (Chamado item : repository.listarPorPrioridade()) {
      System.out.printf(
          "ID: %d | Título: %s | Prioridade: %s%n",
          item.getId(),
          item.getTitulo(),
          item.getPrioridade());
    }

    repository.removerChamado(chamado1.getId());

    try {
      repository.buscarPorId(999);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      repository.removerChamado(999);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      repository.atualizarChamado(
          999,
          "Título inexistente",
          PrioridadeEnum.ALTA);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}