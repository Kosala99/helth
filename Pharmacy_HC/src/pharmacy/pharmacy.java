package pharmacy;
import javax.xml.bind.annotation.XmlRootElement;

public class pharmacy {

	private String billNo;
	private String doctorName;
	private String patientName;
	private String date;
	private String medicationDetails;
	private String amount;
	private String email;
	private String password;
	
	public pharmacy() {
		
	}
	
	public pharmacy(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public pharmacy(String billNo, String doctorName, String patientName, String date, String medicationDetails,String amount , String email,
			String password) {
		this.billNo = billNo;
		this.doctorName = doctorName;
		this.patientName = patientName;
		this.date = date;
		this.medicationDetails = medicationDetails;
		this.amount = amount;
		this.email = email;
		this.password = password;
	}
	
	public String getBillNo() {
		return billNo;
	}
			public void setBillNo(String billNo) {
					this.billNo = billNo;
	}
	public String getDoctorName() {
		return doctorName;
	}
		public void setDoctorName(String doctorName) {
				this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
			public void setPatientName(String patientName) {
					this.patientName = patientName;
	}
	public String getDate() {
		return date;
	}
			public void setDate(String date) {
				this.date = date;
	}
	public String getMedicationDetails() {
		return medicationDetails;
	}
			public void setMedicationDetails(String medicationDetails) {
					this.medicationDetails = medicationDetails;
	}
			
	public String getAmount() {
		return amount;
	}
			public void setAmount(String amount) {
					this.amount = amount;
	}
			
	public String getEmail() {
		return email;
	}
			public void setEmail(String email) {
					this.email = email;
	}
			
	public String getPassword() {
		return password;
	}
			public void setPassword(String password) {
					this.password = password;
	}
	
}

