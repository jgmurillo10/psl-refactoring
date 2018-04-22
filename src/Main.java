import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public final static int SIZE_LOWER_BOUNDARY = 1;
	public final static int SIZE_HIGHER_BOUNDARY = 10;
	public final static String QUIT_COMMAND = "0,0";
	public final static String SEPARATOR_COMMAND = ",";
	public static void main(String[] args) {
		LCD printer = new LCD();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			while(!line.equals(QUIT_COMMAND)) {
				String[] commands = line.split(SEPARATOR_COMMAND);
				int size = Integer.parseInt(commands[0]);
				String number = (commands[1]);
				if(size < SIZE_LOWER_BOUNDARY || size > SIZE_HIGHER_BOUNDARY) {
					throw new FormatException("The size of the number must be between"+ SIZE_LOWER_BOUNDARY +" and "+ SIZE_HIGHER_BOUNDARY +" inclusive.");
				}
				String res = printer.processAll(size, number);
				System.out.println(res);
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
