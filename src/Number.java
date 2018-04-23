
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
		switch(number) {
			case 0:
				drawHorizontal(0);
				drawHorizontal(rows-1);
				drawVertical(0, 0, rows-1);
				drawVertical(columns-1, 0, rows-1);
				break;
			case 1:
				drawVertical(columns-1, 0, rows-1);
				break;
			case 2:
				drawVertical(0,rows/2,rows-1);
				drawVertical(columns-1,0,rows/2);
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				break;
			case 3:
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				drawVertical(columns-1, 0, rows-1);
				break;
			case 4:
				drawHorizontal(rows/2);
				drawVertical(columns-1, 0, rows-1);
				drawVertical(0, 0, rows/2);
				break;
			case 5:
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				drawVertical(columns-1,rows/2,rows-1);
				drawVertical(0,0,rows/2);
				break;
			case 6:
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				drawVertical(0, 0, rows-1);
				drawVertical(columns-1, rows/2, rows-1);
				break;
			case 7:
				drawHorizontal(0);
				drawVertical(columns-1, 0, rows-1);
				break;
			case 8:
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				drawVertical(0, 0, rows-1);
				drawVertical(columns-1, 0, rows-1);
				break;
			case 9:
				drawHorizontal(0);
				drawHorizontal(rows/2);
				drawHorizontal(rows-1);
				drawVertical(0, 0, rows/2);
				drawVertical(columns-1, 0, rows-1);
				break;
			default:
				break;
		}
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
	public void drawVertical(int column, int alpha, int omega) {
		
		for(int i = 0; i< rows; i++) {
			if(i != 0 && i != rows/2 && i != rows-1 && i >= alpha && i <= omega) {
				visualRepresentation[i][column] = VERTICAL_SEPARATOR;
			}
		}
	}
	public void drawHorizontal(int row) {
		for(int j = 1; j < columns-1; j++) {
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
