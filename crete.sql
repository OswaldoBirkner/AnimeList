-- create.sql file

-- Create a table called "animeList"
CREATE TABLE animeList (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    studio VARCHAR(255) NOT NULL,
    releaseDate DATE NOT NULL,
    createdBy VARCHAR(255),
    createdDate TIMESTAMP DEFAULT NOW(),
    updatedBy VARCHAR(255),
    updatedDate TIMESTAMP
);

-- Create an index on the "name" column to improve query performance
CREATE INDEX idx_animeList_name ON animeList (name);

-- Create an index on the "genre" column to improve query performance
CREATE INDEX idx_animeList_genre ON animeList (genre);

-- Create an index on the "release_date" column to improve query performance
CREATE INDEX idx_animeList_release_date ON animeList (release_date);

-- Naruto
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Naruto', 'Ação, Aventura, Shounen', 'Naruto Uzumaki, um jovem ninja com o sonho de se tornar o Hokage, líder de sua vila, enfrenta desafios e inimigos poderosos enquanto busca seu objetivo.', 'Pierrot', '2002-2007');

-- Dragon Ball Z
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Dragon Ball Z', 'Ação, Aventura, Shounen', 'Goku e seus amigos protegem a Terra de ameaças cósmicas enquanto enfrentam adversários poderosos em batalhas épicas.', 'Toei Animation', '1989-1996');

-- One Piece
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('One Piece', 'Ação, Aventura, Shounen', 'Monkey D. Luffy e sua tripulação pirata buscam o tesouro lendário conhecido como "One Piece" enquanto enfrentam perigos e inimigos.', 'Toei Animation', '1999-presente');

-- Attack on Titan (Shingeki no Kyojin)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Attack on Titan (Shingeki no Kyojin)', 'Ação, Drama, Fantasia', 'Humanidade luta contra titãs gigantes devoradores de humanos em uma batalha desesperada pela sobrevivência.', 'Wit Studio (temporadas 1-3) / MAPPA (temporada 4)', '2013-2021');

-- Death Note
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Death Note', 'Mistério, Suspense, Sobrenatural', 'Um estudante encontra um caderno capaz de matar qualquer pessoa cujo nome seja escrito nele e decide usá-lo para livrar o mundo de criminosos.', 'Madhouse', '2006-2007');

-- Fullmetal Alchemist: Brotherhood
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Fullmetal Alchemist: Brotherhood', 'Ação, Aventura, Fantasia', 'Dois irmãos alquimistas buscam a Pedra Filosofal para recuperar seus corpos após um ritual de alquimia dar errado.', 'Bones', '2009-2010');

-- My Hero Academia (Boku no Hero Academia)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('My Hero Academia (Boku no Hero Academia)', 'Ação, Superpoderes, Escolar', 'Em um mundo onde superpoderes são comuns, um jovem sem poderes luta para se tornar um herói.', 'Bones', '2016-presente');

-- Bleach
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Bleach', 'Ação, Aventura, Sobrenatural', 'Um adolescente ganha poderes de um Ceifador de Almas e é encarregado de proteger o mundo dos espíritos malignos.', 'Pierrot', '2004-2012');

-- Neon Genesis Evangelion
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Neon Genesis Evangelion', 'Mecha, Psicológico, Apocalíptico', 'Pilotos de robôs enfrentam ameaças misteriosas enquanto exploram questões profundas sobre a mente humana.', 'Gainax', '1995-1996');

-- Sword Art Online
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Sword Art Online', 'Ação, Aventura, Romance', 'Jogadores presos em um jogo de realidade virtual devem vencer para escapar, enfrentando desafios mortais.', 'A-1 Pictures', '2012-2022');

-- Cowboy Bebop
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Cowboy Bebop', 'Ação, Sci-Fi, Noir', 'Caçadores de recompensas viajam pelo espaço em busca de criminosos, mistérios e seu passado.', 'Sunrise', '1998-1999');

-- Hunter x Hunter
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Hunter x Hunter', 'Ação, Aventura, Shounen', 'Um jovem se torna um Caçador para encontrar seu pai e enfrenta desafios perigosos em uma terra cheia de mistérios.', 'Madhouse (2011)', '1999-2011 (original), 2011 (remake)');

-- One Punch Man
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('One Punch Man', 'Ação, Comédia, Superpoderes', 'Saitama, um herói extremamente poderoso, busca um desafio real em um mundo cheio de monstros e vilões.', 'Madhouse (Temporada 1) / J.C. Staff (Temporada 2)', '2015-2019');

