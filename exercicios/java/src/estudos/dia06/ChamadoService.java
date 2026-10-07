package estudos.dia06;

public class ChamadoService {
  private final UsuarioRepository usuarioRepository;
  private final ChamadoRepository chamadoRepository;

  public ChamadoService(UsuarioRepository usuarioRepository, ChamadoRepository chamadoRepository) {
    this.usuarioRepository = usuarioRepository;
    this.chamadoRepository = chamadoRepository;
  }

  public Chamado criarChamado(String titulo, String descricao, Long responsavelId) {
    if (titulo == null || titulo.trim().isEmpty()) {
      throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
    }

    Usuario responsavel = usuarioRepository.buscarPorId(responsavelId);
    Chamado chamado = new Chamado(titulo, descricao, responsavel);
    chamadoRepository.salvar(chamado);
    return chamado;
  }
}
