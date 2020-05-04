package pharmacy.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pharmacy.pharmacy;

public class pharmacyDB {

public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacyDB", "root", "root123");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

public static String medicationRegister(pharmacy pharmacy) {
	
	String output = null;
	
	try {
		Connection con = getConnection();
		
		String query = "insert into medication_information_registration values(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ph = con.prepareStatement(query);
		
		ph.setString(1, pharmacy.getBillNo());
		ph.setString(2, pharmacy.getDoctorName());
		ph.setString(3, pharmacy.getPatientName());
		ph.setString(4, pharmacy.getDate());
		ph.setString(5, pharmacy.getMedicationDetails());
		ph.setString(6, pharmacy.getAmount());
		ph.setString(7, pharmacy.getEmail());
		ph.setString(8, pharmacy.getPassword());
		
		ph.executeUpdate();
		
		output = "medication Details Register Successfully";
		
	} catch (Exception e) {
		e.printStackTrace();
		
		output = "Error in medication registration process";
	}
	
	return output;
}

public static String pharmacyLogin(pharmacy pharmacy) {
	
	String status = "invalid user";
	
	try {
		Connection con = getConnection();
		
		String query = "select pharmacyLoginPassword from medication_information_registration where email = ?";
		
		PreparedStatement ph = con.prepareStatement(query);
		
		ph.setString(1, pharmacy.getEmail());
		
		ResultSet rs = ph.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("***");
			 if (pharmacy.getPassword() == rs.getString("pharmacyLoginPassword") ) {
				 status = "valid user";
			 }
		}
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return status;
}

public static String updatePharmacyDetails(pharmacy pharmacy) {
	String status = null;
	
	try {
		Connection con = getConnection();
		
		String queary = "update medication_information_registration set billNo=?, doctorName=?, patientName=?, date=?, medicationDetails=?, amount=?,"
				+ "email=?, pharmacyLoginPassword=? where billNo=?";
		
		PreparedStatement ph = con.prepareStatement(queary);
		
		ph.setString(1, pharmacy.getBillNo());
		ph.setString(2, pharmacy.getDoctorName());
		ph.setString(3, pharmacy.getPatientName());
		ph.setString(4, pharmacy.getDate());
		ph.setString(5, pharmacy.getMedicationDetails());
		ph.setString(6, pharmacy.getAmount());
		ph.setString(7, pharmacy.getEmail());
		ph.setString(8, pharmacy.getPassword());
	
		ph.executeUpdate();
		
		status = "Medication Details Update Successfully";
	} catch (Exception e) {
		e.printStackTrace();
		status = "Error in the update process";
	}
	
	return status;
}

public static String deletePharmacyDetails(pharmacy pharmacy) {
	String status = null;
	
	try {
		Connection con = getConnection();
		
		String query = "delete from medication_information_registration where billNo=?";
		
		PreparedStatement ph = con.prepareStatement(query);
		
		ph.setString(1, pharmacy.getBillNo());
		
		ph.execute();
		
		status = "Medication Details deleted successfuly";
	} catch (Exception e) {
		
		e.printStackTrace();
		status = "Error in the delete process";
	}
	
	return status;
	
}

public static String medicationList() {
	
	String output = "";
	
	try {
		Connection con = getConnection();
		
		output += "<head>\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n" + 
				"integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
				"</head>" + 
				"<body>" +
				"<table border=\"1\"><tr><th>Bill No</th>" + "<th>Doctor Name</th>"+"<th>Patient Name</th>" + "<th>Date</th>" +
				"<th>Medication Details</th>" +"<th>Amount</th>"+ "<th>Email</th>" + "<th>Password</th>" + "</body>";
		
		String query = "select * from medication_information_registration";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			String billNo = rs.getString("billNo");
			String doctorName = rs.getString("doctorName");
			String patientName = rs.getString("patientName");
			String date = rs.getString("date");
			String medicationDetails = rs.getString("medicationDetails");
			String amount = rs.getString("amount");
			String email = rs.getString("email");
			String password = rs.getString("Password");
			
			output += "<tr><td>" + billNo + "</td>";
			output += "<td>" + doctorName + "</td>";
			output += "<td>" + patientName + "</td>";
			output += "<td>" + date + "</td>";
			output += "<td>" + medicationDetails + "</td>";
			output += "<td>" + amount + "</td>";
			output += "<td>" + email + "</td>";
			output += "<td>" + password + "</td>";
			
			output += "</tr></table>";
		}
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return output;
}


}
