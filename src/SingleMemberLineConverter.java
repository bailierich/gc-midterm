import java.util.List;

public class SingleMemberLineConverter implements LineConverter<Member> {
	// TODO come back and make both single and multi member line converters 
	private List<Club> clubList;
	
	
	public SingleMemberLineConverter(List<Club> clubList) {
		super();
		this.clubList = clubList;
	}
//TODO figure out how to change this to fit both types of members
	@Override
	public String toLine(Member object) {
//		if (object.getMemberType().equalsIgnoreCase("single")) {
//		object = new SingleClubMember()
//		}
		// return object attributes separated with a delimeter
		return object.getName()+"~~~"+object.getId();
	}

	@Override
	public Member fromLine(String line) {
		Club club = null;
		// delimeter separates object's attributes
		String[] parts = line.split("~~~");
		if (parts[0].equalsIgnoreCase("single")) {
			String name = parts[1];
			int ID = Integer.parseInt(parts[2]);
		    String clubName = parts[3];
		    for(Club c: clubList) {
		    	if(c.getName().equalsIgnoreCase(clubName)) {
		    		club = c;
		    	}
		    }
			return new SingleClubMember("Single",name, ID, club);
		}else {
			String name = parts[1];
			int ID = Integer.parseInt(parts[2]);
			int membershipPoints = Integer.parseInt(parts[3]);
			return new MultiClubMember("Multi", name, ID, membershipPoints);
		}
	}

}