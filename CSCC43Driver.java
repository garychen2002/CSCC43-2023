package cscc43project;

import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	public static void searchListingsFiltered(ArrayList<Integer> ids) throws SQLException // IDs to search from
	{
		int distance = 15000; // default distance = 15 km = 15000 meter
		PreparedStatement stmt;
		ArrayList<Integer> newIDs = new ArrayList<Integer>();
		ResultSet rs;
		ResultSetMetaData rsmd;
		boolean resultsFound = false;
		int columns;
		System.out.println("Choose additional filters: distance, address, date, amenity, postal code, price range, order by price ascending, order by price descending");
		String input = scanner.nextLine();
		switch (input) {
		case "ascending":
		case "order by price ascending":
			stmt = conn.prepareStatement("SELECT la.rentalPrice, la.startDate, la.endDate, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE FIND_IN_SET (l.listingID,?) ORDER BY rentalPrice ASC");
			stmt.setString(1, ids.stream().map(Object::toString).collect(Collectors.joining(",")));
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "descending":
		case "order by price descending":
			stmt = conn.prepareStatement("SELECT la.rentalPrice, la.startDate, la.endDate, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE FIND_IN_SET (l.listingID,?) ORDER BY rentalPrice DESC");
			stmt.setString(1, ids.stream().map(Object::toString).collect(Collectors.joining(",")));
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		
		case "distance":
			System.out.println("Specify latitude");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid: Not a number");
				scanner.nextLine();
				return;
			}
			double latitude = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Specify longitude");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid: Not a number");
				scanner.nextLine();
				return;
			}
			double longitude = scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Specify distance in kilometres or leave blank for default 15km");
			
			String distanceinput = scanner.nextLine();
			if (distanceinput.equals(""))
				distance = 15000;
			else {
				try {
					distance = Integer.parseInt(distanceinput);
				} catch (Exception e) {
					System.out.println("Invalid input: Not a number");
					return;
				}
			}
			stmt = conn.prepareStatement("SELECT concat(ST_DISTANCE(ST_GeomFromText(?, 4326), coordinates, 'metre'), ' metres') as distance, listingID, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "FROM Listing l inner join ListingType lt inner join City c inner join Users u on l.hostID=u.uID "
					+ "WHERE l.typeID = lt.typeID and l.cityID=c.cityID and ST_DISTANCE(ST_GeomFromText(?, 4326), coordinates, 'metre') < ? and FIND_IN_SET (l.listingID,?)"
					+ " ORDER BY distance");
			stmt.setString(1, "POINT(" + Double.toString(latitude) + " " + Double.toString(longitude) + ")");
			stmt.setString(2, "POINT(" + Double.toString(latitude) + " " + Double.toString(longitude) + ")");
			stmt.setInt(3, distance);
			stmt.setString(4, ids.stream().map(Object::toString).collect(Collectors.joining(",")));
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "address":
			System.out.println("Enter exact address: ");
			String address = scanner.nextLine();
			stmt = conn.prepareStatement("SELECT l.address, listingID, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, c.name as city, l.postalCode, description "
					+ "FROM Listing l inner join ListingType lt inner join City c inner join Users on l.hostID=u.uID"
					+ "WHERE l.typeID = lt.typeID and l.cityID=c.cityID and l.address=? and FIND_IN_SET (l.listingID,?)");
			stmt.setString(1, address);
			stmt.setString(2, ids.stream().map(Object::toString).collect(Collectors.joining(",")));

			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "date range":
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
			
			stmt = conn.prepareStatement("SELECT la.startDate, la.endDate, la.rentalPrice, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE startDate >= ? and endDate <= ? and FIND_IN_SET (l.listingID,?)"
					+ " ORDER BY startDate");	
			stmt.setDate(1, Date.valueOf(startDate));
			stmt.setDate(2, Date.valueOf(endDate));
			stmt.setString(3, ids.stream().map(Object::toString).collect(Collectors.joining(",")));

			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "amenity":
			System.out.println("Enter an amenity you want to filter by: ");
			String amenity = scanner.nextLine();
			int amenityID = validateAmenity(amenity);
			if (amenityID == -1)
			{
				System.out.println("Invalid amenity");
				return;
			}
			stmt = conn.prepareStatement("SELECT  l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join City c inner join ListingType lt inner join Users u inner join ListingAmenities las on l.hostID=u.uID and l.listingID=las.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE amenityID=? and FIND_IN_SET (l.listingID,?)");	
			stmt.setInt(1, amenityID);
			stmt.setString(2, ids.stream().map(Object::toString).collect(Collectors.joining(",")));

			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "postal":
		case "postal code":
		case "postalcode":
			System.out.println("Enter postal/zip code (XXX YYY or ZZZZZ)");
			String postalCode = scanner.nextLine();
			int firstPart = Integer.min(postalCode.length(), 4);
			stmt = conn.prepareStatement("SELECT  l.postalCode, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, description "
					+ "from Listing l inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE l.postalcode like ? and FIND_IN_SET (l.listingID,?)");	
			stmt.setString(1, postalCode.substring(0, firstPart)+"%");
			stmt.setString(2, ids.stream().map(Object::toString).collect(Collectors.joining(",")));

			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
		case "price range":
			System.out.println("Enter minimum price");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid input: Not a number");
				scanner.nextLine();
				return;
			}
			double minPrice = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter maximum price");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid input: Not a number");
				scanner.nextLine();
				return;
			}
			double maxPrice = scanner.nextDouble();
			scanner.nextLine();
			
			stmt = conn.prepareStatement("SELECT la.rentalPrice, la.startDate, la.endDate, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE rentalPrice >= ? and rentalPrice <= ? and FIND_IN_SET (l.listingID,?)"
					+ " ORDER BY rentalPrice");			
			stmt.setDouble(1, minPrice);
			stmt.setDouble(2, maxPrice);
			stmt.setString(3, ids.stream().map(Object::toString).collect(Collectors.joining(",")));

			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						newIDs.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(newIDs);
			else
				System.out.println("No results found.");
			break;
			
		case "quit":
			break;
		default:
			System.out.println("Unrecognized option.");
		}
	}
	
	public static void searchListings() throws SQLException {
		int distance = 15000; // default distance = 15 km = 15000 meter
		PreparedStatement stmt;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columns;
		boolean resultsFound = false;
		System.out.println("Search by: distance, address, date range, amenity, postal code, price range?");
		String input = scanner.nextLine();
		switch (input) {
		case "distance":
			System.out.println("Specify latitude");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid: Not a number");
				scanner.nextLine();
				return;
			}
			double latitude = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Specify longitude");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid: Not a number");
				scanner.nextLine();
				return;
			}
			double longitude = scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Specify distance in kilometres or leave blank for default 15km");
			
			String distanceinput = scanner.nextLine();
			if (distanceinput.equals(""))
				distance = 15000;
			else {
				try {
					distance = Integer.parseInt(distanceinput);
				} catch (Exception e) {
					System.out.println("Invalid input: Not a number");
					return;
				}
			}
			stmt = conn.prepareStatement("SELECT concat(ST_DISTANCE(ST_GeomFromText(?, 4326), coordinates, 'metre'), ' metres') as distance, listingID, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "FROM Listing l inner join ListingType lt inner join City c inner join Users u on l.hostID=u.uID "
					+ "WHERE l.typeID = lt.typeID and l.cityID=c.cityID and ST_DISTANCE(ST_GeomFromText(?, 4326), coordinates, 'metre') < ?"
					+ " ORDER BY distance");
			stmt.setString(1, "POINT(" + Double.toString(latitude) + " " + Double.toString(longitude) + ")");
			stmt.setString(2, "POINT(" + Double.toString(latitude) + " " + Double.toString(longitude) + ")");
			stmt.setInt(3, distance);
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "address":
			System.out.println("Enter exact address: ");
			String address = scanner.nextLine();
			stmt = conn.prepareStatement("SELECT l.address, listingID, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, c.name as city, l.postalCode, description "
					+ "FROM Listing l inner join ListingType lt inner join City c inner join Users on l.hostID=u.uID"
					+ "WHERE l.typeID = lt.typeID and l.cityID=c.cityID and l.address=?");
			stmt.setString(1, address);
			
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "date range":
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
			
			stmt = conn.prepareStatement("SELECT la.startDate, la.endDate, la.rentalPrice, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE startDate >= ? and endDate <= ? ORDER BY startDate");	
			stmt.setDate(1, Date.valueOf(startDate));
			stmt.setDate(2, Date.valueOf(endDate));
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "amenity":
			System.out.println("Enter an amenity you want to filter by: ");
			String amenity = scanner.nextLine();
			int amenityID = validateAmenity(amenity);
			if (amenityID == -1)
			{
				System.out.println("Invalid amenity");
				return;
			}
			stmt = conn.prepareStatement("SELECT  l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join City c inner join ListingType lt inner join Users u inner join ListingAmenities las on l.hostID=u.uID and l.listingID=las.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE amenityID=?");	
			stmt.setInt(1, amenityID);
			
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "postal":
		case "postal code":
		case "postalcode":
			System.out.println("Enter postal/zip code (XXX YYY or ZZZZZ)");
			String postalCode = scanner.nextLine();
			int firstPart = Integer.min(postalCode.length(), 4);
			stmt = conn.prepareStatement("SELECT  l.postalCode, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, description "
					+ "from Listing l inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE l.postalcode like ?");	
			stmt.setString(1, postalCode.substring(0, firstPart)+"%");
			
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "price range":
			System.out.println("Enter minimum price");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid input: Not a number");
				scanner.nextLine();
				return;
			}
			double minPrice = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter maximum price");
			if (!scanner.hasNextDouble())
			{
				System.out.println("Invalid input: Not a number");
				scanner.nextLine();
				return;
			}
			double maxPrice = scanner.nextDouble();
			scanner.nextLine();
			
			stmt = conn.prepareStatement("SELECT la.rentalPrice, la.startDate, la.endDate, l.listingID, l.title, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(coordinates) as latitude, ST_Longitude(coordinates) as longitude, l.address, c.name as city, l.postalCode, description "
					+ "from Listing l inner join ListingAvailability la inner join City c inner join ListingType lt inner join Users u on l.hostID=u.uID and l.listingID=la.listingID and c.cityID=l.cityID and lt.typeID=l.typeID"
					+ " WHERE rentalPrice >= ? and rentalPrice <= ? ORDER BY rentalPrice");			
			stmt.setDouble(1, minPrice);
			stmt.setDouble(2, maxPrice);
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();
			columns = rsmd.getColumnCount();
			while(rs.next()){
				resultsFound = true;
				for (int i = 1; i <= columns; i++)
				{
					if (i > 1)
						System.out.print(", ");
					String value = rs.getString(i);
					if (rsmd.getColumnLabel(i).equals("listingID"))
					{
						ids.add(Integer.valueOf(value));
					}
					System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
				}
				System.out.println("");
			}
			if (resultsFound)
				searchListingsFiltered(ids);
			else
				System.out.println("No results found.");
			break;
		case "quit":
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
		System.out.println("Enter price (number without dollar sign)");
		if (!scanner.hasNextDouble())
		{
			System.out.println("Invalid Input: Not a number");
			scanner.nextLine();
			return;
		}
		double price = scanner.nextDouble();
		scanner.nextLine();
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ListingAvailability(listingID, startDate, endDate, rentalPrice) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, listingID);
		stmt.setString(2, startDate);
		stmt.setString(3, endDate);
		stmt.setDouble(4, price);
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
		System.out.println("Enter price (without dollar sign)");
		if (!scanner.hasNextDouble())
		{
			System.out.println("Invalid Input: Not a number");
			scanner.nextLine();
			return;
		}
		double price = scanner.nextDouble();
		scanner.nextLine();
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE ListingAvailability set startDate=?, endDate=?, rentalPrice=? where availabilityID = ?", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
		stmt.setDouble(3, price);
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
		PreparedStatement stmt = conn.prepareStatement("SELECT listingID, concat(u.firstname, ' ', u.lastname) as host, title, lt.name as type, ST_Latitude(l.coordinates) as latitude, ST_Longitude(l.coordinates) as longitude, l.address, c.name as city, l.postalCode, description FROM Listing l inner join ListingType lt inner join City c inner join Users u on l.hostID=u.uID WHERE hostID=? and l.typeID = lt.typeID and l.cityID=c.cityID ORDER BY listingID");
		stmt.setInt(1, uid);
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
		double rentalPrice = rs2.getDouble("rentalPrice");

		
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
			reinsert.setDouble(4,rentalPrice);
			reinsert.executeUpdate();
		}
		else if (!startEqual && endEqual) // availability from old start to new start -1
		{
			reinsert.setInt(1, listingID);
			reinsert.setString(2, availabilityStartDateString);
			reinsert.setString(3, startNew.toString());
			reinsert.setDouble(4,rentalPrice);
			reinsert.executeUpdate();
		}
		else // both unequal: reinsert 2 new availability from old start to new start -1, new end+1 to old end
		{
			// start
			reinsert.setInt(1, listingID);
			reinsert.setString(2, availabilityStartDateString);
			reinsert.setString(3, startNew.toString());
			reinsert.setDouble(4,rentalPrice);
			reinsert.executeUpdate();
			// end
			reinsert.setInt(1, listingID);
			reinsert.setString(2, endNew.toString());
			reinsert.setString(3, availabilityEndDateString);
			reinsert.setDouble(4,rentalPrice);
			reinsert.executeUpdate();
		}
		
		PreparedStatement booking = conn.prepareStatement("INSERT INTO Booking (renterID, listingID, startDate, endDate, rentalPrice, statusID) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		booking.setInt(1, renterID);
		booking.setInt(2,listingID);
		booking.setString(3, start.toString());
		booking.setString(4, end.toString());
		booking.setDouble(5, rentalPrice);
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
	
	public static void listBookingsForHost(int userID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, concat(u.firstname, ' ', u.lastname) as name, b.listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls inner join Listing l inner join Users u where b.statusID=ls.statusID and b.listingID=l.listingID and l.hostID=? and u.uID=b.renterID");
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
	
	public static void listBookedBookingsByUser(int userID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT bookingID, renterID, listingID, startDate, endDate, rentalPrice, ls.name as status from Booking b inner join ListingStatus ls where b.statusID=ls.statusID and renterID=? and b.statusID=1");
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
		double rentalPrice = rs2.getDouble("rentalPrice");

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
		dateAdd.setDouble(4, rentalPrice);
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
		
		System.out.println("Successfully cancelled booking.");
		
		// Insert new availability
		PreparedStatement infoCheck = conn.prepareStatement("SELECT startDate, endDate, rentalPrice from booking where bookingID=? and listingID=?");
		infoCheck.setInt(1, bookingID);
		infoCheck.setInt(2, listingID);
		ResultSet rs2 = infoCheck.executeQuery();
		rs2.next();
		
		Date start = rs2.getDate("startDate");
		Date end = rs2.getDate("endDate");
		double rentalPrice = rs2.getDouble("rentalPrice");

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
		dateAdd.setDouble(4, rentalPrice);
		dateAdd.executeUpdate();
		
		System.out.println("Successfully updated availability.");

	}
	
	public static void occupyBooking(int userID, int listingID) throws SQLException {
		listBookedBookingsByUserAndListing(userID, listingID); // Display relevant bookings
		System.out.println("Enter the booking ID to occupy: ");
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
		// Set occupied.
		PreparedStatement occupy = conn.prepareStatement("UPDATE Booking SET statusID=4 where bookingID=?");
		occupy.setInt(1, bookingID);
		occupy.executeUpdate();
		
		// Insert history value
		PreparedStatement history = conn.prepareStatement("INSERT INTO BookingHistory (bookingID, statusID, eventBy, eventDateTime) VALUES (?, ?, ?, ?)");
		history.setInt(1, bookingID);
		history.setInt(2, 4); // occupy
		history.setInt(3, userID);
		history.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		history.executeUpdate();					
		
		System.out.println("Successfully occupied! Enjoy your stay.");
	}
	
	public static void addCommentByHost (int userID) throws SQLException {
		// find all bookings for all listings by this host: joins
		listBookingsForHost(userID);
		System.out.println("Enter the booking ID to review: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int bookingID = scanner.nextInt();
		scanner.nextLine();
		
		// Validate bookingID is valid for the renter/listing
		PreparedStatement idCheck = conn.prepareStatement("SELECT bookingID from booking b inner join listing l where bookingID = ? and b.listingID = l.listingID and l.hostID=?");
		idCheck.setInt(1, bookingID);
		idCheck.setInt(2, userID);
		ResultSet rs = idCheck.executeQuery();
		if (!rs.next())
		{
			System.out.println("Invalid ID");
			return;
		}
		System.out.println("Leave a comment: ");
		String comment = scanner.nextLine();
		System.out.println("Rate the renter from 1 to 5 stars: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid input: Not a number");
			scanner.nextLine();
			return;
		}
		int experienceRating = scanner.nextInt();
		scanner.nextLine();
		if (experienceRating < 1 || experienceRating > 5)
		{
			System.out.println("rating out of bounds");
			return;
		}
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO RenterReview (bookingID, rating, comment) VALUES (?, ?, ?)");
		stmt.setInt(1, bookingID);
		stmt.setInt(2, experienceRating);
		stmt.setString(3, comment);
		stmt.executeUpdate();
		System.out.println("Rating sent!");
		
	}
	
	public static void addCommentByRenter (int userID) throws SQLException {
		listBookingsByUser(userID); // Display relevant bookings
		System.out.println("Enter the booking ID to review: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int bookingID = scanner.nextInt();
		scanner.nextLine();
		
		// Validate bookingID is valid for the renter/listing
		PreparedStatement idCheck = conn.prepareStatement("SELECT bookingID from booking where bookingID = ? and renterID = ?");
		idCheck.setInt(1, bookingID);
		idCheck.setInt(2, userID);
		ResultSet rs = idCheck.executeQuery();
		if (!rs.next())
		{
			System.out.println("Invalid ID");
			return;
		}
		
		System.out.println("Leave a comment: ");
		String comment = scanner.nextLine();
		System.out.println("Rate the experience from 1 to 5 stars: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid input: Not a number");
			scanner.nextLine();
			return;
		}
		int experienceRating = scanner.nextInt();
		scanner.nextLine();
		if (experienceRating < 1 || experienceRating > 5)
		{
			System.out.println("rating out of bounds");
			return;
		}
		System.out.println("Rate the host from 1 to 5 stars: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid input: Not a number");
			scanner.nextLine();
			return;
		}
		int hostRating = scanner.nextInt();
		scanner.nextLine();
		if (hostRating < 1 || hostRating > 5)
		{
			System.out.println("rating out of bounds");
			return;
		}
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ListingReview (bookingID, comment, experienceRating, hostRating) VALUES (?, ?, ?, ?)");
		stmt.setInt(1, bookingID);
		stmt.setString(2, comment);
		stmt.setInt(3, experienceRating);
		stmt.setInt(4, hostRating);
		stmt.executeUpdate();
		System.out.println("Rating sent!");
		
	}
	
	public static void listCommentsForUser() throws SQLException {
		System.out.println("Enter the user ID to review: ");
		if (!scanner.hasNextInt())
		{
			System.out.println("Invalid ID: Not a number");
			scanner.nextLine();
			return;
		}
		int userID = scanner.nextInt();
		scanner.nextLine();
		
		if (checkUserRenter(userID))
		{
			System.out.println("Showing reviews for renter:");
			PreparedStatement stmt = conn.prepareStatement("SELECT rr.* from RenterReview rr inner join Booking b where rr.bookingID=b.bookingID and b.renterID=?");
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
		else // host
		{
			System.out.println("Showing reviews for host:");
			PreparedStatement stmt = conn.prepareStatement("SELECT l.listingID, l.title, lr.* from ListingReview lr inner join Booking b inner join Listing l where lr.bookingID=b.bookingID and b.listingID=l.listingID and l.hostID=?");
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
	}
	
	public static void listCommentsForListing(int listingID) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT lr.* from ListingReview lr inner join Booking b where lr.bookingID=b.bookingID and b.listingID=?");
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
	
	public static void reportTotalBookingsDateCity() throws SQLException {
		// Provide a date range
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
		
		PreparedStatement stmt = conn.prepareStatement("SELECT c1.name, count(b1.bookingID) as bookings from booking b1 inner join listing l1 "
				+ "on l1.listingID=b1.listingID inner join city c1 on c1.cityID=l1.cityID "
				+ " WHERE b1.startDate >= ? and b1.endDate <= ?"
				+ " group by c1.name"
				+ " order by count(b1.bookingID) desc");
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
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
	
	public static void reportTotalBookingsDateCityPostalCode() throws SQLException {
		// Limitation: have to provide country, province, and city to get the exact city
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

		// Provide a date range
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
		
		
		PreparedStatement stmt = conn.prepareStatement("SELECT l1.postalCode, count(b1.bookingID) as bookings from booking b1 inner join listing l1 "
				+ "on l1.listingID=b1.listingID inner join city c1 on c1.cityID=l1.cityID "
				+ " WHERE b1.startDate >= ? and b1.endDate <= ?"
				+ " group by l1.postalCode"
				+ " order by count(b1.bookingID) desc");
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
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
	
	public static void reportTotalListingsCountry() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select c.name as country, count(l1.listingID) from listing l1 "
				+ "inner join city c1 on c1.cityID=l1.cityID inner join province p1 on p1.provinceID=c1.provinceID inner join country c on c.countryID=p1.countryID "
				+ " group by c.name"
				+ " order by count(l1.listingID) desc");
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
	
	public static void reportTotalListingsCountryCity() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select c1.name as city, count(l1.listingID) "
				+ "from listing l1 inner join city c1 on c1.cityID=l1.cityID "
				+ "group by c1.name order by count(l1.listingID) desc");
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
	
	public static void reportTotalListingsCountryCityPostalCode() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select l1.postalCode, count(l1.listingID) from listing l1 group by l1.postalCode "
				+ " order by count(l1.listingID)");
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
	
	public static void reportHostsListingsCountry() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select u1.firstName, u1.lastName, c2.name as country, count(l1.listingID) "
				+ "from users u1 inner join listing l1 on l1.hostID=u1.uID "
				+ "inner join city c1 on c1.cityID=l1.cityID "
				+ "inner join province p1 on p1.provinceID=c1.provinceID "
				+ "inner join country c2 on c2.countryID=p1.countryID "
				+ "where u1.userTypeID=2 "
				+ "group by u1.firstName, u1.lastName, c2.name "
				+ "order by count(l1.listingID) desc");
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
	
	public static void reportHostsListingsCity() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select u1.firstName, u1.lastName, c1.name as city, count(l1.listingID) "
				+ "from users u1 inner join listing l1 on l1.hostID=u1.uID inner join city c1 on c1.cityID=l1.cityID "
				+ "where u1.userTypeID=2 group by u1.firstName, u1.lastName, c1.name "
				+ "order by count(l1.listingID) desc");
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
	
	public static void reportCommercialHosts() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select c1.cityID, c1.name as city, c2.name as country, count(l1.listingID) as count "
				+ "from listing l1 inner join city c1 on c1.cityID=l1.cityID "
				+ "inner join province p1 on p1.provinceID=c1.provinceID "
				+ "inner join country c2 on c2.countryID=p1.countryID "
				+ "group by c1.cityID, c1.name, c2.name");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		int cityID = -1;
		int count = 0;
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				if (rsmd.getColumnLabel(i).equals("cityID"))
				{
					cityID = Integer.valueOf(value);
				}
				else if (rsmd.getColumnLabel(i).equals("count"))
				{
					count = Integer.valueOf(value);
				}
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");

			double tenpercent = count / 10;
			PreparedStatement eachStmt = conn.prepareStatement("select u1.firstName, u1.lastName, count(l1.listingID) "
					+ "from users u1 inner join listing l1 on l1.hostID=u1.uID "
					+ "where u1.userTypeID=2 and l1.cityID=? "
					+ "group by u1.firstName, u1.lastName "
					+ "having count(l1.listingID)>?");
			eachStmt.setInt(1, cityID);
			eachStmt.setDouble(2, tenpercent);
			ResultSet rs2 = eachStmt.executeQuery();
			ResultSetMetaData rsmd2 = rs2.getMetaData();
			int columns2 = rsmd2.getColumnCount();
			while(rs2.next()){
				for (int j = 1; j <= columns2; j++)
				{
					if (j > 1)
						System.out.print(", ");
					String value2 = rs2.getString(j);
					System.out.print(rsmd2.getColumnLabel(j) + ": " + value2); 
				}
				System.out.println("");
			}
			System.out.println("");
		}
		rs.close();
	}
	
	public static void reportRentersBookings() throws SQLException {
		// Provide a date range
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
		
		PreparedStatement stmt = conn.prepareStatement("select u.uID, u.firstName, u.lastName, count(b.bookingID) as count "
				+ "from users u inner join booking b on b.renterID=u.uID "
				+ " where u.userTypeID=1 and b.startDate >= ? and b.endDate <= ? "
				+ " group by u.uID"
				+ " order by count(b.bookingID) desc");
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
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
	
	public static void reportRentersBookingsCity() throws SQLException {
		// at least 2 bookings in the year
		// Provide a date range
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
		
		LocalDate now = LocalDate.now();
		LocalDate pastYear = now.minusYears(1);
		Date pastYearDate = Date.valueOf(pastYear);
		
		PreparedStatement stmt = conn.prepareStatement("select u.uID, u.firstName, u.lastName, c.name as city, count(b.bookingID) as count "
				+ "from users u inner join booking b on b.renterID=u.uID inner join listing l on l.listingID=b.listingID inner join city c on c.cityID=l.cityID "
				+ " where u.userTypeID=1 and b.startDate >= ? and b.endDate <= ? and u.uID IN "
				+ " ( SELECT b.renterID from booking b where b.startDate >= ? group by b.renterID having count(b.bookingID)>=2)"
				+ " group by u.uID, c.name"
				+ " order by count(b.bookingID) desc");
		stmt.setString(1, startDate);
		stmt.setString(2, endDate);
		stmt.setDate(3, pastYearDate);
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
	
	public static void reportCancellationsHost() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select u1.firstName, u1.lastName, count(b1.bookingID) as count "
				+ " from users u1 inner join listing l1 on l1.hostID=u1.uID inner join booking b2 on b2.listingID=l1.listingID inner join bookinghistory b1 on (b1.bookingID=b2.bookingID and b1.eventBy=l1.hostID and b1.statusID=2) "
				+ " where u1.userTypeID=2 group by u1.firstName, u1.lastName "
				+ " order by count(b1.bookingID) desc");
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
	
	public static void reportCancellationsRenter() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select u1.firstName, u1.lastName, count(b1.bookingID) as count "
				+ " from users u1 inner join bookinghistory b1 on (b1.eventBy=u1.uID and b1.statusID=2) "
				+ " where u1.userTypeID=1 group by u1.firstName, u1.lastName"
				+ " order by count(b1.bookingID) desc");
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
	
	public static void reportPopularPhrases() throws SQLException {
		HashMap<String, Integer> frequencyMap = new HashMap<>();
		ArrayList<String> stopwords = new ArrayList<>(Arrays.asList("a", "the", "i", "this", "an", "and", "or", "that", "in", "on", "those", "these", "at", "is", "my", "to"));
		// for each listing
		PreparedStatement stmt = conn.prepareStatement("select l.listingID from Listing l order by listingID");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		int currentID = -1;
		while(rs.next()){
			for (int i = 1; i <= columns; i++)
			{
				if (i > 1)
					System.out.print(", ");
				String value = rs.getString(i);
				if (rsmd.getColumnLabel(i).equals("listingID"))
					currentID = Integer.valueOf(value);
				System.out.print(rsmd.getColumnLabel(i) + ": " + value); 
			}
			System.out.println("");
			frequencyMap = new HashMap<>();
			PreparedStatement stmt2 = conn.prepareStatement("SELECT comment "
					+ " from Listing l join Booking b on l.listingID=b.listingID join ListingReview lr on b.bookingID=lr.bookingID "
					+ " where l.listingID=?");
			stmt2.setInt(1,currentID);
			ResultSet rs2 = stmt2.executeQuery();
			ResultSetMetaData rsmd2 = rs2.getMetaData();
			int columns2 = rsmd2.getColumnCount();
			while(rs2.next()){
				for (int j = 1; j <= columns2; j++)
				{
					if (j > 1)
						System.out.print(", ");
					String value = rs2.getString(j);
					if (rsmd2.getColumnLabel(j).equals("comment"))
					{
					    String[] words = value.toLowerCase().split("[^a-zA-Z']+"); // split all words from comment
					    for (String word: words) { // add separately
					    	if (stopwords.contains(word))
					    		continue;
							int freq = frequencyMap.getOrDefault(word, 0); // get the current frequency or default 0
							frequencyMap.put(word, freq+1);
					    }
					}
				}

			}			
			// all comments obtained, get the top 5 words
			Set<Map.Entry<String, Integer>> entrySet = frequencyMap.entrySet();
			ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
			entryList.sort(Collections.reverseOrder(Map.Entry.<String,Integer>comparingByValue()));
			int top5 = Integer.min(5, entryList.size());
			System.out.println("Top words: ");
			for (int k = 0; k <= top5-1; k++)
			{
				System.out.println("Word: " + entryList.get(k).getKey() + ",           Value: " + entryList.get(k).getValue());
			}

			System.out.println("");
		}
		rs.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Register JDBC driver
		Class.forName(dbClassName);
		//Database credentials
		final String USER = "root";
		final String PASS = "";
		System.out.println("Connecting to database...");
		boolean quit = false;
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
					if (checkUserRenter(currentUserID)) // renter cancel: has booked?
					{
						if (checkUserBookedListing(currentUserID, currentListingID))
							occupyBooking(currentUserID, currentListingID);
						else {
							System.out.println("You don't have a pending booking for this listing.");
						}
					}
					else {
						System.out.println("Not a renter.");
					}
					break;
				case "list bookings listing":
					listBookingsByListing(currentListingID);
					break;
				case "list bookings user":
					listBookingsByUser(currentUserID);
					break;
				case "add comment":
					if (checkUserRenter(currentUserID))
						addCommentByRenter(currentUserID);
					else {
						addCommentByHost(currentUserID);
					}
					break;
				case "view comments user":
					listCommentsForUser();
					break;
				case "view comments listing":
					listCommentsForListing(currentListingID);
					break;
				// Search Queries
				case "search":
				case "search listings":
				case "search listing":
					searchListings();
					break;
				// Reports
				case "report total bookings date city":
					reportTotalBookingsDateCity();
					break;
				case "report total bookings date city postal code":
					reportTotalBookingsDateCityPostalCode();
					break;
				case "report total listings country":
					reportTotalListingsCountry();
					break;
				case "report total listings country city":
					reportTotalListingsCountryCity();
					break;
				case "report total listings country city postal code":
					reportTotalListingsCountryCityPostalCode();
					break;
				case "report host rank country":
					reportHostsListingsCountry();
					break;
				case "report host rank city":
					reportHostsListingsCity();
					break;
				case "report commercial hosts": // 10%
					reportCommercialHosts();
					break;
				case "report renters rank bookings":
					reportRentersBookings();
					break;
				case "report renters rank bookings city":
					reportRentersBookingsCity();
					break;
				case "report cancellations host":
					reportCancellationsHost();
					break;
				case "report cancellations renter":
					reportCancellationsRenter();
					break;
				case "report phrases":
					reportPopularPhrases();
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