package estudos.dia10.controller;

import org.springframework.web.bind.annotation.RestController;

import estudos.dia10.model.Chamado;
import estudos.dia10.service.ChamadoService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ChamadoController {

  private final ChamadoService service;

  public ChamadoController(ChamadoService service) {
    this.service = service;
  }

  @GetMapping("/health")
  public Map<String, String> health() {
    return Map.of("status", "UP");
  }

  @GetMapping("/chamados")
  public List<Chamado> listar(){
    return service.listarTodos();
  }
}
