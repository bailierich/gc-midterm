
public class SingleClubMember extends Member{
	private Club clubName;
	private String birthday;
	

	public SingleClubMember(String name, int id, Club clubName) {
		 super(name,id);
		this.clubName = clubName;
	}



	@Override
	public void checkIn(Club club) {
		if (Club.getName() != clubName.getName()) {
			//TODO make exception
		}
		
	}



	public String getClubName() {
		return clubName.getName();
	}



	public void setClubName(Club clubName) {
		this.clubName = clubName;
	}
	
	
	
	

}
