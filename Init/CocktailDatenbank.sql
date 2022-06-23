DROP DATABASE IF EXISTS cocktail;

CREATE DATABASE cocktail DEFAULT CHARACTER SET UTF8MB4 COLLATE UTF8MB4_GENERAL_CI;
USE cocktail;



-- Users

CREATE TABLE Users
(
pk_ID SMALLINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR (30) NOT NULL,
`password` VARCHAR (120) NOT NULL,	
`admin` BOOLEAN NOT NULL,
editor BOOLEAN NOT NULL,
`locked` BOOLEAN NOT NULL,
registered BOOLEAN NOT NULL,
birthdate DATE 
)ENGINE = INNODB;


-- Cocktails
CREATE TABLE Cocktails
(
pk_ID SMALLINT AUTO_INCREMENT NOT NULL,
`name` VARCHAR (50) NOT NULL,
`description` VARCHAR (3000),
-- fk_pk_User_ID Interger SMALLINT NOT NULL,
PRIMARY KEY (pk_ID )
-- FOREIGN KEY (fk_pk_User_ID) REFERENCES Users(pk_ID)
)ENGINE = INNODB;


-- Ingredients
CREATE TABLE Ingredients
(
pk_ID SMALLINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
`name` VARCHAR (30) NOT NULL,
alcohol FLOAT NOT NULL
)ENGINE = INNODB;


-- Cocktails_Ingredients
CREATE TABLE Cocktails_Ingredients
(
pk_fk_Cocktail_ID SMALLINT NOT NULL,
pk_fk_Ingredient_ID SMALLINT NOT NULL,
amount SMALLINT NOT NULL,
unit VARCHAR(15) NOT NULL,
PRIMARY KEY (pk_fk_Cocktail_ID, pk_fk_Ingredient_ID),
FOREIGN KEY (pk_fk_Cocktail_ID) REFERENCES Cocktails (pk_ID)
	ON UPDATE cascade
	ON DELETE cascade,
FOREIGN KEY (pk_fk_Ingredient_ID) REFERENCES Ingredients (pk_ID)
	ON UPDATE cascade
	ON DELETE CASCADE
)ENGINE = INNODB;



INSERT INTO Users (name, `password`, admin, editor, locked, registered, birthdate) 
    VALUES ('root', 'root', 1, 1, 0, 1, '2002-06-23');