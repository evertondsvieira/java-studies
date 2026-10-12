package estudos.dia10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import estudos.dia10.model.Chamado;

@Service
public class ChamadoService {

  public List<Chamado> listarTodos() {
    return List.of(
      new Chamado(
        1L,
        "Internet não funciona",
        "Computador sem conexão"
      ),
      new Chamado(
        2L,
        "Tela azul",
        "Sistema apresenta falha ao iniciar"
      )
    );
  }
}
