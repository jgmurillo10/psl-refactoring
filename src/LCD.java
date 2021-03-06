import java.util.HashMap;

public class LCD {
	/* Constant for the separator of the hash table */
	public final static String MEMO_SEPARATOR = ":"; 
	/* Constant for when the line breaks */
	public final static String BREAK_LINE = "\n";
	/* Constant for the horizontal padding between numbers */
	public final static String DIGIT_SEPARATOR = "   ";
	/* Hash table to storage numbers already calculated */
	private HashMap<String, String> memo;
	/**
	 * Constructor of the LCD class.
	 * */
	public LCD() {
		// initialize the hash table
		memo = new HashMap<String, String>();
	}
	/**
	 * Method that process the number digit by digit
	 * @param size - Size of the output
	 * @param numbers - The numbers that will be parsed
	 * @return The digits concatenated
	 * */
	public String processAll(int size, String numbers ) {
		String[] response = new String[numbers.length()];
		for(int i = 0; i< response.length; i++) {
			int number = Integer.parseInt(numbers.substring(i, i+1));
			response[i] = process(size, number);
		}
		return concatNumbers(response);
	}
	/**
	 * Method that concatenate the digits 
	 * @param numbers - Array of the digits as Strings 
	 * @return all the digits concatenated as a String
	 * */
	public String concatNumbers(String[] numbers) {
		String response = "";
		String[] lines = new String[numbers[0].split(BREAK_LINE).length];
		
		for (int i = 0; i < lines.length; i++) {
			for(int j = 0; j < numbers.length; j++) {
				String[] line = numbers[j].split(BREAK_LINE);
				response = response + line[i] + DIGIT_SEPARATOR; 
			}
			response+= BREAK_LINE;
		}
		return response;
	}
	/**
	 * Method that process one digit
	 * @param size - Size of the digit
	 * @number number - Digit that will be parsed
	 * @return The digit parsed
	 * */
	public String process(int size, int number) {
		String cache = memo.get(number+MEMO_SEPARATOR+size);
		if ( cache == null ) {
			Number n = new Number(number, size);
			memo.put(number+MEMO_SEPARATOR+size, n.toString());
			return n.toString();
		}
		return cache;
	}
}
