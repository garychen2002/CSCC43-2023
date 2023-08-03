use mybnb;


INSERT INTO `Amenity` (`amenityID`,`name`,`value`) VALUES (1,'Toilet paper',100);
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (2,'Soap');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (3,'Towels');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (4,'Pillow');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (5,'Linens');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (6,'Bedding');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (7,'Locks');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (8,'Pool');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (9,'Hot tub');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (10,'Gym');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (11,'Wi-fi');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (12,'Kitchen');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (13,'Free parking');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (14,'Jacuzzi');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (15,'Washer');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (16,'Dryer');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (17,'Air conditioning');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (18,'Heating');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (19,'Self check-in');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (20,'Laptop friendly');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (21,'Pets allowed');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (22,'Paper towels');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (23,'Gloves');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (24,'Cleaner');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (25,'Wipes');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (26,'Spray');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (27,'Hand sanitizer');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (28,'Smoke alarm');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (29,'Carbon monoxide alarm');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (30,'Fire extinguisher');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (31,'First aid kit');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (32,'Emergency plan');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (33,'Accessible entrance');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (34,'Good lighting');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (35,'Office supplies');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (36,'Crib');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (37,'High chair');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (38,'Bathtub');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (39,'Food bowls');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (40,'Door towels');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (41,'Cooking tools');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (42,'Wine glasses');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (43,'Cooking supplies');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (44,'Coffee');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (45,'Tea');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (46,'Light breakfast');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (47,'Snacks');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (48,'Hangers');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (49,'Adapters/chargers');
INSERT INTO `Amenity` (`amenityID`,`name`) VALUES (50,'Toiletries');

-- ListingStatus
INSERT INTO ListingStatus (name) VALUES ('booked');
INSERT INTO ListingStatus (name) VALUES ('cancelled');
INSERT INTO ListingStatus (name) VALUES ('available');
INSERT INTO ListingStatus (name) VALUES ('occupied');
INSERT INTO ListingStatus (name) VALUES ('deleted');

-- ListingType
INSERT INTO `mybnb`.`listingtype` (`name`) VALUES ('full house');
INSERT INTO `mybnb`.`listingtype` (`name`) VALUES ('apartment');
INSERT INTO `mybnb`.`listingtype` (`name`) VALUES ('room');

-- UserType
INSERT INTO `mybnb`.`usertype` (`name`) VALUES ('renter');
INSERT INTO `mybnb`.`usertype` (`name`) VALUES ('host');

INSERT INTO `mybnb`.`country` (`name`) VALUES ('Canada');
INSERT INTO `mybnb`.`country` (`name`) VALUES ('United States');


INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Newfoundland and Labrador');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Prince Edward Island');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Nova Scotia');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'New Brunswick');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Quebec');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Ontario');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Manitoba');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Saskatchewan');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Alberta');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'British Columbia');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Nunavut');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Northwest Territories');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('1', 'Yukon Territory');

INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Alaska');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Florida');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Illinois');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Indiana');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'New York');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Oregon');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Ohio');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Texas');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Utah');
INSERT INTO `mybnb`.`province` (`countryID`, `name`) VALUES ('2', 'Wisconsin');

INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Barrie');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Brampton');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Brantford');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Burlington');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Cambridge');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Guelph');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Hamilton');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Kingston');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Kitchener');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'London');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Markham');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Mississauga');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Niagara Falls');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'North Bay');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Oshawa');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Ottawa');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Richmond Hill');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Toronto');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Vaughan');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('6', 'Waterloo');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('5', 'Montreal');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('5', 'Quebec City');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('5', 'Laval');
INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('5', 'Gatineau');

INSERT INTO `mybnb`.`city` (`provinceID`, `name`) VALUES ('18', 'New York City');

INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Asma', 'Holland', '2563  St. Paul Street', '13', 'L2E 4E6', '1997-10-13', 'Photographer', '111736906', '2');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Alessandro', 'Melton', '1069  St. Paul Street', '13', 'L2E 4E6', '1984-10-04', 'Teacher', '358123560', '2');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Jake', 'Burton', '1113  St. Paul Street', '13', 'L2E 4E6', '1993-05-21', 'Business owner', '442969143', '2');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Chad', 'Bean', '3642  Danforth Avenue', '18', 'M4K 1A6', '1999-10-18', 'Architect', '127639037', '2');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Abubakar', 'Waters', '1406  Eglinton Avenue', '18', 'M4P 1A6', '2001-01-10', 'Lifeguard', '249397571', '2');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Roseanna', 'Koch', '918 rue Levy', '21', 'H3C 5K4', '1984-02-24', 'IT consultant', '788683167', '1');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Malachi', 'Kane', '2072  rue des Érables', '22', 'G4A 1J8', '1995-12-14', 'Homemaker', '504199621', '1');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Nannie', 'Hubbard', '4637 Pitfield Blvd', '23', 'H7P 2C7', '1999-04-25', 'Tour guide', '525287413', '1');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Talia', 'Carroll', '4233 De la Providence Avenue', '24', 'J8P 8A5', '1998-10-07', 'Waiter', '742306673', '1');
INSERT INTO `mybnb`.`users` (`firstname`, `lastname`, `address`, `cityID`, `postalCode`, `dateofbirth`, `occupation`, `SIN`, `userTypeID`) VALUES ('Zainab', 'Browning', '4487  Montreal Road', '16', 'K1L 6C7', '1997-10-22', 'Lawyer', '256259003', '1');

INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('6', '4716859017808714', '04/29', '156', '1');
INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('7', '4660814984482734', '06/27', '467', '1');
INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('8', '5390398692334464', '08/27', '439', '1');
INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('9', '5399939389700714', '10/26', '852', '1');
INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('10', '4716760449126479', '06/25', '195', '1');
INSERT INTO `mybnb`.`paymentinfo` (`uID`, `creditcard`, `expirydate`, `cvv`, `isDefault`) VALUES ('10', '5261362485613050', '11/28', '739', '0');


INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Modern luxury Suite 6mins to Falls', '1', '1', '3', ST_GeomFromText('POINT(-79.0929703 43.0935046)', 4326), '2563  St. Paul Ave', '13', 'L2E 4E6', 'Experience the ultimate getaway in a charming 2-bedroom retreat that feels just like home. This enchanting haven, nestled in a newly built, luxurious modern residence, boasts an abundance of incredible amenities, including complimentary private parking. Whether you crave serenity or excitement, this property is an impeccable selection. Discover the awe-inspiring Niagara Falls, the vibrant Casino, the lively Clifton Hills, and the thrilling Cineplex, all within a quick minute drive.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Stylish 1 Bedroom w/Parking', '2', '2', '3', ST_GeomFromText('POINT(-79.1008655 43.1457398)', 4326), '1069  St. Paul Ave', '13', 'L2E 4E6', 'Welcome to our charming 1BD/1.5BA Airbnb! Ideal for work or relaxation, our space comfortably accommodates 3 guests. Unwind in the cozy bedroom, complete with a plush queen-size bed. Need to catch up on work? The dedicated work area offers a comfortable desk and chair. The fully stocked kitchen awaits your culinary adventures. Take advantage of the 1.5 bathrooms for added convenience. Located in a prime location, our Airbnb is perfect for exploring the city. Book now for a delightful stay!');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('*Heart of Niagara Fall* Beautifual Private Ensuite', '3', '3', '3', ST_GeomFromText('POINT(-79.1034404 43.1457437)', 4326), '1113  St. Paul Ave', '13', 'L2E 4E6', 'Location!! Location!! Location!!!  Just 5 Mins Walking Distance To The Falls, Casino, And Many Other Tourist Attractions !!!  And Offers Tons Of Potential. Close to many amenities, the border, highway and restaurants');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Cozy, Family Friendly, Private House', '1', '1', '3', ST_GeomFromText('POINT(-79.0930783 43.093205)', 4326), '1050 North Street', '13', 'L2G 1J4', 'Welcome to this pleasant townhouse. Perfect for couples or family retreat. It is ideal for up to five people. Fully fenced private backyard with a lovely patio, seating area, and fire table. 5 min to all amenities, "The Falls", and all the main attractions of Clifton Hill and Casino. A professional cleaning company keeps the house clean and maintained. The home offers 3 BR, 1.5 BTHRM, 1 king, and 3 twin-size beds. The kitchen is equipped.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Priv. Bath, Walk to restaurants, subway near DT', '4', '1', '3', ST_GeomFromText('POINT(-79.2678446 43.6975346)', 4326), '3642  Danforth Avenue', '18', 'M1N 2E8', 'Bright bedroom on the 2nd flr with private bathroom right outside of the room for max social distancing. ️Cheap alternative to hotel rooms in highly accessible area. ️10 mins Uber to key landmarks. ️Walking distance from many restaurants, coffee shops, pubs, bars services.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Brand New Studio in Heart of Downtown Toronto', '4', '2', '3', ST_GeomFromText('POINT(-79.3534622 43.6659834)', 4326), '630 Gerrard St. E.', '18', 'M4M 1Y3', 'Brand new condo studio in the heart of downtown Toronto. Amazing Downtown Toronto city view. Steps to Eaton Center, Ryerson University and George Brown College. Close to Toronto Sugar Beach 5 Mins walk to Dundas subway station and Eaton Center. 15 Mins walk to University of Toronto');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Room in comfort stay', '5', '3', '3', ST_GeomFromText('POINT(-79.3414508 43.6671093)', 4326), '17 Marjory Avenue', '18', 'M4P 2Y2', 'Excellent location, 5 minutes drive to highway, shopping mall and supermarkets. Just 1 minute walk to bus stop. We take pride in providing exceptional hospitality and making sure that out guests feel welcome and at home. We''re happy to offer recommendations for local restaurants, attractions, and activities to make you stay even more enjoyable. Whatever brings you to our area, we''re excited to have you as our guest and looking forward to hosting you soon');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Affordable 1 Bd APT', '5', '2', '3', ST_GeomFromText('POINT(-79.3410218 43.6628601)', 4326), '130 Pape Avenue', '18', 'M4M 2V8', 'This special place is close to everything, making it easy to plan your visit.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Affordable 1 Bd Apt Dt', '5', '2', '3', ST_GeomFromText('POINT(-79.3690647 43.6622584)', 4326), '300 Gerrard St. E.', '18', 'M5A 2G7', 'You''ll have a great time at this comfortable place to stay.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('House close to lake and city', '5', '1', '3', ST_GeomFromText('POINT(-79.3615222 43.6770311)', 4326), '780 Broadview Ave.', '18', 'M4K 2P7', 'Relax with the whole family or travelling group at this peaceful place to stay that''s in the city but feels like the countryside. Also good for travellers since it''s only 35 minutes by train to downtown with train links to Niagra Falls and even Montreal from the local Guildwood station. The main highway is also only 4 km away. The lake and very large parks are within walking distance. Parking free 3-4 cars. Parking at train station also free for outings. Owner is in seperate unit downstairs.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '25 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');


INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.5612264 43.7665433)', 4326), '5601 Steeles Avenue West', '18', 'M9L 1S7', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.2357975 43.8399349)', 4326), '6415 Steeles Avenue East', '18', 'M1X 1N5', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.451927 43.7526767)', 4326), '842  Sheppard Ave', '18', 'M3H 2T4', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3868332 43.6464351)', 4326), '150 Wellington St W', '18', 'M5J 2M4', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '27 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '29 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '31 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '33 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '35 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');
INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-79.3594719 43.658235)', 4326), '37 River Street', '18', 'M5A 3N9', 'A spacious bedroom, very private, close to all amenities.');

INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-74.0135329 40.7070583)', 4326), '15 Wall St.', '25', '10005', 'A spacious bedroom, very private, close to all amenities.');

INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-74.0135329 40.7070583)', 4326), '17 Wall St.', '25', '10005', 'A spacious bedroom, very private, close to all amenities.');

INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-74.0135329 40.7070583)', 4326), '19 Wall St.', '25', '10005', 'A spacious bedroom, very private, close to all amenities.');

INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-74.0135329 40.7070583)', 4326), '21 Wall St.', '25', '10005', 'A spacious bedroom, very private, close to all amenities.');

INSERT INTO `mybnb`.`listing` (`title`, `hostID`, `typeID`, `statusID`, `coordinates`, `address`, `cityID`, `postalCode`, `description`) VALUES ('Spacious Bedroom', '5', '1', '3', ST_GeomFromText('POINT(-74.0135329 40.7070583)', 4326), '23 Wall St.', '25', '10005', 'A spacious bedroom, very private, close to all amenities.');



INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '26');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '33');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '6');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '47');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '8');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '21');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '27');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '43');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '19');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '9');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '30');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '42');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('1', '4');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '40');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '45');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '35');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '21');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '27');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '22');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '7');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '42');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '33');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('2', '18');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '26');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '49');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '4');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '36');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '28');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '14');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '46');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '25');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '39');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '12');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '19');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '31');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '23');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('3', '9');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '40');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '1');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '48');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '36');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '33');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '13');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '47');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '50');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '2');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '49');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '39');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '42');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '5');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('4', '15');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '24');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '7');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '50');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '12');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '28');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '27');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '31');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '34');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '46');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '35');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '26');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '43');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '15');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '6');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('5', '2');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '47');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '19');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '34');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '43');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '8');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '6');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '41');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '14');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '44');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '33');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '32');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '10');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('6', '11');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '40');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '41');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '24');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '27');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '11');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '21');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '26');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '49');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '5');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '22');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('7', '32');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '38');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '36');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '14');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '48');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '3');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '32');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '9');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '43');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '46');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '20');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '30');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '24');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '44');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '7');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('8', '17');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '17');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '29');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '28');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '47');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '37');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '23');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '34');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '44');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '43');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '46');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '31');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '19');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('9', '50');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '45');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '49');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '38');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '13');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '40');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '46');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '31');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '4');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '44');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '47');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '25');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '41');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '28');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('10', '2');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '4');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '34');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '2');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '44');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '10');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '13');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '16');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '31');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '41');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '38');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '33');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '14');
INSERT INTO `mybnb`.`listingamenities` (`listingID`, `amenityID`) VALUES ('11', '35');


INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('1', '2023-10-01', '2023-10-31', '1000');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('2', '2023-08-16', '2023-11-30', '1200');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('3', '2023-11-01', '2024-10-31', '1500');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('4', '2023-07-20', '2023-12-31', '960');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('5', '2023-07-31', '2024-01-31', '1245');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('6', '2023-10-01', '2023-10-15', '1450');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('7', '2024-01-01', '2024-10-31', '1600');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('8', '2024-03-01', '2024-03-15', '1300');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('9', '2023-09-16', '2013-10-31', '1150');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('10', '2023-07-25', '2023-09-15', '990');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('11', '2023-07-01', '2023-12-31', '1050');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('11', '2023-06-01', '2023-06-30', '1050');
INSERT INTO `mybnb`.`listingavailability` (`listingID`, `startDate`, `endDate`, `rentalPrice`) VALUES ('10', '2023-07-01', '2023-07-24', '980');


INSERT INTO `mybnb`.`booking` (`renterID`, `listingID`, `startDate`, `endDate`, `rentalPrice`, `statusID`) VALUES ('6', '1', '2023-06-01', '2023-08-31', '1000', '3');
INSERT INTO `mybnb`.`booking` (`renterID`, `listingID`, `startDate`, `endDate`, `rentalPrice`, `statusID`) VALUES ('10', '1', '2023-09-01', '2023-09-30', '1000', '1');
INSERT INTO `mybnb`.`booking` (`renterID`, `listingID`, `startDate`, `endDate`, `rentalPrice`, `statusID`) VALUES ('7', '2', '2023-08-01', '2023-08-15', '1200', '2');
INSERT INTO `mybnb`.`booking` (`renterID`, `listingID`, `startDate`, `endDate`, `rentalPrice`, `statusID`) VALUES ('8', '3', '2023-09-01', '2023-10-30', '1500', '1');

INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('1', '1', '1', '2023-05-01');
INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('1', '3', '1', '2023-06-01');
INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('2', '1', '10', now());
INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('3', '1', '7', '2023-07-01');
INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('3', '2', '7', now());
INSERT INTO `mybnb`.`bookinghistory` (`bookingID`, `statusID`, `eventBy`, `eventDateTime`) VALUES ('4', '1', '8', now());


INSERT INTO `mybnb`.`listingreview` (`bookingID`, `comment`, `experienceRating`, `hostRating`, `eventDateTime`) VALUES ('1', 'Good', '4', '4', now());
INSERT INTO `mybnb`.`listingreview` (`bookingID`, `comment`, `experienceRating`, `hostRating`, `eventDateTime`) VALUES ('2', 'Good', '5', '4', now());
INSERT INTO `mybnb`.`listingreview` (`bookingID`, `comment`, `experienceRating`, `hostRating`, `eventDateTime`) VALUES ('3', 'Not Good', '1.5', '1', now());
INSERT INTO `mybnb`.`listingreview` (`bookingID`, `comment`, `experienceRating`, `hostRating`, `eventDateTime`) VALUES ('4', 'Good', '4', '3', now());


INSERT INTO `mybnb`.`renterreview` (`bookingID`, `rating`, `comment`, `eventDateTime`) VALUES ('1', '4', 'OK', now());
INSERT INTO `mybnb`.`renterreview` (`bookingID`, `rating`, `comment`, `eventDateTime`) VALUES ('2', '4', 'OK', now());
INSERT INTO `mybnb`.`renterreview` (`bookingID`, `rating`, `comment`, `eventDateTime`) VALUES ('3', '2', 'Not OK', now());
INSERT INTO `mybnb`.`renterreview` (`bookingID`, `rating`, `comment`, `eventDateTime`) VALUES ('4', '3', 'OK', now());







