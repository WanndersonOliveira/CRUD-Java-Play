insert into Professor values(1, 'barao@sqlserver', 'José Antônio da Cunha', 'sql123');

insert into Professor values(2, 'placido@tades', 'Plácido Antônio da Silva Netto', 'tades20182');
insert into Professor values(3, 'jorge@hotmail.com', 'Gorjiano Vidal', 'sqlcplusplus');
insert into Professor values(4, 'george@gmail.com', 'George Azevedo', 'sqloracle');


insert into Turma values(1, 'Banco de Dados', 0,0,0,1);
insert into Turma values(2, 'Aplicações com Interfaces Ricas', 0,0,0,1);

insert into Turma values(3, 'Programação Orientada a Objetos', 0,0,0,2);
insert into Turma values(4, 'Programação de Computadores', 0,0,0,2);
insert into Turma values(5, 'Programação de Banco de Dados', 0,0,0,2);
insert into Turma values(6, 'Administração de Banco de Dados', 0,0,0,4);


insert into Aluno values(1, 'jonatas.melo@hotmail.com', 'Jônatas Melo', 0,0,0,'jonatas123');
insert into Aluno values(2, 'carlos@gmail.com', 'Carlos Massa', 0,0,0,'carlos12345');
insert into Aluno values(3, 'jorge@hotmail.com', 'Jorge Vidal', 0,0,0,'jorge1012');
insert into Aluno values(4, 'felix23@yahoo.com.br', 'José Félix', 0,0,0,'felix13');
insert into Aluno values(5, 'vitoraugusto@gmail.com', 'Vitor Augusto', 0,0,0,'vitoraugusto53');
insert into Aluno values(6, 'Mariliapera@gmail.com', 'Marília Pera', 0,0,0,'marilia12345');
insert into Aluno values(7, 'joaovictor@hotmail.com', 'João Victor', 0,0,0,'joaovictor101');
insert into Aluno values(8, 'adrian0@hotmail.com', 'Adriano Ferreira', 0,0,0,'carrocasa');
insert into Aluno values(9, 'paulocesar@gmail.com', 'Paulo César', 0,0,0,'paulaorncosta');
insert into Aluno values(10,'hiury51@hotmail.com', 'Hiury Joaquim', 0,0,0,'sqlpythonc');
insert into Aluno values(11, 'william@hotmail.com', 'William Gates', 0,0,0,'homewindows2575');
insert into Aluno values(12, 'fausto.silva@hotmail.com', 'Fausto Silva', 0,0,0,'domingao123');
insert into Aluno values(13, 'nelson@gmail.com', 'Nelson Tavares', 0, 0, 0, 'nelsontades2018', 'user.png'); 

select * from Aluno;

/*Alunos da turma de Banco de Dados*/
insert into AlunoTurma values(1, 1, 0, 0, 0);
insert into AlunoTurma values(1, 2, 0, 0, 0);
insert into AlunoTurma values(1, 3, 0, 0, 0);
insert into AlunoTurma values(1, 4, 0, 0, 0);
insert into AlunoTurma values(1, 5, 0, 0, 0);
insert into AlunoTurma values(1, 6, 0, 0, 0);
insert into AlunoTurma values(1, 7, 0, 0, 0);
insert into AlunoTurma values(1, 8, 0, 0, 0);
insert into AlunoTurma values(1, 9, 0, 0, 0);
insert into AlunoTurma values(1, 10, 0, 0, 0);
insert into AlunoTurma values(1, 11, 0, 0, 0);
insert into AlunoTurma values(1, 12, 0, 0, 0);
insert into AlunoTurma values(3, 12, 0, 0, 0);
insert into AlunoTurma values(4, 12, 0, 0, 0);
insert into AlunoTurma values(5, 12, 0, 0, 0);
insert into AlunoTurma values(6, 12, 0, 0, 0);


insert into Questionario values(1, 'DDL', 10, 10, 1);
insert into Questionario values(2, 'DML', 15, 15, 1);
insert into Questionario values(3, 'DQL', 30, 30, 1);
insert into Questionario values(4, 'Normalização', 5, 5, 1);
insert into Questionario values(5, 'Herança', 12, 12, 3);
insert into Questionario values(6, 'Exception', 8, 8, 3);

update Questionario set pontMax = 15 where idQuest = 2;

insert into QuestAluno values(1, 1, 8, 10);
insert into QuestAluno values(1, 2, 7, 10);
insert into QuestAluno values(1, 3, 5, 5);
insert into QuestAluno values(1, 4, 8, 10);
insert into QuestAluno values(1, 5, 6, 8);
insert into QuestAluno values(1, 6, 7, 7);
insert into QuestAluno values(1, 7, 10, 10);
insert into QuestAluno values(1, 8, 7, 9);
insert into QuestAluno values(1, 9, 5, 10);

