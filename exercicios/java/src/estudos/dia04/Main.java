package estudos.dia04;

public class Main {
  public static void main(String[] args) {
    ChamadoRepository repository = new ChamadoRepository();
    ChamadoService service = new ChamadoService(repository);

    Chamado chamado1 = service.criarChamado("Título 1", "Responsável 1", PrioridadeEnum.ALTA);
    Chamado chamado2 = service.criarChamado("Título 2", "Responsável 1", PrioridadeEnum.MEDIA);
    service.criarChamado("Título 3", "Responsável 3", PrioridadeEnum.BAIXA);
    service.criarChamado("Título 4", "Responsável 2", PrioridadeEnum.BAIXA);
    service.criarChamado("Título 5", "Responsável 2", PrioridadeEnum.MEDIA);
    Chamado chamado6 = service.criarChamado("Título 6", "Responsável 3", PrioridadeEnum.ALTA);
    Chamado chamado7 = service.criarChamado("Título 7", "Responsável 3", PrioridadeEnum.MEDIA);
    service.criarChamado("Título 8", "Responsável 4", PrioridadeEnum.ALTA);

    service.encerrar(chamado2.getId());
    service.encerrar(chamado6.getId());
    service.encerrar(chamado7.getId());

    System.out.println("\nAbertos usando for: ");
    service.listarAbertosFor().forEach(System.out::println);

    System.out.println("\nAbertos usando stream: ");
    service.listarAbertosStream().forEach(System.out::println);

    boolean resultadosIguais = service.listarAbertosFor().equals(service.listarAbertosStream());
    System.out.println("\nOs filtros retornam a mesma lista? " + resultadosIguais);

    System.out.println("\nOrdenados por prioridade e ID: ");
    service.listarOrdenadosPorPrioridadeEId().forEach(System.out::println);

    System.out.println("\nContagem por status: ");
    service.contarPorStatus().forEach((status, quantidade) -> System.out.println(status + ": " + quantidade));

    System.out.println("\nAgrupados por responsável: ");
    service.agruparPorResponsavel().forEach((responsavel, chamados) -> {
      System.out.println("Responsável: " + responsavel);
      chamados.forEach(System.out::println);
    });

    System.out.println("\nBusca por id existente:");
    System.out.println(service.buscarPorId(chamado1.getId()));

    System.out.println("\nBusca por id inexistente: ");
    try {
      service.buscarPorId(999);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