-- Tokyo Ghoul
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Tokyo Ghoul', 'Ação, Horror, Sobrenatural', 'Kaneki, após se tornar um meio-ghoul, luta para sobreviver em um mundo onde humanos e ghouls estão em conflito.', 'Pierrot', '2014-2018');

-- Fairy Tail
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Fairy Tail', 'Ação, Aventura, Fantasia', 'Lucy se junta a um gremio de magos chamado Fairy Tail e embarca em aventuras mágicas com seus amigos.', 'A-1 Pictures / Bridge', '2009-2019');

-- Demon Slayer (Kimetsu no Yaiba)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Demon Slayer (Kimetsu no Yaiba)', 'Ação, Demônios, Sobrenatural', 'Tanjiro Kamado busca vingança contra demônios após sua família ser massacrada, enquanto luta para salvar sua irmã.', 'Ufotable', '2019-2021');

-- JoJo's Bizarre Adventure
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('JoJos Bizarre Adventure', 'Ação, Sobrenatural, Shounen', 'A saga da família Joestar e suas batalhas contra inimigos com poderes sobrenaturais.', 'David Production', '2012-presente');

-- Naruto Shippuden
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Naruto Shippuden', 'Ação, Aventura, Shounen', 'Continuação de "Naruto", onde Naruto enfrenta desafios ainda maiores em busca de seu sonho.', 'Pierrot', '2007-2017');

-- Code Geass
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Code Geass', 'Mecha, Drama, Psicológico', 'Lelouch Lamperouge lidera uma revolução contra um império usando um poder misterioso.', 'Sunrise', '2006-2008');

-- Steins: Gate
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Steins: Gate', 'Ficção Científica, Thriller, Viagem no Tempo', 'Um grupo de amigos descobre uma máquina do tempo e desencadeia uma série de eventos perturbadores.', 'White Fox', '2011');

-- Hunter x Hunter (2011)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Hunter x Hunter (2011)', 'Ação, Aventura, Shounen', 'Remake de "Hunter x Hunter" que segue a jornada de Gon em busca de seu pai.', 'Madhouse', '2011-2014');

-- Dragon Ball
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Dragon Ball', 'Ação, Aventura, Shounen', 'As aventuras de Goku desde sua infância até a idade adulta enquanto ele procura pelas esferas do dragão.', 'Toei Animation', '1986-1989');

-- Mob Psycho 100
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Mob Psycho 100', 'Ação, Comédia, Sobrenatural', 'Mob, um jovem com poderes psíquicos, lida com problemas sobrenaturais enquanto tenta levar uma vida normal.', 'Bones', '2016-2019');

-- Black Clover
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Black Clover', 'Ação, Magia, Shounen', 'Asta, um jovem sem poderes mágicos, busca se tornar o Feiticeiro Imperador em um mundo cheio de magia.', 'Pierrot', '2017-2021');

-- Fruits Basket
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Fruits Basket', 'Drama, Romance, Sobrenatural', 'Tohru Honda descobre que a família Sohma é amaldiçoada e pode se transformar em animais do zodíaco chinês.', 'TMS Entertainment', '2001 (original) / 2019-2021 (remake)');

-- Digimon Adventure
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Digimon Adventure', 'Ação, Aventura, Fantasia', 'Um grupo de crianças é transportado para um mundo digital e deve protegê-lo de ameaças.', 'Toei Animation', '1999-2000 (original) / 2020-2021 (remake)');

-- Haikyuu!!
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Haikyuu!!', 'Esporte, Comédia, Drama', 'Uma equipe de vôlei de escola secundária busca se tornar campeã nacional.', 'Production I.G', '2014-2020');

-- Inuyasha
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Inuyasha', 'Ação, Aventura, Fantasia', 'Kagome Higurashi viaja ao Japão feudal e se une a Inuyasha em uma busca por fragmentos de uma esfera mágica.', 'Sunrise', '2000-2004');

-- Kuroko no Basket (Kuroko's Basketball)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Kuroko no Basket (Kuroko\'s Basketball)', 'Esporte, Comédia, Drama', 'Kuroko, um jogador de basquete com habilidades especiais, se junta a uma equipe colegial talentosa.', 'Production I.G', '2012-2015');

-- Clannad
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Clannad', 'Drama, Romance, Slice of Life', 'Tomoya Okazaki lida com desafios pessoais e emocionais enquanto se relaciona com colegas de escola.', 'Kyoto Animation', '2007-2008');

