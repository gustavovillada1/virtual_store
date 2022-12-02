---ROLES
INSERT INTO role (role_id, name, description)
VALUES ('d45bb1c6-354f-4052-9381-009679b8f289', 'ADMIN', 'Offers support to the application by creating and managing items, orders and users');
INSERT INTO role (role_id, name, description)
VALUES ('d45bb1c6-354f-4052-9381-009679b8f290', 'USER', 'Uses the services provided by the application, its allowed to navigate thru the application and creating and handle its orders');

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

--BASE ITEMS
INSERT INTO item (item_id, name, description, price, url)
VALUES('d45bb1c6-354f-4052-9381-009679b8f302', 'Ford Raptor 150', 'Modelo 2013. Color Gris. Automatica. 170.000 kms', 98000000,'https://http2.mlstatic.com/D_NQ_NP_958270-MCO50877015841_072022-O.webp');

INSERT INTO item (item_id, name, description, price, url)
VALUES('d45bb1c6-354f-4052-9381-009679b8f303', 'Volkswagen Golf Gti', 'Modelo 2015. Automatico. 101.760 kms. Papeles al dia y venta directa', 85000000, 'https://http2.mlstatic.com/D_NQ_NP_629748-MCO51841630851_102022-O.webp');

INSERT INTO item (item_id, name, description, price, url)
VALUES('d45bb1c6-354f-4052-9381-009679b8f304', 'Porsche 911 Carrera S', 'Modelo 2018. Automatico. 18.000 kms. Placa impar, terminada en 1', 650000000,'https://http2.mlstatic.com/D_NQ_NP_824530-MCO48437980977_122021-O.webp');

INSERT INTO item (item_id, name, description, price, url)
VALUES('d45bb1c6-354f-4052-9381-009679b8f305', 'Volkswagen Tiguan', 'Comfortline Modelo 2020. Automatica. 25.000 kms. Papeles al dia y perfecto estado.', 123000000,'https://http2.mlstatic.com/D_NQ_NP_907742-MCO52084333169_102022-O.webp');

INSERT INTO item (item_id, name, description, price, url)
VALUES('d45bb1c6-354f-4052-9381-009679b8f301', 'Toyota Prado TXL', 'Rines y llantas Mickey Thompson 35" Relaciones 4.88 Bumbpers Ultima generacion. LIFT 2". ', 340000000,'https://http2.mlstatic.com/D_NQ_NP_770780-MCO52539032838_112022-O.webp');