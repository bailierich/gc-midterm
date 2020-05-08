import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessCenter {

	private static Scanner scnr = new Scanner(System.in);
	private static List<String> initialMenu = new ArrayList<>();
	private static List<Member> memberList = new ArrayList<>();
	private static List<Club> clubList = new ArrayList<>();

	private static int idNum = 100;
	private static FileHelper<Member> helper = new FileHelper<>("members.txt", new MemberLineConverter(clubList));
	private static FileHelper<Club> clubHelper = new FileHelper<>("club.txt", new ClubLineConverter());
	static {
		initialMenu.add("New Member");
		initialMenu.add("Check A Member In");
		initialMenu.add("Generate Bill");
		initialMenu.add("Remove member");
		initialMenu.add("Get Member Information");
		initialMenu.add("Quit");

		clubList.add(new Club("Detroit", "1570 Woodward Ave floor 3, Detroit, MI 48226"));
		clubList.add(new Club("Grand Rapids", "40 Pearl St NW #200, Grand Rapids, MI 49503"));
		clubList.add(new Club("Royal Oak", "1455 Main St., Royal Oak, MI"));
		clubList.add(new Club("West Bloomfeild", "2324 Main St., West Bloomfield, MI"));

	}

	public static void main(String[] args) {
		memberList = helper.readAll();// Refills this list with current values from file
		clubHelper.rewrite(clubList); // this prints the current club list to a file
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

		int choice = ValidatorHelper.getInt(scnr, "What would you like to do?", 1, 6);
		if (choice == 1) {
			whichMembership();
			printMenu();
		} else if (choice == 2) {
			memberCheckIn();
			printMenu();
		} else if (choice == 3) {
			printBill();
			printMenu();
		} else if (choice == 4) {
			removeMember();
			printMenu();
		} else if (choice == 5) {
			printMemberInfo();
			printMenu();
		} else {
			System.out.println("Goodbye!");
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
		System.out.println("New Member Created.");
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
		System.out.println("New Member Created.");
		return newClubMember;

	}

	private static void memberCheckIn() {
		String input = Validator.getString(scnr, "Which member is checking in (name)?");
		String currentClub = Validator.getString(scnr, "What club is the member checking into?");

		for (int i = 0; i < memberList.size(); i++) {
			if (input.equalsIgnoreCase(memberList.get(i).getName())) {
				String memType = memberList.get(i).getMemberType();
				if (memType.equalsIgnoreCase("single")) {
					SingleClubMember a = (SingleClubMember) memberList.get(i);
					for (Club c : clubList) {
						if (a.getClubName().equalsIgnoreCase(currentClub)) {
							a.checkIn(c);
						} else {
							System.out.println(
									" Error. " + a.getName() + " can only check in at " + (a.getClubName() + ". "));
							return;
						}
					}
				} else {
					for (Club c : clubList) {
						if (c.getName().equalsIgnoreCase(currentClub)) {
							MultiClubMember b = (MultiClubMember) memberList.get(i);
							int Points = b.getMembershipPoints() + 10;
							b.setMembershipPoints(Points);
							b.checkIn(c);
							helper.rewrite(memberList);
							return;
						}
					}
				}
			} else {
					System.out.println("Member doesn't exist.");
					memberCheckIn();
			}
		}
	}

	

	private static void printBill() {
		String memberName = Validator.getString(scnr, "Which member account would you like to print a bill for?");

		for (Member m : memberList) {
			if (memberName.equalsIgnoreCase(m.getName())) {
				m.printBill();
				return;
			} else {
				System.out.println("Member doesn't exist.");
				printBill();
			}
		}
	}

	private static void removeMember() {
		System.out.println();
		int input;

		for (int index = 0; index < memberList.size(); index++) {
			System.out.println((index + 1) + " - " + memberList.get(index));
		}
		System.out.println();
		input = ValidatorHelper.getInt(scnr, "\nWhich Member would you like to remove?");
		memberList.remove(input - 1);
		helper.rewrite(memberList);
		System.out.println("Member has been removed.");
	}

	private static void printMemberInfo() {
		String input = Validator.getString(scnr, "Which member's information would you like to display?");

		for (Member m : memberList) {
			if (m.getName().equalsIgnoreCase(input)) {
				System.out.println(m);
				
			}else {
				System.out.println("Member doesn't exist.");
				printMemberInfo();
			}
			return;
		}
	}
}
