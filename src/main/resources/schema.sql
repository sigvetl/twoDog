CREATE TABLE IF NOT EXISTS USERS (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(20),
  salt VARCHAR,
  password VARCHAR,
  firstname VARCHAR(20),
  lastname VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS BEER (
  beerid INT PRIMARY KEY auto_increment,
  name VARCHAR(40) NOT NULL,
  type VARCHAR(20),
  ibu INT,
  recipeLink VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS BATCH (
  batchid INT PRIMARY KEY auto_increment,
  volume FLOAT,
  beerid INT REFERENCES BEER(beerid),
  og FLOAT,
  fg FLOAT,
  abv FLOAT,
  brewdate DATE,
  --tapdate DATE,
  --finishdate DATE,
  userid INT REFERENCES USERS(userid)
);
