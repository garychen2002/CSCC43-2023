package cscc43project;

import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CSCC43Driver {

	private static final String dbClassName = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/mybnb";
	public static Connection conn;
	static Scanner scanner = new Scanner(System.in);

	public static void userType() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM userType ORDER BY userTypeID;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			int id  = rs.getInt("userTypeID");
			String name = rs.getString("name");
			//Display values
			System.out.print("ID: " + id);
			System.out.println(", Name: " + name);
		}
		rs.close();
		stmt.close();
	}

	public static void listingType() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM listingType ORDER BY typeID;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			int id  = rs.getInt("typeID");
			String name = rs.getString("name");
			//Display values
			System.out.print("ID: " + id);
			System.out.println(", Name: " + name);
		}
		rs.close();
		stmt.close();
	}
	
	public static void listingStatus() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM listingStatus ORDER BY statusID;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			int id  = rs.getInt("statusID");
			String name = rs.getString("name");
			//Display values
			System.out.print("ID: " + id);
			System.out.println(", Name: " + name);
		}
		rs.close();
		stmt.close();
	}
	
	public static void country() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM country;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			int id  = rs.getInt("countryID");
			String name = rs.getString("name");
			//Display values
			System.out.print("ID: " + id);
			System.out.println(", Name: " + name);
		}
		rs.close();
		stmt.close();
	}
	
	public static void province() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "select p1.provinceId, p1.name as province, c1.name as country"
				+ " from province p1 inner join country c1 on c1.countryID=p1.countryID";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			String id = rs.getString("provinceID");
			String provinceName = rs.getString("province");
			String countryName = rs.getString("country");
			//Display values
			System.out.print("ID: " + id);
			System.out.print(", Province: " + provinceName);
			System.out.println(", Country: " + countryName);
		}
		rs.close();
		stmt.close();
	}
	
	public static void city() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "select c1.cityID, c1.name as city, p1.name as province, c2.name as country"
				+ " from city c1 inner join province p1 on p1.provinceID=c1.provinceID"
				+ " inner join country c2 on c2.countryID=p1.countryID"
				+ " order by c1.name";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			String id = rs.getString("cityID");
			String provinceName = rs.getString("province");
			String countryName = rs.getString("country");
			String cityName = rs.getString("city");
			//Display values
			System.out.print("ID: " + id);
			System.out.print(", City: " + cityName);
			System.out.print(", Province: " + provinceName);
			System.out.println(", Country: " + countryName);
		}
		rs.close();
		stmt.close();
	}
	
	public static void amenity() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM amenity;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			//Retrieve by column name
			int id  = rs.getInt("amenityID");
			String name = rs.getString("name");
			//Display values
			System.out.print("ID: " + id);
			System.out.println(", Name: " + name);
		}
		rs.close();
		stmt.close();
	}
	
	public static int validateCountry(String country) throws SQLException {
		int countryID = -1;
		Statement stmt = conn.createStatement();
		String sql = MessageFormat.format("SELECT countryID FROM country WHERE country.name=''{0}'';", country);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			countryID = rs.getInt("countryID");
		}
		return countryID; // -1 if not found
	}

	public static int validateProvince(String province, int countryID) throws SQLException {
		int provinceID = -1;
		Statement stmt = conn.createStatement();
		String sql = MessageFormat.format("SELECT provinceID FROM province WHERE province.name=''{0}'' and province.countryID=''{1}'';", province, Integer.toString(countryID));
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			provinceID = rs.getInt("provinceID");
		}
		return provinceID; // -1 if not found
	}
	
	public static int validateCity(String city, int provinceID) throws SQLException {
		int cityID = -1;
		Statement stmt = conn.createStatement();
		String sql = MessageFormat.format("SELECT cityID FROM city"
				+ " WHERE city.name=''{0}'' and city.provinceID=''{1}'';",
				city, Integer.toString(provinceID));
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			cityID = rs.getInt("cityID");
		}
		return cityID; // -1 if not found
	}
	
	public static int validateAmenity(String amenity) throws SQLException {
		int amenityID = -1;
		Statement stmt = conn.createStatement();
		String sql = MessageFormat.format("SELECT amenityID FROM amenity WHERE amenity.name=''{0}'';", amenity);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			amenityID = rs.getInt("amenityID");
		}
		return amenityID; // -1 if not found
	}
	
	
	public static void createHost() throws SQLException {

		
//		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Please enter last name: ");
		String lastName = scanner.nextLine();
		System.out.println("address");
		String address = scanner.nextLine();
		// validate
		System.out.println("Country");
		String country = scanner.nextLine();
		int countryID = validateCountry(country);
		if (countryID == -1)
		{
			System.out.println("INVALID COUNTRY");
			return;
		}
		System.out.println("province");
		String province = scanner.nextLine();
		int provinceID = validateProvince(province, countryID);
		if (provinceID == -1)
		{
			System.out.println("INVALID PROVINCE");
			return;
		}
		System.out.println("city");
		String city = scanner.nextLine();
		int cityID = validateCity(city, provinceID);
		if (cityID == -1)
		{
			System.out.println("INVALID CITY");
			return;
		}
		System.out.println("postal code (max 10)");
		String postalCode = scanner.nextLine();
		System.out.println("date of birth YYYY-MM-DD");
		String dateOfBirth = scanner.nextLine();
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.parse(dateOfBirth);
		Period p = Period.between(birthday, today);
		int age = p.getYears();
		if (age < 18)
		{
			System.out.println("must be 18 years old to register");
			return;
		}
		System.out.println("Occupation");
		String occupation = scanner.nextLine();
		System.out.println("SIN (max 9)");
		String SIN = scanner.nextLine();

		PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(firstname, lastname, address, cityID, postalCode, dateofbirth, occupation, SIN, userTypeID)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setString(3, address);
		stmt.setString(4, Integer.toString(cityID));
		stmt.setString(5, postalCode);
		stmt.setString(6, dateOfBirth);
		stmt.setString(7, occupation);
		stmt.setString(8, SIN);
		stmt.setString(9, "2"); // Host user type
		stmt.executeUpdate();
		
		ResultSet generatedKey = stmt.getGeneratedKeys();
		int lastinsertid = -1;
		if (generatedKey.next()) {
		    lastinsertid = generatedKey.getInt(1);
		}
		System.out.println("Host created. Inserted record's ID: " + lastinsertid);
		return;
	}
	
	public static void createRenter() throws SQLException {

		
		System.out.println("Please enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Please enter last name: ");
		String lastName = scanner.nextLine();
		System.out.println("address");
		String address = scanner.nextLine();
		// validate
		System.out.println("Country");
		String country = scanner.nextLine();
		int countryID = validateCountry(country);
		if (countryID == -1)
		{
			System.out.println("INVALID COUNTRY");
			return;
		}
		System.out.println("province");
		String province = scanner.nextLine();
		int provinceID = validateProvince(province, countryID);
		if (provinceID == -1)
		{
			System.out.println("INVALID PROVINCE");
			return;
		}
		System.out.println("city");
		String city = scanner.nextLine();
		int cityID = validateCity(city, provinceID);
		if (cityID == -1)
		{
			System.out.println("INVALID CITY");
			return;
		}
		System.out.println("postal code (max 10)");
		String postalCode = scanner.nextLine();
		System.out.println("date of birth YYYY-MM-DD");
		String dateOfBirth = scanner.nextLine();
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.parse(dateOfBirth);
		Period p = Period.between(birthday, today);
		int age = p.getYears();
		if (age < 18)
		{
			System.out.println("must be 18 years old to register");
			return;
		}
		System.out.println("Occupation");
		String occupation = scanner.nextLine();
		System.out.println("SIN (max 9)");
		String SIN = scanner.nextLine();
		System.out.println("Credit Card Number (no spaces)");
		String creditCard = scanner.nextLine();
		System.out.println("expiry date (MM/YY)");
		String expiryDate = scanner.nextLine();
		System.out.println("cvv");
		String cvv = scanner.nextLine();

		PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(firstname, lastname, address, cityID, postalCode, dateofbirth, occupation, SIN, userTypeID)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setString(3, address);
		stmt.setString(4, Integer.toString(cityID));
		stmt.setString(5, postalCode);
		stmt.setString(6, dateOfBirth);
		stmt.setString(7, occupation);
		stmt.setString(8, SIN);
		stmt.setString(9, "1"); // Renter user type
		stmt.executeUpdate();
		
		ResultSet generatedKey = stmt.getGeneratedKeys();
		int lastinsertid = -1;
		if (generatedKey.next()) {
		    lastinsertid = generatedKey.getInt(1);
		}
		
		PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO paymentinfo(uID, creditcard, expirydate, cvv, isdefault) VALUES (?, ?, ?, ?, ?)");
		stmt2.setString(1, Integer.toString(lastinsertid));
		stmt2.setString(2, creditCard);
		stmt2.setString(3, expiryDate);
		stmt2.setString(4, cvv);
		stmt2.setString(5, "1");
		System.out.println("Renter created. Inserted record's ID: " + lastinsertid);

		return;
	}
	
	public static void users() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT u1.uID, u1.firstname, u1.lastname, u1.address, c1.name as city, p1.name as province, c2.name as country, u1.postalCode, u1.dateofbirth, u1.occupation, u1.SIN, u1.isActive, ut.name as userType"
				+ " FROM users u1 inner join userType ut on ut.userTypeID = u1.userTypeID inner join city c1 on c1.cityID = u1.cityID inner join province p1 on p1.provinceID=c1.provinceID inner join country c2 on c2.countryID=p1.countryID"
				+ " ORDER BY uID");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static int switchUser() throws SQLException {
		int uid = -1;
		System.out.println("Enter UID to switch to");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid UID: Not a number");
			scanner.nextLine();
			return -1;
		}
		uid = scanner.nextInt();
		scanner.nextLine();
		PreparedStatement stmt = conn.prepareStatement("SELECT u1.firstname, u1.lastname, u1.isActive, ut.name as userType from users u1 inner join userType ut on ut.userTypeID=u1.userTypeID where u1.uID=?");
		stmt.setInt(1, uid);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next())
		{
			if (rs.getInt("isActive") == 0)
			{
				System.out.println("Cannot switch: user was deleted");
				return -1;
			}
			System.out.println("Switched to " + rs.getString("firstname") + " " + rs.getString("lastname") + " (" + rs.getString("userType") + ")");
			return uid;
		}
		System.out.println("UID not found in database");
		return -1;
	}
	
	public static void deleteUser(int uid) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE users set isActive = 0 where uID = ?");
		stmt.setInt(1, uid);
		stmt.execute();
	}
	
	public static void undeleteUser() throws SQLException {
		System.out.println("Enter UID to undelete:");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid UID: Not a number");
			scanner.nextLine();
			return;
		}		
		int uid = scanner.nextInt();
		scanner.nextLine();
		PreparedStatement stmt = conn.prepareStatement("UPDATE users set isActive = 1 where uID = ?");
		stmt.setInt(1, uid);
		stmt.execute();
	}
	
	public static int switchListing () throws SQLException {
		int lid = -1;
		System.out.println("Enter Listing ID to switch to");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return -1;
		}
		lid = scanner.nextInt();
		scanner.nextLine();
		PreparedStatement stmt = conn.prepareStatement("SELECT l1.listingID, l1.title from Listing l1 where l1.listingID=?");
		stmt.setInt(1, lid);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next())
		{
			System.out.println("Switched to " + rs.getString("title"));
			return lid;
		}
		System.out.println("LID not found in database");
		return -1;
	}
	
	public static void searchListingsFiltered(ArrayList<Integer> ids) // IDs to search from
	{
		
	}
	
	public static void searchListings() throws SQLException {
		System.out.println("Search by: distance, address, date, amenity, postal code?");
		String input = scanner.nextLine();
		switch (input) {
		case "distance":
			break;
		case "address":
			break;
		case "date":
			break;
		case "amenity":
			break;
		case "postal":
		case "postal code":
		case "postalcode":
			
			break;
		default:
			System.out.println("Unrecognized option.");
		}
	}
	
	public static void createListing(int uid) throws SQLException {
		// inputs: title, listing type (suggest price), latitude, longitude, address, city, province, country, postalcode, description, amenities (loop until done?), suggest revenue increase
		System.out.println("Input a title");
		String title = scanner.nextLine();
		System.out.println("Choose a listing type: full house, apartment, room");
		HashMap<String, Integer> listingTypeMap = new HashMap<>();
		listingTypeMap.put("full house", 1);
		listingTypeMap.put("apartment", 2);
		listingTypeMap.put("room", 3);
		HashMap<String, Integer> typePriceSuggestion = new HashMap<>();
		typePriceSuggestion.put("full house", 1000);
		typePriceSuggestion.put("apartment", 750);
		typePriceSuggestion.put("room", 500);
		String type = scanner.nextLine();
		if (!listingTypeMap.containsKey(type))
		{
			System.out.println("Invalid room type.");
			return;
			
		}
		
		int listingTypeID = listingTypeMap.get(type);
		System.out.println("Suggested price for this listing is $" + typePriceSuggestion.get(type)); // Price Suggestion
		System.out.println("Enter latitude");
		if (!scanner.hasNextDouble())
		{
			System.out.println("Invalid input");
			scanner.nextLine();
			return;
		}
		double latitude = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter longitude");
		if (!scanner.hasNextDouble())
		{
			System.out.println("Invalid input");
			scanner.nextLine();
			return;
		}
		double longitude = scanner.nextDouble();
		scanner.nextLine();
	
		System.out.println("Enter address");
		String address = scanner.nextLine();
		
		System.out.println("Country");
		String country = scanner.nextLine();
		int countryID = validateCountry(country);
		if (countryID == -1)
		{
			System.out.println("INVALID COUNTRY");
			return;
		}
		System.out.println("province");
		String province = scanner.nextLine();
		int provinceID = validateProvince(province, countryID);
		if (provinceID == -1)
		{
			System.out.println("INVALID PROVINCE");
			return;
		}
		System.out.println("city");
		String city = scanner.nextLine();
		int cityID = validateCity(city, provinceID);
		if (cityID == -1)
		{
			System.out.println("INVALID CITY");
			return;
		}
		System.out.println("postal code (max 10)");
		String postalCode = scanner.nextLine();
		
		System.out.println("Enter a description:");
		String description = scanner.nextLine();
		
		ArrayList<String> suggestedAmenities = new ArrayList<String>(Arrays.asList("Wi-fi", "Toilet paper", "Soap", "Snacks", "Air conditioning"));
		HashMap<String, Integer> amenitiesRevenue = new HashMap<String, Integer>();
		amenitiesRevenue.put("Wi-fi", 10);
		amenitiesRevenue.put("Toilet paper", 100);
		amenitiesRevenue.put("Soap", 50);
		amenitiesRevenue.put("Snacks", 60);
		amenitiesRevenue.put("Air conditioning", 70);
		// suggested amenities: list some as the top rated ones

		// amenity loop
		ArrayList<String> amenities = new ArrayList<String>();
		ArrayList<Integer> amenityIDs = new ArrayList<Integer>();
		String suggestionString = "Suggested Amenities You Haven't Added:";
		boolean quit = true;
		while (quit)
		{
			System.out.println(suggestionString);
			for (int i = 0; i < suggestedAmenities.size(); i++)
			{
				String suggestedAmenityName = suggestedAmenities.get(i);
				if (!amenities.contains(suggestedAmenityName.toLowerCase())) // not present already
				{
					String suggestion = "    - " + suggestedAmenityName + " (estimated revenue increase: $" + Integer.toString(amenitiesRevenue.get(suggestedAmenityName)) + ")";
					System.out.println(suggestion);
				}
			}
			System.out.println("");
			System.out.println("Enter next amenity, or type done:");
			String input = scanner.nextLine();
			switch (input)
			{
				case "done":
					quit = false;
					break;
				default:
					// validate amenity
					int amenityID = validateAmenity(input);
					if (amenityID != -1)
					{
						// add to amenities list
						amenities.add(input.toLowerCase());
						amenityIDs.add(amenityID);
					}
					else {
						System.out.println("INVALID AMENITY");
					}
			}		
		}
		// insert the listing and save its ID
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Listing(title, hostID, typeID, statusID, coordinates, address, cityID, postalCode, description)"
				+ " VALUES (?, ?, ?, ?, ST_GeomFromText(?, 4326), ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, title);
		stmt.setInt(2, uid);
		stmt.setInt(3, listingTypeID);
		stmt.setInt(4, 3); // available statusID?
		stmt.setString(5, "POINT(" + Double.toString(latitude) + " " + Double.toString(longitude) + ")");
		stmt.setString(6, address);
		stmt.setInt(7, cityID);
		stmt.setString(8, postalCode);
		stmt.setString(9, description);
		stmt.executeUpdate();
		
		ResultSet generatedKey = stmt.getGeneratedKeys();
		int lastinsertid = -1;
		if (generatedKey.next()) {
		    lastinsertid = generatedKey.getInt(1);
		}
		// go through all amenities and add them to ListingAmenities using listing and amenity ID

		PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO ListingAmenities(listingID, amenityID) VALUES (?, ?)");
		for (int i = 0; i < amenityIDs.size(); i++)
		{
			stmt2.setInt(1, lastinsertid);
			stmt2.setInt(2, amenityIDs.get(i));
			stmt2.executeUpdate();
		}
		System.out.println("Listing created. Inserted record's ID: " + lastinsertid);
		
		return;
	}
	
	public static boolean checkUserHost(int uid) throws SQLException {
		boolean host = false;
		PreparedStatement stmt = conn.prepareStatement("SELECT u1.uid, u1.userTypeID from users u1 where u1.uid=? and u1.userTypeID=2");
		stmt.setInt(1, uid);
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			host = true;
		return host;
	}
	
	public static boolean checkUserRenter(int uid) throws SQLException {
		boolean renter = false;
		PreparedStatement stmt = conn.prepareStatement("SELECT u1.uid, u1.userTypeID from users u1 where u1.uid=? and u1.userTypeID=1");
		stmt.setInt(1, uid);
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			renter = true;
		return renter;
	}
	
	public static boolean checkUserHostOfListing(int uid, int lid) throws SQLException {
		if (checkUserHost(uid))
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT listingID from listing where hostID = ? and listingID = ?");
			stmt.setInt(1, uid);
			stmt.setInt(2, lid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return true;
		}
		return false;
	}
	
	public static void listAvailability (int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ListingAvailability WHERE listingID = ? ORDER BY availabilityID");
		stmt.setInt(1, listingID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void listAllAvailability() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ListingAvailability ORDER BY availabilityID");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static boolean checkAvailabilityInListing (int listingID, int availabilityID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ListingAvailability WHERE listingID = ? and availabilityID = ?");
		stmt.setInt(1, listingID);
		stmt.setInt(2, availabilityID);
		ResultSet rs = stmt.executeQuery();
		return (rs.next());
	}
	
	public static void createAvailability (int listingID) throws SQLException {
		System.out.println("Enter start date (YYYY-MM-DD)");
		String startDate = scanner.nextLine();
		System.out.println("Enter end date YYYY-MM-DD");
		String endDate = scanner.nextLine();
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		if (end.isBefore(start))
		{
			System.out.println("Invalid: end date before start date");
			return;
		}
		System.out.println("Enter price (integer)");
		int price = scanner.nextInt();
		scanner.nextLine();
		

		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ListingAvailability(listingID, startDate, endDate, rentalPrice) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, listingID);
		stmt.setString(2, startDate);
		stmt.setString(3, endDate);
		stmt.setInt(4, price);
		stmt.executeUpdate();
		ResultSet generatedKey = stmt.getGeneratedKeys();
		int lastinsertid = -1;
		if (generatedKey.next()) {
		    lastinsertid = generatedKey.getInt(1);
		}
		System.out.println("Availability created. Inserted record's ID: " + lastinsertid);
	}

	public static void updateAvailability (int listingID) throws SQLException {
		// Since availability records will be deleted when a booking is created, this will serve as preventing changes for booked days
		System.out.println("Enter the availability ID to update");
		int availabilityID = scanner.nextInt();
		scanner.nextLine();
		if (!checkAvailabilityInListing(listingID, availabilityID))
		{
			System.out.println("Availability ID does not match the current listing");
			return;
		}
		System.out.println("Enter start date (YYYY-MM-DD)");
		String startDate = scanner.nextLine();
		System.out.println("Enter end date YYYY-MM-DD");
		String endDate = scanner.nextLine();
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		if (end.isBefore(start))
		{
			System.out.println("Invalid: end date before start date");
			return;
		}
		System.out.println("Enter price (integer)");
		int price = scanner.nextInt();
		scanner.nextLine();
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE ListingAvailability set startDate=?, endDate=?, rentalPrice=? where availabilityID = ?", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
		stmt.setInt(3, price);
		stmt.setInt(4, availabilityID);
		stmt.executeUpdate();
		System.out.println("Availability updated.");
		
	}
	
	public static void deleteAvailability (int listingID) throws SQLException {
		System.out.println("Enter the availability ID to delete");
		int availabilityID = scanner.nextInt();
		scanner.nextLine();
		if (!checkAvailabilityInListing(listingID, availabilityID))
		{
			System.out.println("Availability ID does not match the current listing");
			return;
		}
		
		PreparedStatement stmt = conn.prepareStatement("DELETE from ListingAvailability where availabilityID = ?", Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, availabilityID);
		stmt.executeUpdate();
		System.out.println("Availability deleted.");
	}
	
	public static void listAllListings() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT l.*, ST_Latitude(l.coordinates) as latitude, ST_Longitude(l.coordinates) as longitude FROM Listing l ORDER BY listingID");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns-2; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				if (rsmd.getColumnLabel(i).equals("coordinates"))
				{
					System.out.print(rsmd.getColumnLabel(columns-1) + ": " + rs.getString(columns-1)); // latitude
					System.out.print(", ");
					System.out.print(rsmd.getColumnLabel(columns) + ": " + rs.getString(columns)); // longitude
				}
				else
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void listListings(int uid) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT l.*, ST_Latitude(l.coordinates) as latitude, ST_Longitude(l.coordinates) as longitude FROM Listing l WHERE hostID=? ORDER BY listingID");
		stmt.setInt(1, uid);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns-2; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				if (rsmd.getColumnLabel(i).equals("coordinates"))
				{
					System.out.print(rsmd.getColumnLabel(columns-1) + ": " + rs.getString(columns-1)); // latitude
					System.out.print(", ");
					System.out.print(rsmd.getColumnLabel(columns) + ": " + rs.getString(columns)); // longitude
				}
				else
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void updateListing (int listingID) throws SQLException {
		System.out.println("Enter a new title: ");
		String newTitle = scanner.nextLine();
		System.out.println("Enter a new description: ");
		String newDescription = scanner.nextLine();
		PreparedStatement stmt = conn.prepareStatement("UPDATE Listing set title = ?, description = ? where listingID = ?");
		stmt.setString(1, newTitle);
		stmt.setString(2, newDescription);
		stmt.setInt(3, listingID);
		stmt.executeUpdate();
		System.out.println("Listing updated.");
	}
	
	public static void deleteListing (int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE Listing set statusID = 5 where listingID = ?");
		stmt.setInt(1, listingID);
		stmt.executeUpdate();
		System.out.println("Listing deleted.");
	}
	
	public static void listAmenity(int listingID) throws SQLException {
		
		PreparedStatement stmt = conn.prepareStatement("SELECT a1.name FROM Amenity a1 inner join ListingAmenities la on la.amenityID=a1.amenityID where la.listingID=?");
		stmt.setInt(1, listingID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
	}
	
	public static void updateAmenity(int listingID) throws SQLException {
		System.out.println("Enter the new list of amenities: ");
		// amenity loop
		ArrayList<String> amenities = new ArrayList<String>();
		ArrayList<Integer> amenityIDs = new ArrayList<Integer>();
		boolean quit = true;
		while (quit)
		{
			System.out.println("Enter next amenity, or type done:");
			String input = scanner.nextLine();
			switch (input)
			{
				case "done":
					quit = false;
					break;
				default:
					// validate amenity
					int amenityID = validateAmenity(input);
					if (amenityID != -1)
					{
						// add to amenities list
						amenities.add(input.toLowerCase());
						amenityIDs.add(amenityID);
					}
					else {
						System.out.println("INVALID AMENITY");
					}
			}		
		}
		PreparedStatement delete = conn.prepareStatement("DELETE from ListingAmenities where listingID=?");
		delete.setInt(1, listingID);
		delete.executeUpdate();
		
		PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO ListingAmenities(listingID, amenityID) VALUES (?, ?)");
		for (int i = 0; i < amenityIDs.size(); i++)
		{
			stmt2.setInt(1, listingID);
			stmt2.setInt(2, amenityIDs.get(i));
			stmt2.executeUpdate();
		}		
		System.out.println("Amenities updated.");
	}
	
	public static void bookListing(int listingID, int renterID) throws SQLException {
		// Show availability slots
		
		PreparedStatement slots = conn.prepareStatement("SELECT * FROM ListingAvailability where listingID=?");
		slots.setInt(1,listingID);
		ResultSet rs = slots.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		
		System.out.println("Enter the availability ID you want to book: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int availabilityID = scanner.nextInt();
		scanner.nextLine();
		if (!checkAvailabilityInListing(listingID, availabilityID))
		{
			System.out.println("Availability ID does not match the current listing");
			return;
		}
		
		PreparedStatement info = conn.prepareStatement("SELECT * FROM ListingAvailability where listingID=? and availabilityID=?");
		info.setInt(1,listingID);
		info.setInt(2,availabilityID);
		ResultSet rs2 = info.executeQuery();
		rs2.next(); // we know it exists because we just checked
		String availabilityStartDateString = rs2.getString("startDate");
		String availabilityEndDateString = rs2.getString("endDate");
		LocalDate availabilityStart = LocalDate.parse(availabilityStartDateString);
		LocalDate availabilityEnd = LocalDate.parse(availabilityEndDateString);
		int rentalPrice = rs2.getInt("rentalPrice");

		
		System.out.println("Enter your starting date: (YYYY-MM-DD)");
		String startDate = scanner.nextLine();
		LocalDate start = LocalDate.parse(startDate);
		LocalDate startNew = start.minusDays(1);
		
		if (start.isBefore(availabilityStart))
		{
			System.out.println("Invalid: start date before availability start date");
			return;
		}
		
		System.out.println("Enter your ending date: (YYYY-MM-DD)");
		String endDate = scanner.nextLine();
		LocalDate end = LocalDate.parse(endDate);
		LocalDate endNew = end.plusDays(1);

		if (end.isBefore(start))
		{
			System.out.println("Invalid: end date before start date");
			return;
		}

		if (end.isBefore(availabilityStart))
		{
			System.out.println("Invalid: end date before availability start date");
			return;
		}
		if (end.isAfter(availabilityEnd))
		{
			System.out.println("Invalid: end date after availability end date");
			return;
		}
		if (start.isAfter(availabilityEnd))
		{
			System.out.println("Invalid: start date after availability end date");
			return;
		}
		boolean startEqual = start.isEqual(availabilityStart);
		boolean endEqual = end.isEqual(availabilityEnd);

		
		PreparedStatement reinsert = conn.prepareStatement("INSERT into ListingAvailability (listingID, startDate, endDate, rentalPrice) VALUES (?, ?, ?, ?)");
		if (startEqual && endEqual) // matches availability times exactly
		{
			// do nothing
		}
		else if (startEqual && !endEqual) // reinsert availability from new end+1 to old end
		{
			reinsert.setInt(1, listingID);
			reinsert.setString(2, endNew.toString());
			reinsert.setString(3, availabilityEndDateString);
			reinsert.setInt(4,rentalPrice);
			reinsert.executeUpdate();
		}
		else if (!startEqual && endEqual) // availability from old start to new start -1
		{
			reinsert.setInt(1, listingID);
			reinsert.setString(2, availabilityStartDateString);
			reinsert.setString(3, startNew.toString());
			reinsert.setInt(4,rentalPrice);
			reinsert.executeUpdate();
		}
		else // both unequal: reinsert 2 new availability from old start to new start -1, new end+1 to old end
		{
			// start
			reinsert.setInt(1, listingID);
			reinsert.setString(2, availabilityStartDateString);
			reinsert.setString(3, startNew.toString());
			reinsert.setInt(4,rentalPrice);
			reinsert.executeUpdate();
			// end
			reinsert.setInt(1, listingID);
			reinsert.setString(2, endNew.toString());
			reinsert.setString(3, availabilityEndDateString);
			reinsert.setInt(4,rentalPrice);
			reinsert.executeUpdate();
		}
		
		PreparedStatement booking = conn.prepareStatement("INSERT INTO Booking (renterID, listingID, startDate, endDate, rentalPrice, statusID) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		booking.setInt(1, renterID);
		booking.setInt(2,listingID);
		booking.setString(3, start.toString());
		booking.setString(4, end.toString());
		booking.setInt(5, rentalPrice);
		booking.setInt(6, 1); // booked status
		booking.executeUpdate();
		ResultSet generatedKey = booking.getGeneratedKeys();
		int lastinsertid = -1;
		if (generatedKey.next()) {
		    lastinsertid = generatedKey.getInt(1);
		}		
		
		PreparedStatement bookingHistory = conn.prepareStatement("INSERT INTO BookingHistory (bookingID, statusID, eventBy, eventDateTime) VALUES (?, ?, ?, ?)");
		bookingHistory.setInt(1, lastinsertid);
		bookingHistory.setInt(2, 1); // booked
		bookingHistory.setInt(3, renterID);
		bookingHistory.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		bookingHistory.executeUpdate();
		
		System.out.println("Successfully booked. ID: " + Integer.toString(lastinsertid));

		PreparedStatement delete = conn.prepareStatement("DELETE from ListingAvailability where availabilityID=?");
		delete.setInt(1, availabilityID);
		delete.executeUpdate();
	}
	
	public static void listBookingsByListing(int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls where listingID=? and b.statusID=ls.statusID");
		stmt.setInt(1, listingID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void listBookingsByUser(int userID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls where b.statusID=ls.statusID and renterID=?");
		stmt.setInt(1, userID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void listBookedBookingsByUserAndListing(int userID, int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls where b.statusID=ls.statusID and renterID=? and listingID=? and b.statusID=1");
		stmt.setInt(1, userID);
		stmt.setInt(2, listingID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void listBookedBookingsByListing(int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls where b.statusID=ls.statusID and listingID=? and b.statusID=1");
		stmt.setInt(1, listingID);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static boolean checkUserBookedListing(int userID, int listingID) throws SQLException {
		if (checkUserRenter(userID))
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT bookingID from Booking where renterID = ? and listingID = ? and statusID = 1");
			stmt.setInt(1, userID);
			stmt.setInt(2, listingID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return true;
		}
		return false;
	}
	
	public static void cancelBookingByRenter(int userID, int listingID) throws SQLException {
		listBookedBookingsByUserAndListing(userID, listingID); // Display relevant bookings
		System.out.println("Enter the booking ID to cancel: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int bookingID = scanner.nextInt();
		scanner.nextLine();
		
		// Validate bookingID is valid for the renter/listing
		PreparedStatement idCheck = conn.prepareStatement("SELECT bookingID from booking where bookingID = ? and renterID = ? and listingID = ? and statusID=1");
		idCheck.setInt(1, bookingID);
		idCheck.setInt(2, userID);
		idCheck.setInt(3, listingID);
		ResultSet rs = idCheck.executeQuery();
		if (!rs.next())
		{
			System.out.println("Invalid ID");
			return;
		}
		// Set cancelled.
		PreparedStatement cancel = conn.prepareStatement("UPDATE Booking SET statusID=2 where bookingID=?");
		cancel.setInt(1, bookingID);
		cancel.executeUpdate();
		
		// Insert history value
		PreparedStatement history = conn.prepareStatement("INSERT INTO BookingHistory (bookingID, statusID, eventBy, eventDateTime) VALUES (?, ?, ?, ?)");
		history.setInt(1, bookingID);
		history.setInt(2, 2); // cancel
		history.setInt(3, userID);
		history.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		history.executeUpdate();		
		
		// Insert new availability
		PreparedStatement infoCheck = conn.prepareStatement("SELECT startDate, endDate, rentalPrice from booking where bookingID=? and renterID=? and listingID=?");
		infoCheck.setInt(1, bookingID);
		infoCheck.setInt(2, userID);
		infoCheck.setInt(3, listingID);
		ResultSet rs2 = infoCheck.executeQuery();
		rs2.next();
		
		Date start = rs2.getDate("startDate");
		Date end = rs2.getDate("endDate");
		int rentalPrice = rs2.getInt("rentalPrice");

		LocalDate localStart = start.toLocalDate();
		LocalDate localEnd = end.toLocalDate();

		LocalDate today = LocalDate.now();
		LocalDate laterDate;
		// If today is after the endDate, then don't make a new availability
		if (today.isAfter(localEnd))
			return;
		// The start date of the new availability should be the later of the two dates.
		if (today.isAfter(localStart))
			laterDate = today;
		else {
			laterDate = localStart;
		}
		
		Date newDate = Date.valueOf(laterDate);
		PreparedStatement dateAdd = conn.prepareStatement("INSERT INTO ListingAvailability (listingID, startDate, endDate, rentalPrice) VALUES (?, ?, ?, ?)");		
		dateAdd.setInt(1, listingID);
		dateAdd.setDate(2, newDate);
		dateAdd.setDate(3, end);
		dateAdd.setInt(4, rentalPrice);
		dateAdd.executeUpdate();
	}
	

	public static void cancelBookingByHost(int userID, int listingID) throws SQLException {
		listBookedBookingsByListing(listingID); // Display relevant bookings
		System.out.println("Enter the booking ID to cancel: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int bookingID = scanner.nextInt();
		scanner.nextLine();
		
		// Validate bookingID is valid for the renter/listing
		PreparedStatement idCheck = conn.prepareStatement("SELECT bookingID from booking where bookingID = ? and listingID = ? and statusID=1");
		idCheck.setInt(1, bookingID);
		idCheck.setInt(2, listingID);
		ResultSet rs = idCheck.executeQuery();
		if (!rs.next())
		{
			System.out.println("Invalid ID");
			return;
		}
		// Set cancelled.
		PreparedStatement cancel = conn.prepareStatement("UPDATE Booking SET statusID=2 where bookingID=?");
		cancel.setInt(1, bookingID);
		cancel.executeUpdate();
		
		// Insert history value
		PreparedStatement history = conn.prepareStatement("INSERT INTO BookingHistory (bookingID, statusID, eventBy, eventDateTime) VALUES (?, ?, ?, ?)");
		history.setInt(1, bookingID);
		history.setInt(2, 2); // cancel
		history.setInt(3, userID);
		history.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		history.executeUpdate();		
		
		// Insert new availability
		PreparedStatement infoCheck = conn.prepareStatement("SELECT startDate, endDate, rentalPrice from booking where bookingID=? and listingID=?");
		infoCheck.setInt(1, bookingID);
		infoCheck.setInt(2, listingID);
		ResultSet rs2 = infoCheck.executeQuery();
		rs2.next();
		
		Date start = rs2.getDate("startDate");
		Date end = rs2.getDate("endDate");
		int rentalPrice = rs2.getInt("rentalPrice");

		LocalDate localStart = start.toLocalDate();
		LocalDate localEnd = end.toLocalDate();

		LocalDate today = LocalDate.now();
		LocalDate laterDate;
		// If today is after the endDate, then don't make a new availability
		if (today.isAfter(localEnd))
			return;
		// The start date of the new availability should be the later of the two dates.
		if (today.isAfter(localStart))
			laterDate = today;
		else {
			laterDate = localStart;
		}
		
		Date newDate = Date.valueOf(laterDate);
		PreparedStatement dateAdd = conn.prepareStatement("INSERT INTO ListingAvailability (listingID, startDate, endDate, rentalPrice) VALUES (?, ?, ?, ?)");		
		dateAdd.setInt(1, listingID);
		dateAdd.setDate(2, newDate);
		dateAdd.setDate(3, end);
		dateAdd.setInt(4, rentalPrice);
		dateAdd.executeUpdate();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Register JDBC driver
		Class.forName(dbClassName);
		//Database credentials
		final String USER = "root";
		final String PASS = "";
		System.out.println("Connecting to database...");
		boolean quit = false;
//		Scanner scanner = new Scanner(System.in);
		int currentUserID = 1;
		int currentListingID = 1;
		try {
			//Establish connection
			conn = DriverManager.getConnection(CONNECTION,USER,PASS);
			System.out.println("Successfully connected to MySQL!");

			// Main loop.
			while (!quit)
			{
				System.out.println("Please enter a command: ");
				String input = scanner.nextLine();
				switch (input) {
				case "quit":
				case "q":
				case "exit":
					System.out.println("Goodbye");
					quit = true;
					break;
				// Lookup tables
				case "userType": // List all user types
					userType();
					break;
				case "listingType":
					listingType();
					break;
				case "listingStatus":
					listingStatus();
					break;
				case "country":
					country();
					break;
				case "province":
					province();
					break;
				case "city":
					city();
					break;
				case "amenity":
					amenity();
					break;
				// Operations
				case "create host":
					createHost();
					break;
				case "create renter":
					createRenter();
					break;
				case "users":
					users();
					break;
				case "availability":
				case "availabilities":
					listAllAvailability();
					break;
				case "all listings":
				case "listings":
					listAllListings();
					break;
				case "current user":
					System.out.println(Integer.toString(currentUserID));
					break;
				case "switch user":
					currentUserID = switchUser();
					break;
				case "delete user": // current user
					deleteUser(currentUserID);
					currentUserID = switchUser();
					break;
				case "undelete user":
					undeleteUser();
				case "create listing": 
					if (checkUserHost(currentUserID))
						createListing(currentUserID);
					else {
						System.out.println("not a host");
					}
					break;
				case "switch listing":
					currentListingID = switchListing();
					break;
				case "current listing":
					System.out.println(Integer.toString(currentListingID));
					break;
				case "list listing":
				case "list listings":
					listListings(currentUserID);
					break;
				case "list availability": // current listing
					listAvailability(currentListingID);
					break;
				case "create availability":
				case "add availability": // current listing
					if (checkUserHostOfListing(currentUserID, currentListingID))
						createAvailability(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "update availability": // current listing
					if (checkUserHostOfListing(currentUserID, currentListingID))
						updateAvailability(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "delete availability":
					if (checkUserHostOfListing(currentUserID, currentListingID))
						deleteAvailability(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "delete listing":
					if (checkUserHostOfListing(currentUserID, currentListingID))
						deleteListing(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "update listing": // only info, not location
					if (checkUserHostOfListing(currentUserID, currentListingID))
						updateListing(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "list amenity": // current listing
					listAmenity(currentListingID);
					break;
				case "update amenity": // current listing
					if (checkUserHostOfListing(currentUserID, currentListingID))
						updateAmenity(currentListingID);
					else {
						System.out.println("Not a host of the current listing.");
					}
					break;
				case "book listing": // current user must be renter and on current listing
				case "create booking":
				case "add booking":
					if (checkUserRenter(currentUserID))
						bookListing(currentListingID, currentUserID);
					else {
						System.out.println("Not a renter.");
					}
					break;
				case "cancel booking":
					if (checkUserRenter(currentUserID)) // renter cancel: has booked?
					{
						if (checkUserBookedListing(currentUserID, currentListingID))
							cancelBookingByRenter(currentUserID, currentListingID);
						else {
							System.out.println("You don't have a pending booking for this listing.");
						}
					}
					else { // host cancel: has bookings?
						cancelBookingByHost(currentUserID, currentListingID);
					}
					break;
				case "occupy booking":
					break;
				case "list bookings listing":
					listBookingsByListing(currentListingID);
					break;
				case "list bookings user":
					listBookingsByUser(currentUserID);
					break;
				case "add comment":
					break;
				case "search listing":
					break;
				// Reports
				case "report total bookings date city":
					break;
				case "report total bookings date city postalcode":
					break;
				case "report total listings country province city":
					break;
				case "report total listings country province city postalcode":
					break;
				case "report host rank country":
					break;
				case "report host rank city":
					break;
				case "report commercial hosts": // 10%
					break;
				case "report renters rank bookings":
					break;
				case "report renters rank bookings city":
					break;
				case "report cancellations":
					break;
				case "report phrases":
					break;
				
				default:
					System.out.println("Unrecognized command.");
				}
				if (quit)
					break;
			}
			
			System.out.println("Closing connection...");
			conn.close();
			scanner.close();
			System.out.println("Success!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("Connection error occured!");
		}
	}

}