package estudos.dia06;

public class UsuarioService {
  private final UsuarioRepository repository;

  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  public Usuario cadastrarUsuario(String nome, String email) {
    Usuario usuario = new Usuario(nome, email);
    repository.salvar(usuario);
    return usuario;
  }
}
