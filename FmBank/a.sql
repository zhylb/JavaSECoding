CREATE DATABASE test;

USE test;

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account`(
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(30) NOT NULL,
   `password` VARCHAR(40) NOT NULL,
   `stuid` BIGINT NOT NULL,
   `number` BIGINT NOT NULL,
   `sex` VARCHAR(2) NOT NULL,
   `birth` DATE NOT NULL,
   `balance` DOUBLE(10,2) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;


INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) 
		VALUES ( 1000000001,'刻晴','kq123',320190941290,18866668888,'F','2001-05-22',2000);
INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) 
		VALUES ( NULL,'迪卢克','dlk123',320190941291,18866667777,'M','2001-05-22',2000);
INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) 
		VALUES ( NULL,'琴','q123',320190941390,18866665555,'F','2001-08-30',2000);
INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) 
		VALUES ( NULL,'莫娜','mn123',320190941380,18822225555,'F','2001-12-30',2000);	
INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) 
		VALUES ( NULL,'七七','qq123',320190941360,18866661111,'F','2001-01-02',2000);	
SELECT * FROM account;

UPDATE TABLE account WHERE