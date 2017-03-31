INSERT INTO EMP VALUES ('32662669R', 'Manuel Vicente Garcia Rodriguez', 175.0);

UPDATE EMP SET alturaCm = (SELECT alturaCm FROM EMP WHERE dni = '32662669r') + 1.0 WHERE dni = '32662669R';

