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
private static int idNum = 100;
//private static FileHelper<Member> helper = new FileHelper<>("members.txt", new CountryLineConverter());
//private static FileHelper<Club> helper = new FileHelper<>("club.txt", new CountryLineConverter());
static {
	initialMenu.add("New Member");
	initialMenu.add("Check A Member In");
	initialMenu.add("Generate Bill");
}
	public static void main(String[] args) {
		
	}
	private static void whichMembership() {
		String input = Validator.getString(scnr,"Which membership is needed (multi/single)?");
		if (input.equalsIgnoreCase("single")) {
			makeNewSingleMember();
		}else if (input.equalsIgnoreCase("multi")) {
			makeNewMultiMember();
		}else {
			System.out.println("Oops. Input not valid. Try Again.");
			whichMembership();
		}
	}
	
	
	private static Member makeNewSingleMember() {
		String inputMemberName = Validator.getString(scnr, "What is the members name?");
		int inputId = idNum;
		idNum++;
		String inputBirthday = Validator.getString(scnr, "What is the member birthday?");
		String clubPick = Validator.getString(scnr, "Which club does this member want to belong to?");
		return null;
		
	}
	private static Member makeNewMultiMember() {
		return null;
		
	}
}
