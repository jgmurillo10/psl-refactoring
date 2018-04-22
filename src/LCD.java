import java.util.HashMap;

public class LCD {
	public final static String MEMO_SEPARATOR = ":"; 
	public final static String BREAK_LINE = "\n";
	public final static String DIGIT_SEPARATOR = "   ";
	private HashMap<String, String> memo;
	public LCD() {
		memo = new HashMap<String, String>();
	}
	public String processAll(int size, String numbers ) {
		String[] response = new String[numbers.length()];
		for(int i = 0; i< response.length; i++) {
			int number = Integer.parseInt(numbers.substring(i, i+1));
			response[i] = process(size, number);
		}
		return concatNumbers(response);
	}
	public String concatNumbers(String[] numbers) {
		//concat all numbers in one string;
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
