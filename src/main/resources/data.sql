---ROLES (e)
INSERT INTO role (role_id, name, description)
VALUES ('eeeeeeee-354f-4052-9381-000000000000', 'ADMIN', 'Offers support to the application by creating and managing items, orders and users');
INSERT INTO role (role_id, name, description)
VALUES ('eeeeeeee-354f-4052-9381-111111111111', 'user', 'Uses the services provided by the application, its allowed to navigate thru the application and creating and handle its orders');

---PERMISSIONS (f)
INSERT INTO permission (permission_id, uri, method)
VALUES ('ffffffff-1989-413a-ab52-9bec7a049e33', '/users', 'POST');

--ADD PERMISSIONS TO ROLES
INSERT INTO role_permission (role_id, permission_id)
VALUES('eeeeeeee-354f-4052-9381-000000000000', 'ffffffff-1989-413a-ab52-9bec7a049e33');

INSERT INTO role_permission (role_id, permission_id)
VALUES('eeeeeeee-354f-4052-9381-111111111111', 'ffffffff-1989-413a-ab52-9bec7a049e33');

--BASE ADMIN USER (a)
INSERT INTO users (user_id, email, password, address, phone, role_id)
VALUES('aaaaaaaa-354f-4052-9381-009679b8f200','gustavo@icesi.edu.co','Gustavo.1','Cra 94a','+573215515680', 'eeeeeeee-354f-4052-9381-000000000000');

--BASE CLIENT USER (a)
INSERT INTO users (user_id, email, password, address, phone, role_id)
VALUES('aaaaaaaa-354f-4052-9381-009679b8f211','jose@icesi.edu.co','Jose.1','Calle 18','+573001234455', 'eeeeeeee-354f-4052-9381-111111111111');