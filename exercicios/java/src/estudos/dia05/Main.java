package estudos.dia05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {

    ChamadoRepository repository = new ChamadoRepository();
    ChamadoService service = new ChamadoService();

    int aceitas = 0;
    int rejeitadas = 0;
    int numeroLinha = 0;

    try (
        FileReader arquivo = new FileReader("chamado.txt");
        BufferedReader reader = new BufferedReader(arquivo)) {

      String linha;

      while ((linha = reader.readLine()) != null) {
        numeroLinha++;

        try {
          Chamado chamado = service.criarChamado(linha, LocalDate.now());
          repository.gravarChamado(chamado);
          aceitas++;

          System.out.println(
              chamado.getId() + " - " + chamado.getTitulo());
        } catch (RegraNegocioException e) {
          rejeitadas++;
          System.out.println("Linha " + numeroLinha + " rejeitada: " + e.getMessage());
        }
      }

    } catch (IOException e) {
      System.out.println("Erro ao ler ou gravar o arquivo: " + e.getMessage());
    }

    System.out.println("Linhas aceitas: " + aceitas);
    System.out.println("Linhas rejeitadas: " + rejeitadas);
  }
}
