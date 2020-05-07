
public class SingleClubMember extends Member{
	private String clubName;

	@Override
	public void checkIn(Club club) {
		if (Club.getName() != clubName) {
			//TODO make exception
		}
		
	}
	
	
	
	

}
