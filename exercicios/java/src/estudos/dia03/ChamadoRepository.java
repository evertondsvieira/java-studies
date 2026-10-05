package estudos.dia03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChamadoRepository {
  private final Map<Long, Chamado> chamados = new HashMap<>();

  public void inserirChamado(Chamado chamado) {
    if (chamado == null) {
      throw new IllegalArgumentException("O chamado não pode ser nulo.");
    }

    if (chamados.containsKey(chamado.getId())) {
      throw new IllegalArgumentException(
          "Já existe um chamado com o ID " + chamado.getId());
    }

    chamados.put(chamado.getId(), chamado);
  }

  public Chamado buscarPorId(long id) {
    Chamado chamado = chamados.get(id);

    if (chamado == null) {
      throw new IllegalArgumentException(
          "Não existe chamado com o ID " + id);
    }

    return chamado;
  }

  public void atualizarChamado(long id, String novoTitulo, PrioridadeEnum novaPrioridade) {
    Chamado chamado = buscarPorId(id);

    chamado.setTitulo(novoTitulo);
    chamado.setPrioridade(novaPrioridade);
  }

  public void removerChamado(long id) {
    buscarPorId(id);
    chamados.remove(id);
  }

  public List<Chamado> listarPorPrioridade() {
    List<Chamado> lista = new ArrayList<>(chamados.values());
    lista.sort(Comparator.comparing(Chamado::getPrioridade));
    return lista;
  }
}
