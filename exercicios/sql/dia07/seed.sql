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
