CREATE TABLE IF NOT EXISTS responsaveis (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS tarefas (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    prioridade VARCHAR(255) NOT NULL,
    situacao VARCHAR(255) NOT NULL,
    deadline DATE,
    excluida BOOLEAN NOT NULL DEFAULT FALSE,
    responsavel_id BIGINT REFERENCES responsaveis(id)
    );


INSERT INTO responsaveis (nome) VALUES ('João Silva');
INSERT INTO responsaveis (nome) VALUES ('Maria Oliveira');
INSERT INTO responsaveis (nome) VALUES ('Carlos Santos');

INSERT INTO tarefas (titulo, descricao, prioridade, situacao, deadline, excluida, responsavel_id)
VALUES ('Implementar login', 'Criar tela de login com autenticação', 'ALTA', 'EM_ANDAMENTO', '2026-05-01', false, 1);

INSERT INTO tarefas (titulo, descricao, prioridade, situacao, deadline, excluida, responsavel_id)
VALUES ('Corrigir bug no relatório', 'Relatório de vendas apresentando valores incorretos', 'ALTA', 'EM_ANDAMENTO', '2026-04-20', false, 2);

INSERT INTO tarefas (titulo, descricao, prioridade, situacao, deadline, excluida, responsavel_id)
VALUES ('Documentar API', 'Escrever documentação dos endpoints REST', 'MEDIA', 'EM_ANDAMENTO', '2026-05-10', false, 1);

INSERT INTO tarefas (titulo, descricao, prioridade, situacao, deadline, excluida, responsavel_id)
VALUES ('Revisar testes unitários', 'Aumentar cobertura de testes do módulo financeiro', 'MEDIA', 'EM_ANDAMENTO', '2026-05-15', false, 3);

INSERT INTO tarefas (titulo, descricao, prioridade, situacao, deadline, excluida, responsavel_id)
VALUES ('Atualizar dependências', 'Atualizar bibliotecas do projeto para versões mais recentes', 'BAIXA', 'EM_ANDAMENTO', '2026-06-01', false, 2);