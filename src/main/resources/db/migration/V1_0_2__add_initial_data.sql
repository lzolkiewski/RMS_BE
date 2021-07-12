SET search_path TO rms;

INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 1, 4, 180, 18, 0, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 2, 4, 180, 18, 0, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 3, 4, 180, 18, 1, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 4, 4, 180, 18, 1, 'Pokój z oknem od strony południowej z łazienką i balkonem. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 5, 3, 170, 18, 1, 'Pokój z oknem od strony południowej z łazienką i balkonem. Jest on wyposażony w 3 łóżka jednoosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 6, 4, 180, 18, 1, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 7, 4, 180, 18, 2, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 8, 4, 180, 18, 2, 'Pokój z oknem od strony południowej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 9, 6, 230, 18, 2, 'Pokój z oknem od strony południowej z łazienką. Jest on wyposażony w 3 kanapy dwuosobowe, lodówkę, czajnik i telewizor');
INSERT INTO room(id, number, capacity, daily_cost, surface, floor, description) VALUES(NEXTVAL('room_seq'), 10, 4, 180, 18, 2, 'Pokój z oknem od strony północnej z łazienką. Jest on wyposażony w 2 kanapy dwuosobowe, lodówkę, czajnik i telewizor');

INSERT INTO room_status(id, name) VALUES(NEXTVAL('room_status_seq'), 'UNOCCUPIED');
INSERT INTO room_status(id, name) VALUES(NEXTVAL('room_status_seq'), 'RESERVED');
INSERT INTO room_status(id, name) VALUES(NEXTVAL('room_status_seq'), 'OCCUPIED');
INSERT INTO user_role(id, name) VALUES(NEXTVAL('user_role_seq'), 'ADMIN');
INSERT INTO user_role(id, name) VALUES(NEXTVAL('user_role_seq'), 'USER');

INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Jan', 'Kowalski', 'jan.kowalski@gmail.com', '111111111', (SELECT id FROM user_role WHERE name = 'USER'));
INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Luiza', 'Tomaszewska', 'LuizaTomaszewska@teleworm.us', '535296517', (SELECT id FROM user_role WHERE name = 'ADMIN'));
INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Zdzisława', 'Nowakowska', 'znowakowska@gmail.com', '886605061', (SELECT id FROM user_role WHERE name = 'USER'));
INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Marek', 'Ćma', 'cmarek@gmail.com', '612345773', (SELECT id FROM user_role WHERE name = 'USER'));
INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Tomasz', 'Problem', 'tomProb123@interia.com', '546745773', (SELECT id FROM user_role WHERE name = 'USER'));
INSERT INTO rms.user(id, first_name, last_name, email, phone, user_role_id) VALUES (NEXTVAL('user_seq'), 'Walentyna', 'Kwiatkowska', 'waletyna@gmail.com', '357456852', (SELECT id FROM user_role WHERE name = 'ADMIN'));

INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'jan.kowalski@gmail.com'), (SELECT id FROM room WHERE number = 1), '2021-07-24', '2021-07-31', (SELECT id FROM room_status WHERE name = 'OCCUPIED'));
INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'tomProb123@interia.com'), (SELECT id FROM room WHERE number = 4), '2021-08-12', '2021-08-26', (SELECT id FROM room_status WHERE name = 'RESERVED'));
INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'waletyna@gmail.com'), (SELECT id FROM room WHERE number = 5), '2021-09-14', '2021-09-28', (SELECT id FROM room_status WHERE name = 'OCCUPIED'));
INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'znowakowska@gmail.com'), (SELECT id FROM room WHERE number = 9), '2021-07-19', '2021-07-31', (SELECT id FROM room_status WHERE name = 'RESERVED'));
INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'LuizaTomaszewska@teleworm.us'), (SELECT id FROM room WHERE number = 10), '2021-07-18', '2021-07-31', (SELECT id FROM room_status WHERE name = 'OCCUPIED'));
INSERT INTO user_room(user_id, room_id, date_from, date_to, room_status_id) VALUES((SELECT id FROM rms.user WHERE email = 'cmarek@gmail.com'), (SELECT id FROM room WHERE number = 7), '2021-08-19', '2021-08-23', (SELECT id FROM room_status WHERE name = 'OCCUPIED'));
