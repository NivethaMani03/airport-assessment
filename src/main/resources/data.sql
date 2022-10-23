CREATE TABLE COUNTRIES AS SELECT * FROM CSVREAD('classpath:static/countries.csv');
CREATE TABLE RUNWAYS AS SELECT * FROM CSVREAD('classpath:static/runways.csv');
CREATE TABLE AIRPORTS AS SELECT * FROM CSVREAD('classpath:static/airports.csv');