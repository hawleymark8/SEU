#Creates tables for Band Bucks
CREATE TABLE user
(
email varchar(75) NOT NULL ,
fname varchar(15) NOT NULL ,
lname varchar(15) NOT NULL ,
password varchar(40) NOT NULL ,
PRIMARY KEY (email)
) ENGINE=InnoDB;

CREATE TABLE band
(
bandID int NOT NULL AUTO_INCREMENT ,
password varchar(40) NOT NULL ,
bandName varchar(75) NOT NULL ,
bandEmail varchar(75) NOT NULL ,
PRIMARY KEY (bandID)
)

CREATE TABLE user_band
(
userEmail varchar(75) NOT NULL ,
bandID int NOT NULL ,
PRIMARY KEY (userEmail, bandID) ,
CONSTRAINT userEmail_FK FOREIGN KEY (userEmail) REFERENCES user(email),
CONSTRAINT bandID_FK FOREIGN KEY (bandID) REFERENCES band(bandID)
)

CREATE TABLE equipment
(
entryNum int NOT NULL AUTO_INCREMENT ,
bandID int ,
entry_TimeStamp timestamp ,
entry_Initials varchar(3) NOT NULL,

)