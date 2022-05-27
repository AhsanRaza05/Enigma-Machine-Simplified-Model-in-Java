package CompleteAccurate;

import java.util.Scanner;

/**
 * Creates an Enigma machine based on command-line arguments, and reads the message
 * from the user on STDIN. Decrypts/Encrypts using the enigma class.
 */
public class myCom {


  public static void main(String[] args) {

	  Scanner scan = new Scanner(System.in);
	  
	  System.out.print("Enter: ");
	  
	  String g[] = new String[5];
	  
	  g[0] = scan.next();
	  g[1] = scan.next();
	  g[2] = scan.next();
	  g[3] = scan.next();
	  g[4] = scan.next();
	  
    // Check for the correct # of arguments
    if( g.length != 5 || g[3].length() != 3 ) {
      System.out.println("husage: java Comms <inner#> <middle#> <outer#> \"init\" (encrypt|decrypt)");
      System.exit(1);
    }
        
    // Check for the correct 3 ints
    for( int i = 0; i < 3; i++ ) {
      if( g[i].length() != 1 || g[i].charAt(0) < '0' || g[i].charAt(0) > '9' ) {
        System.out.println("usage: java Comms <inner#> <middle#> <outer#> \"init\" (encrypt|decrypt)");
        System.exit(1);
      }
    }
    
    // Encrypt or decrypt argument
    boolean encrypt = true;
    if( g[4].equals("decrypt") )
      encrypt = false;

    // Rotors
    int id1 = Integer.parseInt(g[0]);
    int id2 = Integer.parseInt(g[1]);
    int id3 = Integer.parseInt(g[2]);
    
    // Get the message from the user, and call the appropriate method
   
    String message = scan.next();

    // Call the Enigma's constructor to build the machine
    Enigma enigma = new Enigma(id1, id2, id3, g[3]);

    // Encrypt or Decrypt
    if( encrypt )
      System.out.println(enigma.encrypt(message));
    else
      System.out.println(enigma.decrypt(message));
    
    System.out.println("THE#NATIONAL#ANIMAL#OF#SCOTLAND#IS#THE#UNICORN#MYNAME#IS#AHSAN#RAZA#I#LIKE#PROGRAMMING#AND#I#SOLVED#A#TAS#TODAY#TASK".length());
    
}
}
