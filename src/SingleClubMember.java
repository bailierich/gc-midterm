
public class SingleClubMember extends Member{
	private Club clubName;
	private String birthday;
	
	





	public SingleClubMember() {
		
	}
	

	public SingleClubMember(String memberType, String name, int id, Club clubName) {
		 super(memberType,name,id);
		this.clubName = clubName;
	}



	@Override
	public void checkIn(Club club) {
		if (club.getName() != clubName.getName()) {
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
