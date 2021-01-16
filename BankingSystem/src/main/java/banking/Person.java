package banking;

public class Person extends AccountHolder {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		super(idNumber);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
        return firstName;
	}

	public String getLastName() {
        return lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person person = (Person) obj;
			if(this.getIdNumber() == person.getIdNumber()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getIdNumber() + 31;
	}
}
