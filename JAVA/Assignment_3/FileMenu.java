package com.Prajwal;
import Console.ConsoleInput;


public class FileMenu {

	public static void main(String[] args) {
		
		FileOperation fo = new FileOperation();
		boolean menu = true;
		
		while(menu) {
			System.out.println("1 : Encryption");
			System.out.println("2 : Decryption");
			System.out.println("3 : Exit");
			
			
			System.out.print("Enter the Choise : ");
			int choice = ConsoleInput.getInt();
			
			switch(choice) {
			
				case 1:
					fo.encryptFile();
					break;
					
				case 2:
					fo.decryptFile();
					break;
					
				case 3:
					menu = false;
					break;
					
				default:
					System.out.println("Enter The Valid Choise");
			}
		}
	}

}
