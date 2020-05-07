
public class MultiClubMember extends Member {
	
	private int membershipPoints = 0;
	
	@Override
	public void checkIn(Club club) {
		membershipPoints = membershipPoints + 10;	
	}

}
