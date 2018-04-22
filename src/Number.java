
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
		initializeVisualRepresentation();
	}
	public void initializeVisualRepresentation(){
		this.columns = this.size + DELTA_COLUMNS;
		this.rows = (this.size*FACTOR_ROWS) + DELTA_ROWS;
		visualRepresentation = new char[rows][columns];
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
	public void drawVertical(int row) {
		for(int i = 0; i< columns; i++) {
			visualRepresentation[row][i] = VERTICAL_SEPARATOR;
		}
	}
	public void drawHorizontal(int column) {
		for(int j = 0; j < rows; j++) {
			visualRepresentation[j][column] = HORIZONTAL_SEPARATOR;
		}
	}
	@Override
	public String toString() {
		// TODO map from matrix to string representation
		String visualNumber = "";
		for(int  i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				visualNumber+=this.visualRepresentation[i][j];
			}
			visualNumber += LCD.BREAK_LINE;
		}
		return visualNumber;
	}
}
