public class SingleMemberLineConverter implements LineConverter<Member> {
	// TODO come back and make both single and multi member line converters 
	@Override
	public String toLine(Member object) {
		
		// return object attributes separated with a delimeter
		return object.getName()+","+object.getId();
	}

	@Override
	public Member fromLine(String line) {
		
		// delimeter separates object's attributes
		String[] parts = line.split(",");
		String name = parts[0];
		int ID = Integer.parseInt(parts[1]);
		String clubName = parts[2];
		return new SingleClubMember(name, ID, clubName);
	}

}