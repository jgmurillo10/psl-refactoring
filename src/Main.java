import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/* Constant for the lower size boundary */
	public final static int SIZE_LOWER_BOUNDARY = 1;
	/* Constant for the higher size boundary */
	public final static int SIZE_HIGHER_BOUNDARY = 10;
	/* Constant for stopping the exection*/
	public final static String QUIT_COMMAND = "0,0";
	/* Constant for separate the command*/
	public final static String SEPARATOR_COMMAND = ",";
	
	/*
	 * Main method
	 * */
	public static void main(String[] args) {
		// Create a new LCD
		LCD printer = new LCD();
		// Create a buffered reader in order to read input from the user
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// read the first line
			String line = br.readLine();
			// iterate until the line is equal to the QUIT_COMMAND "0,0"
			while(!line.equals(QUIT_COMMAND)) {
				// get the commands
				String[] commands = line.split(SEPARATOR_COMMAND);
				// get the size of the numbers
				int size = Integer.parseInt(commands[0]);
				// get the input number
				String number = (commands[1]);
				// verify if the size is between the boundaries
				if(size < SIZE_LOWER_BOUNDARY || size > SIZE_HIGHER_BOUNDARY) {
					// throws an exception if not
					throw new FormatException("The size of the number must be between"+ SIZE_LOWER_BOUNDARY +" and "+ SIZE_HIGHER_BOUNDARY +" inclusive.");
				}
				// get the number processed
				String res = printer.processAll(size, number);
				// print the number
				System.out.println(res);
				// read the next line
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
