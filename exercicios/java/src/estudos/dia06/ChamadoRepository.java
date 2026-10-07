package estudos.dia06;

import java.util.ArrayList;
import java.util.List;

public class ChamadoRepository {
  private final List<Chamado> chamados = new ArrayList<>();

  public void salvar(Chamado chamado) {
    if (chamado == null) {
      throw new IllegalArgumentException("O chamado não pode ser nulo.");
    }

    chamados.add(chamado);
  }

  public List<Chamado> listarTodos() {
    return List.copyOf(chamados);
  }
}
