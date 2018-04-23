
public class Number {
	public final static char HORIZONTAL_SEPARATOR = '-';
	public final static char VERTICAL_SEPARATOR = '|';
	public final static int DELTA_ROWS = 3;
	public final static int DELTA_COLUMNS = 2;
	public final static int FACTOR_ROWS = 2;
	private int number;
	private int columns;
	private int rows;
	private int size; 
	private char [][] visualRepresentation;
	
	Number(int number, int size) {
		this.number = number;
		this.size = size;
		this.columns = this.size + DELTA_COLUMNS;
		this.rows = (this.size*FACTOR_ROWS) + DELTA_ROWS;
		this.visualRepresentation = new char[rows][columns];
		initializeEmptyMatrix();
		initializeVisualRepresentation();
	}
	public void initializeVisualRepresentation(){
		System.out.println("visualre");
		switch(number) {
			case 1:
				drawVertical(columns-1);
				break;
			default:
				break;
		}
		System.out.println("visualre");
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public char[][] getVisualRepresentation() {
		return visualRepresentation;
	}
	public void drawVertical(int column) {
		System.out.println("drawvertica:"+column);
		for(int i = 0; i< rows; i++) {
			System.out.println(i+":"+column);
			if(i != 0 && i != rows/2 && i != rows-1) {
				System.out.println(i+":"+column);
				visualRepresentation[i][column] = VERTICAL_SEPARATOR;
			}
		}
	}
	public void drawHorizontal(int row) {
		for(int j = 0; j < rows; j++) {
			visualRepresentation[row][j] = HORIZONTAL_SEPARATOR;
		}
	}
	public void initializeEmptyMatrix() {
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < columns; j++) {
				visualRepresentation[i][j] = ' ';
			}
		}
	}
	@Override
	public String toString() {
		System.out.println("toString");
		// TODO map from matrix to string representation
		String visualNumber = "";
		for(int  i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				visualNumber+=this.visualRepresentation[i][j];
			}
			visualNumber += LCD.BREAK_LINE;
		}
		System.out.println(visualNumber);
		return visualNumber;
	}
}
