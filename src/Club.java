
public class Club {
	private static String name;
	private static String address;
	
	public Club() {
		
	}
	public Club(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Club [name=" + name + ", address=" + address + "]";
	}
	
	

}
