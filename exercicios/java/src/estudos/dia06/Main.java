package estudos.dia06;

public class Main {
  public static void main(String[] args) {
    UsuarioRepository repository = new UsuarioRepository();
    UsuarioService usuarioService = new UsuarioService(repository);
    ChamadoRepository chamadoRepository = new ChamadoRepository();
    ChamadoService chamadoService = new ChamadoService(repository, chamadoRepository);

    Usuario everton = usuarioService.cadastrarUsuario("Everton", "everton@email.com");
    Usuario ana = usuarioService.cadastrarUsuario("Ana", "ana@email.com");
    Usuario carlos = usuarioService.cadastrarUsuario("Carlos", "carlos@email.com");

    chamadoService.criarChamado("Sistema fora do ar", "Usuário não consegue acessar o sistema", everton.getId());
    chamadoService.criarChamado("Erro no login", "Senha não está sendo aceita", everton.getId());
    chamadoService.criarChamado("Impressora offline", "Impressora não responde", ana.getId());
    chamadoService.criarChamado("Internet lenta", "Conexão apresenta lentidão", ana.getId());
    chamadoService.criarChamado("Erro no e-mail", "Usuário não consegue enviar mensagens", carlos.getId());
    chamadoService.criarChamado("Computador travando", "Máquina apresenta lentidão", carlos.getId());
    chamadoService.criarChamado("Acesso bloqueado", "Usuário perdeu acesso ao sistema", everton.getId());
    chamadoService.criarChamado("Monitor sem imagem", "Monitor não exibe sinal", ana.getId());

    for (Chamado chamado : chamadoRepository.listarTodos()) {
      System.out.println(chamado.getId() + " - " + chamado.getTitulo() 
          + " | Descrição: " + chamado.getDescricao()
          + " | Responsável: " + chamado.getResponsavel().getNome());
    }

    try {
      usuarioService.cadastrarUsuario("Outro Everton", "everton@email.com");
    } catch (IllegalArgumentException e) {
      System.out.println("Email duplicado rejeitado: " + e.getMessage());
    }

    try {
      chamadoService.criarChamado("Teste de responsável inválido", "Chamado com responsável inválido", -1L);
    } catch (IllegalArgumentException e) {
      System.out.println("Responsável inválido rejeitado: " + e.getMessage());
    }
  }
}
