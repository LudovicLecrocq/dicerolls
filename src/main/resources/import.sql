INSERT INTO roles (label) VALUES ("ROLE_USER")
INSERT INTO roles (label) VALUES ("ROLE_ADMIN")
INSERT INTO users (email, first_name, last_name, login, password) VALUES ("user@user", "first", "last", "login", "$2a$10$2bRRHTn8uiDZkm61INmv2uw.LPooGWAzJal3n2OLc/fORsY7j9Z8a")
INSERT INTO users (email, first_name, last_name, login, password) VALUES ("admin@admin", "first", "last", "login", "$2a$10$2bRRHTn8uiDZkm61INmv2uw.LPooGWAzJal3n2OLc/fORsY7j9Z8a")
INSERT INTO users_roles (user_id, role_id) VALUES (1,1)
INSERT INTO users_roles (user_id, role_id) VALUES (2,2)
