use mybnb;
DROP TABLE IF EXISTS ListingAmenities, ListingAvailability, Listing, BookingHistory, Booking,
ListingReview, RenterReview, PaymentInfo, Users, 
ListingStatus, ListingType, UserType, Amenity, City, Province, Country;

create table Country (
	countryID integer AUTO_INCREMENT primary key,
    name varchar(20) not null
);    

create table Province (
	provinceID integer AUTO_INCREMENT primary key,
	countryID integer,
	foreign key (countryID) references Country (countryID),
    name varchar(50) not null
);    

create table City (
	cityID integer AUTO_INCREMENT primary key,
	provinceID integer,
	foreign key (provinceID) references Province (provinceID),
    name varchar(20) not null
);    

create table ListingType (
	typeID integer AUTO_INCREMENT primary key,
    name varchar(20) not null
    );

create table Amenity (
	amenityID integer AUTO_INCREMENT primary key,
    name varchar(40) not null,
    value integer default 10
    );
    
create table UserType (
	userTypeID integer AUTO_INCREMENT primary key,
    name varchar(10) not null
    );

create table ListingStatus (
	statusID integer AUTO_INCREMENT primary key,
    name varchar(20) not null
);    

create table Users (
	uID integer AUTO_INCREMENT primary key,
    firstname varchar(30) not null,
	lastname varchar(30) not null,
    address varchar(100),
	cityID int,
	postalCode varchar(10),
    dateofbirth date,
    occupation varchar(60),
    SIN char(9) not null,
    userTypeID integer,
    foreign key (userTypeID) references UserType(userTypeID),
	isActive boolean not null default 1
    );

create table Listing (
	listingID integer AUTO_INCREMENT primary key,
	title varchar(100) not null,
    hostID integer,
    typeID integer,
    statusID integer,
    foreign key (hostID) references Users (uID),
    foreign key (typeID) references ListingType(typeID),
	foreign key (statusID) references ListingStatus (statusID),
    coordinates point not null,
    address varchar(100) not null,
	cityID int,
	postalCode varchar(10),
    description varchar(1000) not null
    );
    
create table PaymentInfo (
	paymentInfoID integer AUTO_INCREMENT primary key,
    uID integer,
	foreign key (uID) references Users (uID),
    creditcard varchar(20) not null,
    expirydate varchar(20) not null,
    cvv varchar(5) not null,
    isDefault boolean not null
    );
    
create table ListingAmenities (
	listingID integer,
    amenityID integer,
	foreign key (listingID) references Listing (listingID),
    foreign key (amenityID) references Amenity (amenityiD),
    primary key (listingID, amenityID)
    );
    
create table ListingAvailability (
	availabilityID integer AUTO_INCREMENT primary key,
    listingID integer,
	foreign key (listingID) references Listing (listingID),
    startDate date,
    endDate date,
    rentalPrice decimal(10,2)
);

create table Booking (
	bookingID integer auto_increment primary key,
    renterID integer,
    listingID integer,
    foreign key (renterID) references Users (uID),
    foreign key (listingID) references Listing (listingID),
    startDate date,
    endDate date,
    rentalPrice decimal(10,2),
	statusID integer,
	foreign key (statusID) references ListingStatus (statusID)
);

create table BookingHistory (
	historyID integer auto_increment primary key,
	bookingID integer,
    foreign key (bookingID) references Booking (bookingID),
	statusID integer,
	foreign key (statusID) references ListingStatus (statusID),
	eventBy integer,
	foreign key (eventBy) references Users (uID),
	eventDateTime datetime default now()
);

create table ListingReview (
	reviewID integer auto_increment primary key,
    bookingID integer,
    foreign key (bookingID) references Booking (bookingID),
    comment varchar(8000),
    experienceRating integer,
    hostRating integer,
    CHECK (experienceRating >= 0 and experienceRating <= 5),
	CHECK (hostRating >= 0 and hostRating <= 5),
	eventDateTime datetime default now()
    );

create table RenterReview (
	reviewID integer auto_increment primary key,
    bookingID integer,
    foreign key (bookingID) references Booking (bookingID),
    rating integer,
    comment varchar(8000),
    CHECK (rating >= 0 and rating <= 5),
	eventDateTime datetime default now()
);

