
public class SingleClubMember extends Member{
	private String clubName;
	private String birthday;
	

	public SingleClubMember(String name, int id, String clubName) {
		 super(name,id);
		this.clubName = clubName;
	}



	@Override
	public void checkIn(Club club) {
		if (Club.getName() != clubName) {
			//TODO make exception
		}
		
	}



	public String getClubName() {
		return clubName;
	}



	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	
	
	

}
