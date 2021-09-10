package application;

import java.util.Locale;
import java.util.Scanner;

import entitie.Room;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many room will be rented? ");
		int quantitieRooms = sc.nextInt();
		System.out.println();
		
		Room[] rooms = new Room[10];
		
		for (int i=0; i < quantitieRooms; i++) {
			System.out.printf("Rent #%d:%n", i + 1);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int roomOccupied = sc.nextInt();
			System.out.println();
			rooms[roomOccupied] = new Room(name, email);
		}
		
		System.out.println("Busy rooms:");
		for (int i=0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				System.out.printf("%d: %s%n", i, rooms[i]);
			}
		}
		
		sc.close();
	}

}
