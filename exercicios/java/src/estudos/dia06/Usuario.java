package estudos.dia06;

public final class Usuario {
  private static long proximoId = 1;

  private final Long id;
  private String nome;
  private String email;

  public Usuario(String nome, String email) {
    setNome(nome);
    setEmail(email);

    this.id = proximoId++;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome == null) {
      throw new IllegalArgumentException("O nome não pode ser nulo.");
    }

    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email == null || email.trim().isEmpty()) {
      throw new IllegalArgumentException("O e-mail não pode ser nulo ou vazio.");
    }

    if (!email.contains("@")) {
      throw new IllegalArgumentException("Deve ser um e-mail válido.");
    }

    this.email = email;
  }
}
