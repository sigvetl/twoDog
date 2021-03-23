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
  og FLOAT,
  fg FLOAT,
  abv FLOAT,
  ebc FLOAT,
  recipelink VARCHAR(100),
  pictureLink VARCHAR(100),
  userid INT,
  createdby VARCHAR(40),
  lastupdatedby VARCHAR(40),
  foreign key (userid) references USERS(userid)
);

CREATE TABLE IF NOT EXISTS BATCH (
  batchid INT PRIMARY KEY auto_increment,
  volume FLOAT,
  og FLOAT,
  fg FLOAT,
  abv FLOAT,
  brewdate DATE,
  tapdate DATE,
  --finishdate DATE,
  createdby VARCHAR(40),
  lastupdatedby VARCHAR(40),
  quality VARCHAR(10),
  comments VARCHAR(1000),
  userid INT not null,
  beerid INT not null,
  foreign key (userid) references USERS(userid),
  foreign key (beerid) references BEER(beerid)
);
