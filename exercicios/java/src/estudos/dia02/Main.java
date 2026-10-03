package estudos.dia02;

public class Main {

  public static void main(String[] args) {
    ChamadoService service = new ChamadoService();

    verificarCadastroValido(service);
    verificarTituloInvalido(service);
    verificarTransicaoInvalida(service);
    verificarEncerramentoEReabertura(service);
  }

  private static void verificarCadastroValido(ChamadoService service) {
    Chamado chamado = service.criarChamado(
        "Título 1",
        PrioridadeEnum.ALTA);

    if (chamado.getId() <= 0
        || !"Título 1".equals(chamado.getTitulo())
        || chamado.getPrioridade() != PrioridadeEnum.ALTA
        || chamado.getStatus() != StatusEnum.ABERTO) {

      throw new AssertionError(
          "FALHOU: cadastro válido retornou dados incorretos.");
    }

    System.out.println("PASSOU: cadastro válido.");
  }

  private static void verificarTituloInvalido(ChamadoService service) {
    try {
      service.criarChamado(
          "   ",
          PrioridadeEnum.ALTA);

      throw new AssertionError(
          "FALHOU: título vazio foi aceito.");

    } catch (IllegalArgumentException e) {
      System.out.printf(
          "PASSOU: título inválido rejeitado. %s%n",
          e.getMessage());
    }
  }

  private static void verificarTransicaoInvalida(ChamadoService service) {
    Chamado chamado = service.criarChamado(
        "Título 2",
        PrioridadeEnum.BAIXA);

    try {
      service.reabrir(chamado);

      throw new AssertionError(
          "FALHOU: reabertura de chamado aberto foi aceita.");

    } catch (IllegalStateException e) {

      if (chamado.getStatus() != StatusEnum.ABERTO) {
        throw new AssertionError(
            "FALHOU: a operação rejeitada alterou o status.");
      }

      System.out.printf(
          "PASSOU: transição inválida rejeitada e status preservado. %s%n",
          e.getMessage());
    }
  }

  private static void verificarEncerramentoEReabertura(ChamadoService service) {
    Chamado chamado = service.criarChamado(
        "Título 3",
        PrioridadeEnum.MEDIA);

    chamado.encerrar();

    if (chamado.getStatus() != StatusEnum.ENCERRADO) {
      throw new AssertionError(
          "FALHOU: chamado não foi encerrado corretamente.");
    }

    service.reabrir(chamado);

    if (chamado.getStatus() != StatusEnum.ABERTO) {
      throw new AssertionError(
          "FALHOU: chamado não foi reaberto corretamente.");
    }

    System.out.println(
        "PASSOU: chamado encerrado e reaberto corretamente.");
  }
}