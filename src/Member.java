
public abstract class Member {
	private String name;
	private int id;
	
	public abstract void checkIn(Club club);
	
	public Member() {
		
	}
	
	public Member(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Members [name=" + name + ", id=" + id + "]";
	}
	
	
	
}
