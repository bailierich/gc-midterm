
public class MultiClubMember extends Member {
	
	private int membershipPoints = 0;
	private String memberType;
	private String birthday;
	
	
	public MultiClubMember(String memberType, String name, int id, String birthday, int membershipPoints) {
		super(memberType,name,id);
		this.membershipPoints = membershipPoints;
		this.birthday = birthday;

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


	