-- Dragon Ball Super
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Dragon Ball Super', 'Ação, Aventura, Shounen', 'A história continua após "Dragon Ball Z", com Goku enfrentando novos desafios cósmicos.', 'Toei Animation', '2015-2018');

-- The Seven Deadly Sins (Nanatsu no Taizai)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('The Seven Deadly Sins (Nanatsu no Taizai)', 'Ação, Aventura, Fantasia', 'Um grupo de cavaleiros poderosos conhecidos como "Os Sete Pecados Capitais" protege o reino.', 'A-1 Pictures (Temporadas 1-2) / Studio Deen (Temporada 3)', '2014-2021');

-- Nausicaä of the Valley of the Wind (Studio Ghibli)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Nausicaä of the Valley of the Wind (Studio Ghibli)', 'Ação, Aventura, Fantasia', 'Nausicaä luta para proteger seu vale de uma floresta tóxica e conflitos humanos.', 'Studio Ghibli', '1984 (filme)');

-- Your Name (Kimi no Na wa) (Filme)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Your Name (Kimi no Na wa) (Filme)', 'Drama, Romance, Supernatural', 'Dois jovens trocam de corpo intermitentemente e tentam se encontrar no mundo real.', 'CoMix Wave Films', '2016 (filme)');

-- Attack on Titan Season 2+
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Attack on Titan Season 2+', 'Ação, Drama, Fantasia', 'Continuação da luta da humanidade contra os titãs.', 'Wit Studio (Temporada 2) / MAPPA (Temporada 3+)', '2017-presente');

-- Rurouni Kenshin (Samurai X)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Rurouni Kenshin (Samurai X)', 'Ação, Aventura, Histórico', 'Um ex-assassino busca redenção como um samurai errante no Japão do século XIX.', 'Gallop / Studio Deen', '1996-1998');

-- Soul Eater
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Soul Eater', 'Ação, Sobrenatural, Comédia', 'Estudantes de uma escola de armas combatem seres demoníacos e bruxas para evitar uma catástrofe.', 'Bones', '2008-2009');

-- Akira (Filme)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Akira (Filme)', 'Ação, Ficção Científica, Cyberpunk', 'Uma história cyberpunk ambientada em Tóquio após a Terceira Guerra Mundial.', 'Tokyo Movie Shinsha', '1988 (filme)');

-- The Promised Neverland (Yakusoku no Neverland)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('The Promised Neverland (Yakusoku no Neverland)', 'Mistério, Psicológico, Sobrenatural', 'Órfãos descobrem segredos sombrios sobre o orfanato em que vivem e buscam escapar.', 'CloverWorks', '2019-2021');

-- Gurren Lagann (Tengen Toppa Gurren Lagann)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Gurren Lagann (Tengen Toppa Gurren Lagann)', 'Mecha, Ação, Aventura', 'Simon e Kamina pilotam mechas para combater um governo opressor em um mundo subterrâneo.', 'Gainax', '2007');

-- No Game No Life
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('No Game No Life', 'Aventura, Comédia, Fantasia', 'Dois irmãos são transportados para um mundo onde tudo é decidido por jogos.', 'Madhouse', '2014');

-- Yu Yu Hakusho
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Yu Yu Hakusho', 'Ação, Sobrenatural, Comédia', 'Um adolescente ressuscita como um detetive espiritual e luta contra ameaças sobrenaturais.', 'Pierrot', '1992-1995');

-- Princess Mononoke (Studio Ghibli)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Princess Mononoke (Studio Ghibli)', 'Ação, Aventura, Fantasia', 'Um príncipe envolvido em uma luta entre deuses da floresta e humanos em busca de recursos.', 'Studio Ghibli', '1997 (filme)');

-- JoJo's Bizarre Adventure: Golden Wind
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('JoJo\'s Bizarre Adventure: Golden Wind', 'Ação, Sobrenatural, Shounen', 'A quinta parte da saga "JoJo\'s Bizarre Adventure", seguindo as aventuras de Giorno Giovanna.', 'David Production', '2018-2019');

-- Blue Exorcist (Ao no Exorcist)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Blue Exorcist (Ao no Exorcist)', 'Ação, Sobrenatural, Demônios', 'Rin Okumura, um jovem que descobre ser o filho de Satanás, luta para se tornar um exorcista.', 'A-1 Pictures', '2011');

