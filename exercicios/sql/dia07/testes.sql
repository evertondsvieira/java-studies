-- WHERE
SELECT
	titulo,
	status
FROM
	chamado
WHERE status = 'ABERTO';

-- INNER JOIN
SELECT
	c.titulo,
	c.descricao,
	u.nome AS responsavel
FROM chamado AS c
INNER JOIN usuario AS u
	ON c.responsavel_id = u.id;

-- LEFT JOIN
SELECT
	u.nome,
	c.titulo,
	c.descricao
FROM usuario AS u
LEFT JOIN chamado AS c
	ON u.id = c.responsavel_id
WHERE c.id IS NULL;

-- GROUP BY
SELECT
	status,
	COUNT(*) AS total
FROM chamado
GROUP BY status;

-- HAVING
SELECT
	u.nome,
	COUNT(c.id) AS total
FROM usuario AS u
INNER JOIN chamado AS c
	ON u.id = c.responsavel_id
GROUP BY u.id, u.nome
HAVING COUNT(c.id) > 2;

-- NULL
SELECT
	id,
	titulo,
	responsavel_id
FROM chamado
WHERE responsavel_id IS NULL;

-- ORDER BY
SELECT
	id,
	titulo,
	criado_em
FROM chamado
ORDER BY criado_em DESC, id DESC
LIMIT 3;
