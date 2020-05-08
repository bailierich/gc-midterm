
public class SingleClubMember extends Member{
	private Club clubName;
	private String birthday;
	
	





	public SingleClubMember() {
		
	}
	

	public SingleClubMember(String memberType, String name, int id,String birthday, Club clubName) {
		 super(memberType,name,id);
		this.clubName = clubName;
		this.birthday = birthday;
	}



	@Override
	public void checkIn(Club club) {
		if (club.getName() != clubName.getName()) {
			System.out.println(" Error. " + getName() + " can only check in at " + getClubName() + ". ");
		}
		
	}



	public String getClubName() {
		return clubName.getName();
	}



	public void setClubName(Club clubName) {
		this.clubName = clubName;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	@Override
	public void printBill() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
