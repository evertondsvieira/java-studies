package estudos.dia01;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Chamado> chamados = new ArrayList<Chamado>();

    Chamado chamado1 = new Chamado("Título 1", "ALTA", "ABERTO");
    Chamado chamado2 = new Chamado("Título 2", "BAIXA", "ABERTO");
    Chamado chamado3 = new Chamado("Título 3", "MÉDIA", "ABERTO");

    chamados.add(chamado1);
    chamados.add(chamado2);
    chamados.add(chamado3);

    System.out.println("ANTES DO ENCERRAMENTO:\n");

    for (Chamado chamado : chamados) {
      if (chamado.getStatus().equals("ABERTO")) {
        System.out.printf(
            "ID: %d | Título: %s | Prioridade: %s | Status: %s%n",
            chamado.getId(),
            chamado.getTitulo(),
            chamado.getPrioridade(),
            chamado.getStatus());
      }
    }

    chamado2.encerrar();

    System.out.println("\nDEPOIS DO ENCERRAMENTO:\n");

    for (Chamado chamado : chamados) {
      if (chamado.getStatus().equals("ABERTO")) {
        System.out.printf(
            "ID: %d | Título: %s | Prioridade: %s | Status: %s%n",
            chamado.getId(),
            chamado.getTitulo(),
            chamado.getPrioridade(),
            chamado.getStatus());
      }
    }
  }
}
