
public class MultiClubMember extends Member {
	
	private int membershipPoints = 0;
	
	
	public MultiClubMember(int membershipPoints, String name, int id) {
		super(name,id);
		this.membershipPoints = membershipPoints;
	}


	@Override
	public void checkIn(Club club) {
		membershipPoints = membershipPoints + 10;	
	}


	public int getMembershipPoints() {
		return membershipPoints;
	}


	public void setMembershipPoints(int membershipPoints) {
		this.membershipPoints = membershipPoints;
	}

}
