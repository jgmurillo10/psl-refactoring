
public class Number {
	/* Horizontal separator for the LCD numbers */
	public final static char HORIZONTAL_SEPARATOR = '-';
	/* Vertical separator for the LCD numbers */
	public final static char VERTICAL_SEPARATOR = '|';
	/* Delta for the number of rows for one digit */
	public final static int DELTA_ROWS = 3;
	/* Delta for the number of columns for one digit */
	public final static int DELTA_COLUMNS = 2;
	public final static int FACTOR_ROWS = 2;
	/* Raw number */
	private int number;
	/* Number of columns for the LCD representation */
	private int columns;
	/* Number of rows for the LCD representation */
	private int rows;
	/* Size of the LCD representation */
	private int size; 
	/* Matrix that storage the LCD representation */
	private char [][] visualRepresentation;
	/**
	 * Constructor of the class
	 * @param number - The digit
	 * @param size - The size of the digit
	 * */
	public Number(int number, int size) {
		this.number = number;
		this.size = size;
		this.columns = this.size + DELTA_COLUMNS;
		this.rows = (this.size*FACTOR_ROWS) + DELTA_ROWS;
		this.visualRepresentation = new char[rows][columns];
		initializeEmptyMatrix();
		initializeVisualRepresentation();
	}
	/**
	 * Build the matrix of the LCD representation according to the number to be parsed
	 * */
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
	/**
	 * Return the number
	 * */
	public int getNumber() {
		return number;
	}
	/**
	 * Set the number
	 * @param number - New number
	 * */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * Return the size
	 * */
	public int getSize() {
		return size;
	}
	/**
	 * Set the size
	 * @param size - New size of the number
	 * */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Return the LCD representation of the number
	 * */
	public char[][] getVisualRepresentation() {
		return visualRepresentation;
	}
	/**
	 * Draw a vertical line
	 * @param column - Index of the column to be draw
	 * @param alpha - Index of the initial row
	 * @param omega - Index of the end row
	 **/
	public void drawVertical(int column, int alpha, int omega) {
		
		for(int i = 0; i< rows; i++) {
			if(i != 0 && i != rows/2 && i != rows-1 && i >= alpha && i <= omega) {
				visualRepresentation[i][column] = VERTICAL_SEPARATOR;
			}
		}
	}
	/**
	 * Draw a horizontal line
	 * @param row - Index of the row 
	 **/
	public void drawHorizontal(int row) {
		for(int j = 1; j < columns-1; j++) {
			visualRepresentation[row][j] = HORIZONTAL_SEPARATOR;
		}
	}
	/**
	 * Initialize the matrix with " " chars
	 **/
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
