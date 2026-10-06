package estudos.dia05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ChamadoRepository {

  public void gravarChamado(Chamado chamado) throws IOException {
    if (chamado == null) {
      throw new RegraNegocioException("O chamado não pode ser nulo.");
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("chamados-salvos.txt", true))) {
      writer.write(
          chamado.getTitulo() + ";" + chamado.getCriadoEm());
      writer.newLine();
    }
  }
}