-- Spirited Away (Studio Ghibli)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Spirited Away (Studio Ghibli)', 'Aventura, Fantasia, Drama', 'Chihiro se aventura em um mundo espiritual e deve resgatar seus pais de uma maldição.', 'Studio Ghibli', '2001 (filme)');

-- Great Teacher Onizuka (GTO)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Great Teacher Onizuka (GTO)', 'Comédia, Drama, Escolar', 'Um ex-delinquente se torna professor e usa métodos incomuns para educar seus alunos.', 'Pierrot', '1999-2000');

-- Parasyte (Kiseijuu: Sei no Kakuritsu)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Parasyte (Kiseijuu: Sei no Kakuritsu)', 'Ação, Horror, Psicológico', 'Alienígenas parasitas tomam controle de humanos, e Shinichi luta para sobreviver com um parásito em sua mão.', 'Madhouse', '2014-2015');

-- Re:Zero - Starting Life in Another World
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Re:Zero - Starting Life in Another World', 'Drama, Fantasia, Psicológico', 'Subaru Natsuki é transportado para outro mundo e revive após a morte, enfrentando desafios e mistérios.', 'White Fox', '2016-presente');

-- Dr. Stone
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Dr. Stone', 'Ação, Aventura, Ficção Científica', 'Após a humanidade ser petrificada, Senku busca reviver a civilização usando ciência.', 'TMS Entertainment', '2019-presente');

-- Made in Abyss
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Made in Abyss', 'Aventura, Drama, Fantasia', 'Riko e Reg exploram um abismo mortal em busca da mãe de Riko.', 'Kinema Citrus', '2017');

-- Vinland Saga
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Vinland Saga', 'Ação, Aventura, Histórico', 'Thorfinn busca vingança contra o assassino de seu pai em uma saga ambientada na era dos vikings.', 'Wit Studio', '2019');

-- Cowboy Bebop (Filme)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Cowboy Bebop (Filme)', 'Ação, Sci-Fi, Noir', 'A equipe Bebop persegue um hacker perigoso em Marte.', 'Sunrise', '2001 (filme)');

-- Spice and Wolf (Ookami to Koushinryou)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Spice and Wolf (Ookami to Koushinryou)', 'Aventura, Fantasia, Romance', 'O mercador Kraft Lawrence viaja com a deusa lobo Holo em busca de sua terra natal.', 'Imagin', '2008');

-- Tokyo Revengers
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Tokyo Revengers', 'Ação, Drama, Escolar', 'Takemichi Hanagaki viaja no tempo para salvar seu amor de infância e acabar com uma gangue criminosa.', 'Liden Films', '2021-presente');

-- One Piece (Filme)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('One Piece (Filme)', 'Ação, Aventura, Comédia', 'A tripulação do Chapéu de Palha embarca em aventuras em filmes especiais da série.', 'Toei Animation', 'Vários filmes lançados');

-- Neon Genesis Evangelion (Filme)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Neon Genesis Evangelion (Filme)', 'Mecha, Psicológico, Apocalíptico', 'Uma série de filmes recapitula e expande a história da série de TV.', 'Khara', 'Vários filmes lançados');

-- Detective Conan (Case Closed)
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Detective Conan (Case Closed)', 'Mistério, Policial, Suspense', 'Um detetive adolescente é transformado em uma criança e busca uma cura enquanto resolve casos.', 'TMS Entertainment', '1996-presente');

-- Violet Evergarden
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Violet Evergarden', 'Drama, Slice of Life, Romance', 'Uma ex-soldado busca seu propósito escrevendo cartas emocionais para outras pessoas.', 'Kyoto Animation', '2018');

-- Beastars
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Beastars', 'Drama, Psicológico, Romance', 'Em uma escola onde animais carnívoros e herbívoros convivem, Legoshi lida com conflitos interespécies.', 'Orange', '2019-2021');

-- Baccano!
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Baccano!', 'Ação, Sobrenatural, Histórico', 'A história entrelaça várias narrativas de personagens em um mundo de imortalidade e crime.', 'Brain\'s Base', '2007');

-- Akame ga Kill!
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Akame ga Kill!', 'Ação, Aventura, Fantasia', 'Um grupo de assassinos luta contra um governo corrupto em um mundo de fantasia.', 'White Fox', '2014');

-- Great Pretender
INSERT INTO anime_list (name, genre, description, studio, release_date)
VALUES ('Great Pretender', 'Comédia, Drama, Crime', 'Um grupo de golpistas se envolve em esquemas internacionais complexos.', 'Wit Studio', '2020');

