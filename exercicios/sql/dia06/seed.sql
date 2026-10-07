INSERT INTO usuario (nome, email)
VALUES
  ('Everton', 'everton@email.com'),
  ('Ana', 'ana@email.com'),
  ('Carlos', 'carlos@email.com');

INSERT INTO chamado (titulo, descricao, responsavel_id)
VALUES
  ('Sistema fora do ar', 'Usuário não consegue acessar o sistema', 1),
  ('Erro no login', 'Senha não está sendo aceita', 1),
  ('Impressora offline', 'Impressora não responde', 2),
  ('Internet lenta', 'Conexão apresenta lentidão', 2),
  ('Erro no e-mail', 'Usuário não consegue enviar mensagens', 3),
  ('Computador travando', 'Máquina apresenta lentidão', 3),
  ('Acesso bloqueado', 'Usuário perdeu acesso ao sistema', 1),
  ('Monitor sem imagem', 'Monitor não exibe sinal', 2);
