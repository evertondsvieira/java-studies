package estudos.dia04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChamadoRepository {
  private final Map<Long, Chamado> chamados = new HashMap<>();

  public void inserirChamado(Chamado chamado) {
    if (chamado == null) {
      throw new IllegalArgumentException("O chamado não pode ser nulo.");
    }

    if (chamados.containsKey(chamado.getId())) {
      throw new IllegalArgumentException("Já existe um chamado com o ID " + chamado.getId());
    }

    chamados.put(chamado.getId(), chamado);
  }

  public Optional<Chamado> buscarPorId(long id) {
    return Optional.ofNullable(chamados.get(id));
  }

  public List<Chamado> listarTodos() {
    return new ArrayList<>(chamados.values());
  }

  public void atualizar(Chamado chamado) {
    if (chamado == null) {
      throw new IllegalArgumentException("O chamado não pode ser nulo.");
    }

    if (!chamados.containsKey(chamado.getId())) {
      throw new IllegalArgumentException(
          "Não existe chamado com o ID " + chamado.getId());
    }

    chamados.put(chamado.getId(), chamado);
  }

  public void removerChamado(long id) {
    Chamado removido = chamados.remove(id);

    if (removido == null) {
      throw new IllegalArgumentException(
          "Não existe chamado com o ID " + id);
    }
  }
}
