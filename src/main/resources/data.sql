INSERT INTO Interest(description)
VALUES ('swimming');
INSERT INTO Interest(description)
VALUES ('climbing');
INSERT INTO Interest(description)
VALUES ('singing');
INSERT INTO Interest(description)
VALUES ('skiing');
INSERT INTO Interest(description)
VALUES ('running');

INSERT INTO Person(first_name, last_name, date_of_birth, sex)
VALUES ('Paul', 'Schöppl', '2003-09-14', 'MALE');
INSERT INTO Person(first_name, last_name, date_of_birth, sex)
VALUES ('Elias', 'Pils', '2003-06-24', 'MALE');

INSERT INTO PERSON_INTERESTS(person_id, interests_id)
VALUES (1, 1);
    INSERT INTO PERSON_INTERESTS(person_id, interests_id)
VALUES (1, 2);
INSERT INTO PERSON_INTERESTS(person_id, interests_id)
VALUES (1, 3);
