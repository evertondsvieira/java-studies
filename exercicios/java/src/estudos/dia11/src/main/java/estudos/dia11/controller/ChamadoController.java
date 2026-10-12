package estudos.dia11.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudos.dia11.dto.ChamadoRequest;
import estudos.dia11.dto.ChamadoResponse;
import estudos.dia11.service.ChamadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("chamados")
public class ChamadoController {
  
  private final ChamadoService service;

  public ChamadoController(ChamadoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<ChamadoResponse> cadastrar(
    @Valid @RequestBody ChamadoRequest dto
  ) {
    ChamadoResponse response = service.cadastrar(dto);

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(response);
  }

  @GetMapping
  public ResponseEntity<List<ChamadoResponse>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ChamadoResponse> buscarPorId(
    @PathVariable Long id
  ) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }
}