insert into QuestAluno values(2, 1, 5, 15);
insert into QuestAluno values(2, 2, 10, 15);
insert into QuestAluno values(2, 3, 15, 15);
insert into QuestAluno values(2, 4, 8, 15);
insert into QuestAluno values(2, 5, 6, 10);

insert into QuestAluno values(3, 4, 8, 30);
insert into QuestAluno values(3, 5, 6, 8);
insert into QuestAluno values(3, 6, 7, 30);
insert into QuestAluno values(3, 7, 10, 20);
insert into QuestAluno values(3, 8, 17, 25);
insert into QuestAluno values(3, 9, 15, 18);

insert into QuestAluno values(4, 8, 4, 5);
insert into QuestAluno values(4, 9, 1, 5);
insert into QuestAluno values(4, 10, 0, 5);
insert into QuestAluno values(4, 11, 3, 5);
insert into QuestAluno values(4, 12, 4, 5);

insert into QuestAluno values(5, 12, 7, 8);
insert into QuestAluno values(6, 12, 5, 5);


select nomeTurma, mediaTurma, modaTurma, rendTurma, nomeAluno, sum(pontuacao) from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma) JOIN Aluno on (AlunoTurma.codAluno = Aluno.idAluno) JOIN QuestAluno on (Aluno.idAluno = QuestAluno.codAluno) JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) group by idTurma, idAluno;

/*Calcula a média da pontuação por Aluno*/
select nomeAluno, (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) group by idAluno;

/*Atualiza a média de pontuação por aluno*/
update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 1 group by idAluno) where idAluno = 1;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 2 group by idAluno) where idAluno = 2;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 3 group by idAluno) where idAluno = 3;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 4 group by idAluno) where idAluno = 4;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 5 group by idAluno) where idAluno = 5;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 6 group by idAluno) where idAluno = 6;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 7 group by idAluno) where idAluno = 7;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 8 group by idAluno) where idAluno = 8;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 9 group by idAluno) where idAluno = 9;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 10 group by idAluno) where idAluno = 10;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 11 group by idAluno) where idAluno = 11;

update Aluno set mediaAluno = (select (sum(pontuacao)*pontMax)/sum(pontMax) as MédiaPontuacaopAluno from QuestAluno INNER JOIN Aluno on
(Aluno.idAluno = QuestAluno.codAluno) INNER JOIN Questionario on (QuestAluno.codQuest = Questionario.idQuest) where idAluno = 12 group by idAluno) where idAluno = 12;



/*Calculando média do aluno por turma*/
select nomeAluno, ((sum(pontuacao)*pontMax)/sum(pontMax)) as media, nomeTurma as Qtde from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
group by idAluno;

/*Alterando as tabelas com o cálculo da média acima*/
update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 1 group by idAluno) where codAluno = 1;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 2 group by idAluno) where codAluno = 2;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 3 group by idAluno) where codAluno = 3;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 4 group by idAluno) where codAluno = 4;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 5 group by idAluno) where codAluno = 5;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 6 group by idAluno) where codAluno = 6;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 7 group by idAluno) where codAluno = 7;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 8 group by idAluno) where codAluno = 8;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 9 group by idAluno) where codAluno = 9;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 10 group by idAluno) where codAluno = 10;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 11 group by idAluno) where codAluno = 11;

update AlunoTurma set mediaAlunoT = (select ((sum(pontuacao)*pontMax)/sum(pontMax)) as media from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)
JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) JOIN QuestAluno on (QuestAluno.codAluno = Aluno.idAluno) JOIN Questionario on (Turma.idTurma = Questionario.codTurma)
where idAluno = 12 group by idAluno) where codAluno = 12;

/*Calcula a média da pontuação para a turma*/
select nomeTurma, sum(mediaAluno)/count(idAluno) as somaMedias from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma) JOIN Aluno on (AlunoTurma.codAluno = Aluno.idAluno) group by idTurma;

update Turma set mediaTurma = 7.333333 where nomeTurma ='Banco de Dados';
update Turma set mediaTurma = 4 where nomeTurma = 'Programação Orientada a Objetos';


alter table Professor add column imagem varchar(30);
alter table Aluno add column imagem varchar(30);

select * from Aluno;

update Professor set imagem = 'barao.jpg' where idProf = 1;
update Professor set imagem = 'placido.jpg' where idProf = 2;
update Professor set imagem = 'jorgiano.jpg' where idProf = 3;
update Professor set imagem = 'user.png' where idProf = 4;

update Aluno set imagem = 'ratinho.jpg' where idAluno = 2;
update Aluno set imagem = 'faustao.jpg' where idAluno = 12;
update Aluno set imagem = 'billgates.jpg' where idAluno = 11;
update Aluno set imagem = 'user.png' where idAluno not in (2,12, 11);


/*1.A Gorgiano Vidal*/
/*1.B Barão*/
/*0.A.A Nelson Tavares*/

