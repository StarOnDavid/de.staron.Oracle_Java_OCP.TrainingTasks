DROP table animals;
DROP SEQUENCE sq_animals_id;

CREATE TABLE animals (
    id NUMBER(3) CONSTRAINT pk_animals_id PRIMARY KEY,
    name VARCHAR2(30),
    age NUMBER(2) NOT NULL
    );
    
CREATE SEQUENCE sq_animals_id;