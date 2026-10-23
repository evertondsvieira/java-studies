package estudos.dia13.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudos.dia13.dto.ChamadoRequest;
import estudos.dia13.model.Chamado;
import estudos.dia13.service.ChamadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("chamados")
public class ChamadoController {
  
  private final ChamadoService service;

  public ChamadoController(ChamadoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Chamado> cadastrar(
    @Valid @RequestBody ChamadoRequest request
  ) {
    Chamado response = service.cadastrar(request.titulo());
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(response);
  }

  @GetMapping
  public ResponseEntity<List<Chamado>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Chamado> buscarPorId(
    @PathVariable Long id
  ) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Chamado> atualizar(
    @PathVariable Long id,
    @Valid @RequestBody ChamadoRequest request
  ) {
    return ResponseEntity.ok(
      service.atualizar(id, request.titulo())
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(
    @PathVariable Long id
  ) {
    service.excluir(id);
    return ResponseEntity.noContent().build();
  }
}
