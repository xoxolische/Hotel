CREATE TABLE legal_entity (
    id INT NOT NULL,
	name VARCHAR(255) NOT NULL,
	kind_of_business VARCHAR(255) NOT NULL,
	contact_name VARCHAR(255) NOT NULL,
	phone_number VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE individual (
    id INT NOT NULL,
	name VARCHAR(255) NOT NULL,
	sex VARCHAR(255) NOT NULL,
	phone_number VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE price_list (
    id INT NOT NULL,
	name VARCHAR(255) NOT NULL,
	price VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE hotel_room (
    id INT NOT NULL,
	rnumber INT NOT NULL,
	rclass INT NOT NULL,
	capacity INT NOT NULL,
	floor INT NOT NULL,
	id_price_list INT NOT NULL,
	INDEX id_price_list_ind_h (id_price_list),
    FOREIGN KEY (id_price_list)
        REFERENCES price_list(id)
        ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE reservation (
    id INT NOT NULL,
	booking_date DATE NOT NULL,
	arrival_date DATE NOT NULL,
	days INT NOT NULL,
	persons INT NOT NULL,
	booking_cancellation DATE,
	cancellation_reason VARCHAR(255),
	id_hotel_room INT NOT NULL,
	id_legal_entity INT NOT NULL,
	id_individual INT NOT NULL,
	INDEX id_individual_ind_r (id_individual),
    FOREIGN KEY (id_individual)
        REFERENCES individual(id)
        ON DELETE CASCADE,
	INDEX id_legal_entity_ind_r (id_legal_entity),
    FOREIGN KEY (id_legal_entity)
        REFERENCES legal_entity(id)
        ON DELETE CASCADE,
	INDEX id_hotel_room_ind_r (id_hotel_room),
    FOREIGN KEY (id_hotel_room)
        REFERENCES hotel_room(id)
        ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE guest (
    id INT NOT NULL,
	arrival_date DATE NOT NULL,
	departure_date DATE NOT NULL,
	additional_space BOOL NOT NULL,
	id_individual INT NOT NULL,
	id_hotel_room INT NOT NULL,
	INDEX id_individual_ind_g (id_individual),
    FOREIGN KEY (id_individual)
        REFERENCES individual(id)
        ON DELETE CASCADE,
	INDEX id_hotel_room_ind_g (id_hotel_room),
    FOREIGN KEY (id_hotel_room)
        REFERENCES hotel_room(id)
        ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE service (
    id INT NOT NULL,
	sdate DATE NOT NULL,
	quantity INT NOT NULL,
	id_guest INT NOT NULL,
	id_price_list INT NOT NULL,
	INDEX id_guest_ind_s (id_guest),
    FOREIGN KEY (id_guest)
        REFERENCES guest(id)
        ON DELETE CASCADE,
	INDEX id_price_list_ind_s (id_price_list),
    FOREIGN KEY (id_price_list)
        REFERENCES price_list(id)
        ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE account (
    id INT NOT NULL,
	cost DOUBLE NOT NULL,
	payment_date DATE,
	id_guest INT NOT NULL,
	id_individual INT NOT NULL,
	id_legal_entity INT NOT NULL,
	INDEX id_guest_ind_a (id_guest),
    FOREIGN KEY (id_guest)
        REFERENCES guest(id)
        ON DELETE CASCADE,
	INDEX id_individual_ind_a (id_individual),
    FOREIGN KEY (id_individual)
        REFERENCES individual(id)
        ON DELETE CASCADE,
	INDEX id_legal_entity_ind_a (id_legal_entity),
    FOREIGN KEY (id_legal_entity)
        REFERENCES legal_entity(id)
        ON DELETE CASCADE,
    PRIMARY KEY (id)
);
