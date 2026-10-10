INSERT INTO usuario (nome, email)
VALUES
	('Everton', 'everton@email.com'),
	('Ana', 'ana@email.com'),
	('Carlos', 'carlos@email.com'),
	('Dagoberto', 'dagoberto@email.com');

INSERT INTO chamado (titulo, descricao, status, responsavel_id, criado_em)
VALUES
	('Sistema fora do ar', 'Usuário não consegue acessar o sistema', 'ABERTO', 1, '2026-10-01 08:00:00'),
	('Erro no login', 'Senha não está sendo aceita', 'FECHADO', 1, '2026-10-01 09:00:00'),
	('Impressora offline', 'Impressora não responde', 'ABERTO', 2, '2026-10-02 10:00:00'),
	('Internet lenta', 'Conexão apresenta lentidão', 'EM_ANDAMENTO', 2, '2026-10-02 11:00:00'),
	('Erro no e-mail', 'Usuário não consegue enviar mensagens', 'FECHADO', 3, '2026-10-03 08:30:00'),
	('Computador travando', 'Máquina apresenta lentidão', 'ABERTO', 3, '2026-10-03 14:00:00'),
	('Acesso bloqueado', 'Usuário perdeu acesso ao sistema', 'ABERTO', 1, '2026-10-04 09:00:00'),
	('Monitor sem imagem', 'Monitor não exibe sinal', 'FECHADO', 2, '2026-10-05 10:00:00'),
	('Teclado com defeito', 'Algumas teclas não funcionam', 'ABERTO', NULL, '2026-10-06 15:00:00'),
	('Erro na atualização', 'Sistema apresenta falha ao atualizar', 'EM_ANDAMENTO', 1, '2026-10-07 16:00:00');

INSERT INTO historico_chamado (chamado_id, status, criado_em)
VALUES
  (1, 'ABERTO', '2026-10-01 08:00:00'),
  (2, 'ABERTO', '2026-10-01 09:00:00'),
  (2, 'EM_ANDAMENTO', '2026-10-01 10:00:00'),
  (2, 'FECHADO', '2026-10-01 11:30:00'),
  (3, 'ABERTO', '2026-10-02 10:00:00'),
  (4, 'ABERTO', '2026-10-02 11:00:00'),
  (4, 'EM_ANDAMENTO', '2026-10-02 13:00:00'),
  (5, 'ABERTO', '2026-10-03 08:30:00'),
  (5, 'EM_ANDAMENTO', '2026-10-03 09:00:00'),
  (5, 'FECHADO', '2026-10-03 11:00:00'),
  (6, 'ABERTO', '2026-10-03 14:00:00'),
  (7, 'ABERTO', '2026-10-04 09:00:00'),
  (8, 'ABERTO', '2026-10-05 10:00:00'),
  (8, 'EM_ANDAMENTO', '2026-10-05 11:00:00'),
  (8, 'FECHADO', '2026-10-05 13:00:00'),
  (9, 'ABERTO', '2026-10-06 15:00:00'),
  (10, 'ABERTO', '2026-10-07 16:00:00'),
  (10, 'EM_ANDAMENTO', '2026-10-07 17:00:00');
