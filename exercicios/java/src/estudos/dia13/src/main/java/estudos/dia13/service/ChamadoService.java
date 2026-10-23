package estudos.dia13.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import estudos.dia13.model.Chamado;
import estudos.dia13.repository.ChamadoRepository;

@Service
public class ChamadoService {
  
  private final ChamadoRepository repository;

  public ChamadoService(ChamadoRepository repository) {
    this.repository = repository;
  }

  public Chamado cadastrar(String titulo) {
    Chamado chamado = new Chamado(titulo);
    return repository.save(chamado);
  }

  public List<Chamado> listar() {
    return repository.findAll();
  }

  public Chamado buscarPorId(Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Chamado não encontrado"
      ));
  }

  public Chamado atualizar(Long id, String titulo) {
    Chamado chamado = buscarPorId(id);
    chamado.setTitulo(titulo);
    return repository.save(chamado);
  }

  public void excluir(Long id) {
    Chamado chamado = buscarPorId(id);
    repository.delete(chamado);
  }
}
