import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//import lab17.Country;
//import lab17.CountryLineConverter;
//import lab17.FileHelper;

public class FitnessCenter {

	private static Scanner scnr = new Scanner(System.in);
	private static List<String> initialMenu = new ArrayList<>();
	private static List<Member> memberList = new ArrayList<>();
	private static List<Club> clubList = new ArrayList<>();

	private static int idNum = 100;
	private static FileHelper<Member> helper = new FileHelper<>("members.txt", new SingleMemberLineConverter(clubList));
//private static FileHelper<Club> helper = new FileHelper<>("club.txt", new CountryLineConverter());
	static {
		initialMenu.add("New Member");
		initialMenu.add("Check A Member In");
		initialMenu.add("Generate Bill");

		clubList.add(new Club("Detroit", "1570 Woodward Ave floor 3, Detroit, MI 48226"));
		clubList.add(new Club("Grand Rapids", "40 Pearl St NW #200, Grand Rapids, MI 49503"));
		clubList.add(new Club("Royal Oak", "1455 Main St., Royal Oak, MI"));
		clubList.add(new Club("West Bloomfeild", "2324 Main St., West Bloomfield, MI"));

	}

	public static void main(String[] args) {
		printMenu();

	}

	private static void whichMembership() {
		String input = Validator.getString(scnr, "Which membership is needed (multi/single)?");
		if (input.equalsIgnoreCase("single")) {
			makeNewSingleMember();
		} else if (input.equalsIgnoreCase("multi")) {
			makeNewMultiMember();
		} else {
			System.out.println("Oops. Input not valid. Try Again.");
			whichMembership();
		}
	}

	private static void printMenu() {
		for (int i = 0; i < initialMenu.size(); i++) {
			System.out.println((i + 1) + " " + initialMenu.get(i));
		}

		int choice = ValidatorHelper.getInt(scnr, "What would you like to do?", 1, 3);
		if (choice == 1) {
			whichMembership();
			printMenu();
		} else if (choice == 2) {
			memberCheckIn();
			printMenu();
		}
	}

	private static Member makeNewSingleMember() {
		String inputMemberName = Validator.getString(scnr, "What is the members name?");
		int inputId = idNum;
		idNum++;
		String inputBirthday = Validator.getString(scnr, "What is the member birthday?");
		Club clubPick = clubSelector();
		SingleClubMember newClubMember = new SingleClubMember("SINGLE", inputMemberName, inputId, inputBirthday,
				clubPick);
		memberList.add(newClubMember);
		helper.append(newClubMember);
		return newClubMember;
	}

	public static Club clubSelector() {

		for (int i = 0; i < clubList.size(); i++) {
			System.out.println((i + 1) + " " + clubList.get(i).getName());
		}
		int input = ValidatorHelper.getInt(scnr, "Which club does this member want to belong to?", 1, clubList.size());
		for (int i = 0; i < clubList.size(); i++) {
			if (i + 1 == input) {
				return clubList.get(i);
			}
		}
		return null;
	}

	private static Member makeNewMultiMember() {
		String inputMemberName = Validator.getString(scnr, "What is the members name?");
		int inputId = idNum;
		idNum++;
		String inputBirthday = Validator.getString(scnr, "What is the member birthday?");
		int MembershipPoints = 0;
		MultiClubMember newClubMember = new MultiClubMember("MULTI", inputMemberName, inputId, inputBirthday,
				MembershipPoints);
		memberList.add(newClubMember);
		helper.append(newClubMember);
		return newClubMember;

	}

	private static void memberCheckIn() {
		String input = Validator.getString(scnr, "Which member is checking in (name)?");
		String currentClub = Validator.getString(scnr, "What club is the member checking into?");
		for (Member m : memberList) {
			String memType = m.getMemberType();
			if (memType.equalsIgnoreCase("single")) {
				for (Club c : clubList) {
					if (c.getName().equals(currentClub)) {
						m.checkIn(c);
					} else {
						System.out.println(" Error. " + m.getName() + " can only check in at "
								+ ((SingleClubMember) m).getClubName() + ". ");
					}
				}

			} else {
				for (Club c : clubList) {
					if (c.getName().equals(currentClub)) {
						m.checkIn(c);
					}
				}
			}

		}

	}
	
	private static void printBill() {
		String memberName = Validator.getString(scnr, "Which member account would you like to print a bill for?");
		
	}
}
