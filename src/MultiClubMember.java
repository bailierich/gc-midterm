
public class MultiClubMember extends Member {
	
	private int membershipPoints = 0;
	private String memberType;
	
	
	public MultiClubMember(String memberType, String name, int id, int membershipPoints) {
		super(memberType,name,id);
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


	