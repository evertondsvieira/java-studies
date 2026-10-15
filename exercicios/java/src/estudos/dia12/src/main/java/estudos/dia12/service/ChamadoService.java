package estudos.dia12.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import estudos.dia12.dto.ChamadoRequest;
import estudos.dia12.dto.ChamadoResponse;
import estudos.dia12.model.Chamado;

@Service
public class ChamadoService {
  private final Map<Long, Chamado> chamados = new HashMap<>();

  public ChamadoResponse cadastrar(ChamadoRequest dto) {
    Chamado chamado = new Chamado(dto.titulo(), dto.descricao());
    chamados.put(chamado.getId(), chamado);
    return toDTO(chamado);
  }

  public List<ChamadoResponse> listar() {
    return chamados.values()
        .stream()
        .map(this::toDTO)
        .toList();
  }

  public ChamadoResponse buscarPorId(Long id) {
    return toDTO(buscarEntidade(id));
  }

  private Chamado buscarEntidade(Long id) {
    Chamado chamado = chamados.get(id);

    if (chamado == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Chamado não encontrado");
    }

    return chamado;
  }

  public ChamadoResponse atualizar(Long id, ChamadoRequest dto) {
    Chamado chamado = buscarEntidade(id);

    chamado.setTitulo(dto.titulo());
    chamado.setDescricao(dto.descricao());

    return toDTO(chamado);
  }

  public void excluir(long id) {
    buscarEntidade(id);
    chamados.remove(id);
  }

  private ChamadoResponse toDTO(Chamado chamado) {
    return new ChamadoResponse(
        chamado.getId(),
        chamado.getTitulo(),
        chamado.getDescricao());
  }
}
