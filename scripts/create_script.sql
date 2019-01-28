drop table AlunoTurma;
drop table Aluno;
drop table Professor;
drop table Turma;

create table Professor(
    idProf integer not null primary key,
    email varchar(30) not null,
    nomeProf varchar(50) not null,
    senha varchar(20) not null
);

create table Aluno(
    idAluno integer not null primary key,
    email varchar(30) not null,
    nomeAluno varchar(50) not null,
    mediaAluno double not null,
    modaAluno double not null,
    rendAluno double not null,
    senha varchar(20) not null
);

create table AlunoTurma(
    codTurma integer not null,
    codAluno integer not null,
    mediaAlunoT double not null,
    modaAlunoT double not null,
    rendAlunoT double not null,
    foreign key (codTurma) references Turma(idTurma),
    foreign key (codAluno) references Aluno(idAluno)
);

create table Turma(
    idTurma integer not null primary key,
    nomeTurma varchar(50) not null,
    mediaTurma double not null,
    modaTurma double not null,
    rendTurma double not null,
    codProf integer not null,
    foreign key (codProf) references Professor(idProf)
);

create table Questionario(
    idQuest integer not null primary key,
    nomeQuest varchar(50) not null,
    qtdeQuest integer not null,
    pontMax integer not null,
    codTurma integer not null,
    foreign key (codTurma) references Turma(idTurma)
);

create table QuestAluno(
    codQuest integer not null,
    codAluno integer not null,
    pontuacao integer not null,
    questResp integer not null,
    foreign key (codQuest) references Questionario(idQuest),
    foreign key (codAluno) references Aluno(idAluno)
);