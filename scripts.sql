====================================================================================================
INSERT INTO account(cost, id_guest) VALUES (?, ?)
UPDATE account SET cost=?, payment_date=?, id_guest=?, id_individual=?, id_legal_entity=? WHERE id=?
DELETE FROM account WHERE id = ?
SELECT * FROM account WHERE id = ?
SELECT * FROM account
----------------------------------------------------------------------------------------------------
UPDATE account SET payment_date=?, id_individual=?, id_legal_entity=? WHERE id=?
====================================================================================================
INSERT INTO guest(arrival_date, departure_date, additional_space, id_individual, id_hotel_room) VALUES (?, ?, ?, ?, ?)
UPDATE guest SET arrival_date=?, departure_date=?, additional_space=?, id_individual=?, id_hotel_room=? WHERE id=?
DELETE FROM guest WHERE id=?
SELECT * FROM guest WHERE id=?
SELECT * FROM guest
====================================================================================================
INSERT INTO hotel_room(rnumber, rclass, capacity, floor, id_price_list) VALUES (?, ?, ?, ?, ?)
UPDATE hotel_room SET rnumber=?, rclass=?, capacity=?, floor=?, id_price_list=? WHERE id=?
DELETE FROM hotel_room WHERE id=?
SELECT * FROM hotel_room WHERE id=?
SELECT * FROM hotel_room
====================================================================================================
INSERT INTO individual(name, sex, phone_number) VALUES (?, ?, ?)
UPDATE individual SET name=?, sex=?, phone_number=? WHERE id=?
DELETE FROM individual WHERE id=?
SELECT * FROM individual WHERE id=?
SELECT * FROM individual
====================================================================================================
INSERT INTO legal_entity(name, kind_of_business, contact_name, phone_number) VALUES (?, ?, ?, ?)
UPDATE legal_entity SET name=?, kind_of_business=?, contact_name=?, phone_number=? WHERE id=?
DELETE FROM legal_entity WHERE id=?
SELECT * FROM legal_entity WHERE id=?
SELECT * FROM legal_entity
====================================================================================================
INSERT INTO price_list(name, price) VALUES (?, ?)
UPDATE price_list SET name=?, price=? WHERE id=?
DELETE FROM price_list WHERE id=?
SELECT * FROM price_list WHERE id=?
SELECT * FROM price_list
====================================================================================================
INSERT INTO reservation(booking_date, arrival_date, days, persons, booking_cancellation, cancellation_reason, id_hotel_room, id_legal_entity, id_individual) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
UPDATE reservation SET booking_date=?, arrival_date=?, days=?, persons=?, booking_cancellation=?, cancellation_reason=?, id_hotel_room=?, id_legal_entity=?, id_individual=? WHERE id=?
DELETE FROM reservation WHERE id=?
SELECT * FROM reservation WHERE id=?
SELECT * FROM reservation
====================================================================================================
INSERT INTO service(sdate, quantity, id_guest, id_price_list) VALUES (?, ?, ?, ?)
UPDATE service SET sdate=?, quantity=?, id_guest=?, id_price_list=? WHERE id=?
DELETE FROM service WHERE id=?
SELECT * FROM service WHERE id=?
SELECT * FROM service
====================================================================================================