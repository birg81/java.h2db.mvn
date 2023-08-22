-- DROP SCHEMA IF EXISTS PeopleDB;
CREATE SCHEMA IF NOT EXISTS PeopleDB;
-- USE PeopleDB;

-- DROP TABLE IF EXISTS Person;
CREATE TABLE IF NOT EXISTS Person(
	id			INTEGER		PRIMARY KEY		AUTO_INCREMENT,
	firstname	VARCHAR(64)	NOT NULL,
	lastname	VARCHAR(64)	NOT NULL,
	UNIQUE(firstname, lastname),
	age			INTEGER,
	CHECK(age > 0)
);
	
INSERT INTO Person(firstname, lastname, age) VALUES
	('Philip',	'Fry',	25),
	('Turanga',	'Leela',	30),
	('Bender',	'Rodriguez',	4),
	('Hubert',	'Farnsworth',	180),
	('Amy',	'Wong',	25),
	('Hermes',	'Conrad',	42),
	('John',	'Zoidberg',	63),
	('Zapp',	'Brannigan',	42),
	('Kif',	'Kroker',	35),
	('Scruffy',	'Scruffington',	38),
	('Nibbler',	'Lord',	700),
	('Homer',	'Simpson',	39),
	('Marge',	'Simpson',	36),
	('Bart',	'Simpson',	10),
	('Lisa',	'Simpson',	8),
	('Maggie',	'Simpson',	1),
	('Stan',	'Smith',	42),
	('Francine',	'Smith',	40),
	('Steve',	'Smith',	15),
	('Roger',	'Smith',	1600),
	('Peter',	'Griffin',	42),
	('Lois',	'Griffin',	40),
	('Meg',	'Griffin',	17),
	('Chris',	'Griffin',	13),
	('Stewie',	'Griffin',	1),
	('Tiabienie',	'Bean',	19),
	('Elfo',	'',	20),
	('Luci',	'',	100);

SELECT * FROM Person ORDER BY firstname ASC LIMIT 15;