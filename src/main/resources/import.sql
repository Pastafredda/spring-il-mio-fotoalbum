--fotografie
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(1, 'Descrizione bella di foto 1', 'Vulcano', 'https://www.nationalgeographic.it/upload/ngi-image/img-13098-vulcano.png?w=710&h=474', 0);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(2, 'Descrizione bella di foto 2', 'Pappagallo', 'https://www.nationalgeographic.it/upload/ngi-hero/hero-13089-Hero_100.jpg?w=1600&h=900', 1);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(3, 'Descrizione bella di foto 3', 'Iguana', 'https://www.nationalgeographic.it/upload/ngi-image/img-13091-camaleonte.png?w=710&h=474', 1);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(4, 'Descrizione bella di foto 4', 'Balene', 'https://www.nationalgeographic.it/upload/ngi-image/img-13093-balena.png?w=710&h=474', 1);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(5, 'Descrizione bella di foto 5', 'Barca', 'https://www.nationalgeographic.it/upload/ngi-image/img-13095-acqua.png?w=710&h=474', 1);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(6, 'Descrizione bella di foto 6', 'Scogli', 'https://picsum.photos/id/14/2500/1667', 1);
INSERT INTO fotoalbum_db.fotografie(id, descrizione, titolo, url, visibile)VALUES(7, 'Descrizione bella di foto 7', 'Fiori', 'https://as2.ftcdn.net/v2/jpg/04/88/71/05/1000_F_488710566_04tsm0UWBwepU3xBEdzOwvgI7wrBsgpN.jpg', 1);

--categorie
INSERT INTO fotoalbum_db.categorie(id, nome)VALUES(1, 'naturalistica');
INSERT INTO fotoalbum_db.categorie(id, nome)VALUES(2, 'documentaria');
INSERT INTO fotoalbum_db.categorie(id, nome)VALUES(3, 'viaggio');
INSERT INTO fotoalbum_db.categorie(id, nome)VALUES(4, 'paesaggistica');
INSERT INTO fotoalbum_db.categorie(id, nome)VALUES(5, 'sportiva');


--ruoli security
INSERT INTO fotoalbum_db.roles(id, name)VALUES(1, 'ADMIN');
INSERT INTO fotoalbum_db.roles(id, name)VALUES(2, 'USER');

INSERT INTO fotoalbum_db.`user`(email, first_name, last_name, password)VALUES('matteo@email.com', 'matteo', 'giallo', '{noop}matteo123');
INSERT INTO fotoalbum_db.`user`(email, first_name, last_name, password)VALUES('marco@email.com', 'marco', 'verdi', '{noop}marco123');


INSERT INTO fotoalbum_db.user_roles(user_id, roles_id)VALUES(1, 1);
INSERT INTO fotoalbum_db.user_roles(user_id, roles_id)VALUES(1, 2);
INSERT INTO fotoalbum_db.user_roles(user_id, roles_id)VALUES(2, 2);