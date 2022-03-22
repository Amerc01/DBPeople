DROP DATABASE IF EXISTS People;
CREATE DATABASE People;
USE people;

CREATE TABLE PeopleDatas(
	name VARCHAR(20),
	surname VARCHAR(20),
	email VARCHAR(20),
	cf CHAR(16),
	username VARCHAR(40),
	gender VARCHAR(20),
	
	PRIMARY KEY (username)
);

CREATE TABLE Credentials(
	username VARCHAR(40),
	hashed_pw CHAR(64),
	
	PRIMARY KEY (username),
	
	FOREIGN KEY (username)
	REFERENCES PeopleDatas(username)
);

