package estudos.dia06;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
  private final List<Usuario> usuarios = new ArrayList<>();

  public void salvar(Usuario usuario) {
    if (usuario == null) {
      throw new IllegalArgumentException("O usuário não pode ser nulo.");
    }

    if (emailJaExiste(usuario.getEmail())) {
      throw new IllegalArgumentException("O e-mail já está em uso.");
    }

    usuarios.add(usuario);
  }

  private boolean emailJaExiste(String email) {
    return usuarios.stream()
        .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
  }

  public Usuario buscarPorId(Long id) {
    return usuarios.stream()
        .filter(usuario -> usuario.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("O responsável não está cadastrado."));
  }
}
