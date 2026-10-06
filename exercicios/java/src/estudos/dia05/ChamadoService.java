package estudos.dia05;

import java.time.LocalDate;

public class ChamadoService {
  public Chamado criarChamado(String titulo, LocalDate criadoEm) {
    return new Chamado(titulo, criadoEm);
  }
}
