create database locadora;

use locadora;

create table filmes (
	id int auto_increment,
    nome varchar(50) not null,
    descricao varchar(200),
    ano year,
    primary key(id)
);

insert into filmes
(nome, descricao, ano)
values
('Psicopata Americano',
'O belo jovem profissional Patrick Bateman tem uma segunda vida como um horrível assassino em série durante a noite.',
2000);

insert into filmes
(nome, descricao, ano)
values
('Coringa',
'Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô.',
2019);

insert into filmes
(nome, descricao, ano)
values
('Em Ritmo de Fuga',
'O talentoso motorista de fuga Baby confia nas batidas de sua própria trilha sonora para ser o melhor que existe.',
2017);

insert into filmes
(nome, descricao, ano)
values
('Clube da Luta',
'Um homem deprimido que sofre de insônia conhece um estranho vendedor chamado Tyler Durden e se vê morando em uma casa suja depois que seu perfeito apartamento é destruído.',
1999);

insert into filmes
(nome, descricao, ano)
values
('Laranja Mecânica',
'O jovem Alex passa as noites com uma gangue de amigos briguentos. Depois que é preso, se submete a uma técnica de modificação de comportamento para poder ganhar sua liberdade.',
1972);

insert into filmes
(nome, descricao, ano)
values
('O Lobo de Wall Street',
'Jordan Belfort é um ambicioso corretor da bolsa de valores que cria um verdadeiro império, enriquecendo de forma rápida, porém ilegal.',
2014);

insert into filmes
(nome, descricao, ano)
values
('Batman: O Cavaleiro das Trevas',
'Com a ajuda de Jim Gordon e Harvey Dent, Batman tem mantido a ordem na cidade de Gotham.',
2008);

insert into filmes
(nome, descricao, ano)
values
('V de Vingança',
'Após uma guerra mundial, a Inglaterra é ocupada por um governo fascista e vive sob um regime totalitário.',
2005);

insert into filmes
(nome, descricao, ano)
values
('Bastardos Inglórios',
'Durante a Segunda Guerra Mundial, na França, um grupo de judeus americanos conhecidos como Bastardos espalha o terror entre o terceiro Reich.',
2009);

insert into filmes
(nome, descricao, ano)
values
('Pulp Fiction: Tempo de Violência',
'Assassino que trabalha para a máfia se apaixona pela esposa de seu chefe quando é convidado a acompanhá-la.',
1994);

insert into filmes
(nome, descricao, ano)
values
('The Batman',
'Após dois anos espreitando as ruas como Batman, Bruce Wayne se encontra nas profundezas mais sombrias de Gotham City.',
2022);

insert into filmes
(nome, descricao, ano)
values
('Whiplash: Em Busca da Perfeição',
'Andrew sonha em ser o melhor baterista de sua geração. Ele chama a atenção do impiedoso mestre do jazz Terence Fletcher.',
2015);

insert into filmes
(nome, descricao, ano)
values
('Onde os Fracos Não Têm Vez',
'Enquanto caçava, Llewelyn Moss encontrou vestígios de uma venda de drogas. Apesar de saber que não deve, ele não resiste e leva o dinheiro encontrado com ele.',
2007);

insert into filmes
(nome, descricao, ano)
values
('Donnie Darko',
'Donnie é um jovem excêntrico que despreza a grande maioria de seus colegas de escola. Ele tem visões, em especial de Frank, um coelho gigante.',
2001);

insert into filmes
(nome, descricao, ano)
values
('Interestelar',
'As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial.',
2014);

insert into filmes
(nome, descricao, ano)
values
('Ilha do Medo',
'Nos anos 1950, a fuga de uma assassina leva o detetive Teddy Daniels e seu parceiro a investigarem o seu desaparecimento de um quarto trancado em um hospital psiquiátrico.',
2010);

insert into filmes
(nome, descricao, ano)
values
('Django Livre',
'No sul dos Estados Unidos, o ex-escravo Django faz uma aliança inesperada com o caçador de recompensas Schultz para caçar os criminosos mais procurados do país.',
2012);

insert into filmes
(nome, descricao, ano)
values
('1917',
'Na Primeira Guerra Mundial, dois soldados britânicos recebem ordens aparentemente impossíveis de cumprir.',
2019);

insert into filmes
(nome, descricao, ano)
values
('O Iluminado',
'Jack Torrance se torna caseiro de inverno do isolado Hotel Overlook, nas montanhas do Colorado, na esperança de curar seu bloqueio de escritor.',
1980);

insert into filmes
(nome, descricao, ano)
values
('Até o Último Homem',
'Acompanhe a história de Desmond T. Doss, um médico do exército americano que, durante a Segunda Guerra Mundial.',
2016);