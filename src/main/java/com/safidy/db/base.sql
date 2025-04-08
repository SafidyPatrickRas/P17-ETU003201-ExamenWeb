CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    mdp VARCHAR(50),
    emailVARCHAR(50)
);

SELECT SUM(montant) AS montant FROM previsions WHERE libele = 'sakafo';

SELECT libele , SUM(montant) FROM previsions GROUP BY libele

SELECT previsions.libele AS libele ,  SUM(previsions.montant) - SUM(depenses.montant) AS previsions_restant FROM previsions LEFT JOIN depenses ON previsions.id = depenses.id_prevision GROUP by  previsions.libele;

CREATE TABLE previsions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libele VARCHAR(50),
    montant DOUBLE
);
CREATE TABLE depenses(
    id INT  PRIMARY KEY AUTO_INCREMENT ,
    id_prevision INT,
    montant DOUBLE
);

INSERT INTO depenses (id_prevision , montant) VALUES ( 1 , 123);
INSERT INTO previsions (libele , montant) VALUES ();