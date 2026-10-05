package estudos.dia04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChamadoService {
  private final ChamadoRepository repository;

  public ChamadoService(ChamadoRepository repository) {
    this.repository = repository;
  }

  public Chamado criarChamado(String titulo, String responsavel, PrioridadeEnum prioridade) {
    Chamado chamado = new Chamado(titulo, responsavel, prioridade);
    repository.inserirChamado(chamado);
    return chamado;
  }

  public List<Chamado> listarAbertosFor() {
    List<Chamado> abertos = new ArrayList<>();

    for (Chamado chamado : repository.listarTodos()) {
      if (chamado.getStatus() == StatusEnum.ABERTO) {
        abertos.add(chamado);
      }
    }

    return abertos;
  }

  public List<Chamado> listarAbertosStream() {
    return repository.listarTodos().stream()
        .filter(chamado -> chamado.getStatus() == StatusEnum.ABERTO)
        .collect(Collectors.toList());
  }

  public List<Chamado> listarOrdenadosPorPrioridadeEId() {
    return repository.listarTodos()
        .stream()
        .sorted(
            Comparator.comparing(Chamado::getPrioridade)
                .thenComparing(Chamado::getId))
        .collect(Collectors.toList());
  }

  public Map<StatusEnum, Long> contarPorStatus() {
    Map<StatusEnum, Long> contagem = new HashMap<>();

    for (Chamado chamado : repository.listarTodos()) {
      StatusEnum status = chamado.getStatus();

      Long quantidadeAtual = contagem.getOrDefault(status, 0L);

      contagem.put(status, quantidadeAtual + 1);
    }

    return contagem;
  }

  public Map<String, List<Chamado>> agruparPorResponsavel() {
    return repository.listarTodos().stream()
        .collect(Collectors.groupingBy(Chamado::getResponsavel));
  }

  public Chamado buscarPorId(long id) {
    return repository.buscarPorId(id)
        .orElseThrow(() -> new IllegalArgumentException(
            "Chamado não encontrado: " + id));
  }

  public void encerrar(long id) {
    Chamado chamado = buscarPorId(id);
    chamado.encerrar();
  }
}
