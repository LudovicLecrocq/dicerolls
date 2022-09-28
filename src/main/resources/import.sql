INSERT INTO roles (label) VALUES ("ROLE_USER")
INSERT INTO roles (label) VALUES ("ROLE_MJ")
INSERT INTO users (email, first_name, last_name, login, password) VALUES ("user@user", "first", "last", "login", "$2a$10$2bRRHTn8uiDZkm61INmv2uw.LPooGWAzJal3n2OLc/fORsY7j9Z8a")
INSERT INTO users (email, first_name, last_name, login, password) VALUES ("admin@admin", "first", "last", "login", "$2a$10$2bRRHTn8uiDZkm61INmv2uw.LPooGWAzJal3n2OLc/fORsY7j9Z8a")
INSERT INTO users_roles (user_id, role_id) VALUES (1,1)
INSERT INTO users_roles (user_id, role_id) VALUES (2,2)
INSERT INTO race (label, info, str_Bon, dex_Bon, con_Bon, int_Bon, wis_Bon, cha_Bon) VALUES ("Nain_des_Montagnes", "info Nain", 2,0,2,0,0,0)
INSERT INTO race (label, info, str_Bon, dex_Bon, con_Bon, int_Bon, wis_Bon, cha_Bon) VALUES ("Haut_Elfe", "info Elfe",0,2,0,1,0,0)
INSERT INTO race (label, info, str_Bon, dex_Bon, con_Bon, int_Bon, wis_Bon, cha_Bon) VALUES ("Humain", "info Humain",1,1,1,1,1,1)
INSERT INTO race (label, info, str_Bon, dex_Bon, con_Bon, int_Bon, wis_Bon, cha_Bon) VALUES ("Orc", "info Orc", 2,0,1,0,0,0)
INSERT INTO weapon (atq_value, w_name) VALUES (4,"dagger")
INSERT INTO weapon (atq_value, w_name) VALUES (8,"greatclub")
INSERT INTO weapon (atq_value, w_name) VALUES (12,"lance")
INSERT INTO weapon (atq_value, w_name) VALUES (8,"rapier")
INSERT INTO armour (def_value, a_name) VALUES (11,"leather")
INSERT INTO armour (def_value, a_name) VALUES (16,"chain mail")
INSERT INTO armour (def_value, a_name) VALUES (14,"scale mail")
INSERT INTO enemy (e_name, ehp) VALUES ("Gobelin",7)
INSERT INTO enemy (e_name, ehp) VALUES ("Troll",84)
INSERT INTO enemy (e_name, ehp) VALUES ("Red Dragon",256)
