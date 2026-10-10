-- COMMIT
SELECT id, status
FROM chamado
WHERE id = 1;

BEGIN;

UPDATE chamado
SET status = 'EM_ANDAMENTO'
WHERE id = 1;

INSERT INTO historico_chamado (chamado_id, status, criado_em)
VALUES (1, 'EM_ANDAMENTO', '2026-10-01 09:30:00');

COMMIT;

SELECT *
FROM historico_chamado
WHERE chamado_id = 1;

-- ROLLBACK
BEGIN;

UPDATE chamado
SET status = 'FECHADO'
WHERE id = 1;

INSERT INTO historico_chamado (chamado_id, status, criado_em)
VALUES (1, 'FECHADO', '2026-10-01 10:30:00');

INSERT INTO historico_chamado (chamado_id, status, criado_em)
VALUES (NULL, 'ABERTO', '2026-10-01 10:31:00');

ROLLBACK;

SELECT id, status
FROM chamado
WHERE id = 1;

SELECT id, chamado_id, status, criado_em
FROM historico_chamado
WHERE chamado_id = 1
ORDER BY id;

-- INDEX
EXPLAIN
SELECT id, titulo, status, criado_em
FROM chamado
WHERE status = 'ABERTO'
  AND criado_em >= '2026-10-03'
  AND criado_em < '2026-10-07';

CREATE INDEX idx_chamado_status_criado_em
ON chamado (status, criado_em);

EXPLAIN
SELECT id, titulo, status, criado_em
FROM chamado
WHERE status = 'ABERTO'
  AND criado_em >= '2026-10-03'
  AND criado_em < '2026-10-07';
