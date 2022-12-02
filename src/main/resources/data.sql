---ROLES
INSERT INTO role (role_id, name, description)
VALUES ('d45bb1c6-354f-4052-9381-009679b8f289', 'ADMIN', 'Offers support to the application by creating and managing items, orders and users');
INSERT INTO role (role_id, name, description)
VALUES ('d45bb1c6-354f-4052-9381-009679b8f290', 'user', 'Uses the services provided by the application, its allowed to navigate thru the application and creating and handle its orders');

---PERMISSIONS
INSERT INTO permission (permission_id, uri, method)
VALUES ('d45bb1c6-354f-4052-9381-009679b8f291', '/users', 'POST');

--ADD PERMISSIONS TO ROLES
INSERT INTO role_permission (role_id, permission_id)
VALUES('d45bb1c6-354f-4052-9381-009679b8f289', 'd45bb1c6-354f-4052-9381-009679b8f291');

INSERT INTO role_permission (role_id, permission_id)
VALUES('d45bb1c6-354f-4052-9381-009679b8f290', 'd45bb1c6-354f-4052-9381-009679b8f291');

--BASE ADMIN USER
INSERT INTO users (user_id, email, password, address, phone, role_id)
VALUES('d45bb1c6-354f-4052-9381-009679b8f292','gustavo@icesi.edu.co','Gustavo.1','Cra 94a','+573215515680', 'd45bb1c6-354f-4052-9381-009679b8f289');

--BASE CLIENT USER
INSERT INTO users (user_id, email, password, address, phone, role_id)
VALUES('d45bb1c6-354f-4052-9381-009679b8f293','jose@icesi.edu.co','Jose.1','Calle 18','+573001234455', 'd45bb1c6-354f-4052-9381-009679b8f290');