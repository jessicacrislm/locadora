-- POPULAR TABELA DE FILMES
INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (1, 'Harry Potter e o Prisioneiro de Azkaban', 'AVENTURA', 'Alfonso Cuarón', 2004, 2, 'NORMAL');

INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (2, 'O Poderoso Chefão', 'DRAMA', 'Francis Ford Coppola', 1972, 2, 'LEGADO');

INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (3, 'As Patricinhas de Bervely Hills', 'COMEDIA', 'Amy Heckerling', 1995, 1, 'LEGADO');

INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (4, 'Vingadores: Ultimato', 'ACAO', 'Joe/Anthony Russo', 2019 , 4, 'LANCAMENTO');

INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (5, 'Toy Story 4', 'ANIMACAO', 'Josh Cooley', 2019, 2, 'LANCAMENTO');

INSERT INTO tb_filme (id_filme, ds_titulo, en_genero, ds_diretor, dt_ano_lancamento, nm_quantidade, en_tipo) 
VALUES (6, 'Nasce uma estrela', 'MUSICAL', 'Bradley Cooper', 2018, 3, 'NORMAL');

-- POPULAR TABELA DE USUARIOS 
INSERT INTO tb_usuario (id_usuario, ds_nome, en_sexo, dt_data_nascimento, ds_cpf) 
VALUES(1, 'Jessica Machado', 'FEMININO', '1994-08-09', '23354786051');

INSERT INTO tb_usuario (id_usuario, ds_nome, en_sexo, dt_data_nascimento, ds_cpf) 
VALUES(2, 'Matheus Henrique', 'MASCULINO', '1997-08-12', '74899193041');

INSERT INTO tb_usuario (id_usuario, ds_nome, en_sexo, dt_data_nascimento, ds_cpf) 
VALUES(3, 'Josias Malaquias', 'MASCULINO', '1980-07-13', '39822764030');

INSERT INTO tb_usuario (id_usuario, ds_nome, en_sexo, dt_data_nascimento, ds_cpf) 
VALUES(4, 'Vitória Leite', 'MASCULINO', '2004-12-25', '48557730004');

-- POPULAR TABELA DE LOCACOES 
INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(1, null, 4, 3, '2020-04-24 12:40', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(2, 1, 4, 3, '2020-04-25 12:30', null, 'RENOVADO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(3, null, 1, 1, '2020-04-24 14:56', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(4, null, 2, 1, '2020-04-24 14:56', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(5, null, 3, 1, '2020-04-24 14:56', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(6, null, 4, 1, '2020-04-24 14:56', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(7, null, 5, 1, '2020-04-24 14:56', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(8, null, 6, 2, '2020-04-24 13:20', null, 'ABERTO');

INSERT INTO tb_locacao (id_locacao, id_locacao_principal, id_filme, id_usuario, dt_data_locacao, dt_data_devolucao, en_status) 
VALUES(9, null, 5, 2, '2020-04-15 13:20', '2020-04-16 13:00', 'FECHADO');
