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
	//TODO line converter delimeter
	clubList.add(new Club("Detroit", "1570 Woodward Ave floor 3, Detroit, MI 48226"));
	clubList.add(new Club("Grand Rapids", "40 Pearl St NW #200, Grand Rapids, MI 49503"));
	clubList.add(new Club("Royal Oak", "1455 Main St., Royal Oak, MI"));
	clubList.add(new Club("West Bloomfeild", "2324 Main St., West Bloomfield, MI"));
	
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
	
	private static void printMenu() {
		for (int i = 0; i < initialMenu.size(); i++) {
			System.out.println((i + 1) + " " + initialMenu.get(i));
		}
	}
	
	
	private static Member makeNewSingleMember() {
		String inputMemberName = Validator.getString(scnr, "What is the members name?");
		int inputId = idNum;
		idNum++;
		String inputBirthday = Validator.getString(scnr, "What is the member birthday?");
		Club clubPick = clubSelector();
		return null;	
	}
	
	public static Club clubSelector() {
		System.out.println("Which club does this member want to belong to?");
		for (int i = 0; i < clubList.size(); i++) {
			System.out.println((i + 1) + " " + clubList.get(i).getName());
		}
		return null;
	}
	
	private static Member makeNewMultiMember() {
		return null;
		
	}
}
