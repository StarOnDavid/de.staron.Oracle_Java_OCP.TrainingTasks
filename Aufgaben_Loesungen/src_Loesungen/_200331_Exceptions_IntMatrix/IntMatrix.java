package _200331_Exceptions_IntMatrix;


public class IntMatrix {
	private int[][] matrix;
	
	public IntMatrix(int lines, int columns) {
		if(lines < 1 || columns < 1) {
			throw new IntMatrixSizeException();
		}
		matrix = new int[lines][columns];
	}
	
	public IntMatrix(int lines, int columns, int initValue) {
		this(lines, columns);
		initValuesWith(initValue);
	}
	
	public static IntMatrix getRandomMatrix(int lines, int columns, int maxRandom) {
		if(maxRandom == 0) {
			throw new IntMatrixRandomInitException();
		}
		IntMatrix newMat = new IntMatrix(lines, columns);
		newMat.initRandomValues(maxRandom);
		return newMat;
	}

	public int get(int line, int column) {
		if (line >= getLines() || column >= getColumns()) {
			throw new IntMatrixIndexOutOfBoundsException(line, column);
		}
		return matrix[line][column];
	}
	
	public void set(int line, int column, int value) {
		if (line >= getLines() || column >= getColumns()) {
			throw new IntMatrixIndexOutOfBoundsException(line, column);
		}
		matrix[line][column] = value;
	}
	
	public int getLines() {
		return matrix.length;
	}
	
	public int getColumns() {
		return matrix[0].length;
	}
	
	public boolean sameSize(IntMatrix m) {
		if (this.getLines() == m.getLines() && this.getColumns() == m.getColumns()) {
			return true;
		} else {
			return false;
		}
	}
	
	public IntMatrix transposed() {
		IntMatrix m = new IntMatrix(this.getColumns(), this.getLines());
		for(int i = 0; i < getLines(); i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				m.set(j, i, this.get(i, j));
			}
		}
		return m;
	}
	
	public IntMatrix add(IntMatrix m) {
		if(!this.sameSize(m)) {
			throw new IntMatrixNotAddOrSubableException();
		}
		IntMatrix add = new IntMatrix(this.getLines(), this.getColumns());
		for(int i = 0; i < this.getLines(); i++) {
			for(int j = 0; j < this.getColumns(); j++) {
				add.set(i,j, this.get(i,j) + m.get(i,j));
			}
		}
		return add;
	}
	
	public IntMatrix sub(IntMatrix m) {
		if(!this.sameSize(m)) {
			throw new IntMatrixNotAddOrSubableException();
		}
		IntMatrix add = new IntMatrix(this.getLines(), this.getColumns());
		for(int i = 0; i < this.getLines(); i++) {
			for(int j = 0; j < this.getColumns(); j++) {
				add.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
			}
		}
		return add;
	}
	
	public IntMatrix multiply(IntMatrix m) {
		if(this.getLines() != m.getColumns()) {
			throw new IntMatrixNotMultipliableException();
		}
		int prodSum = 0;
		
		IntMatrix mult = new IntMatrix(m.getColumns(), this.getLines());
		for(int i = 0; i < mult.getLines(); i++) {		
			for (int j = 0; j < mult.getColumns(); j++) {
				for(int k = 0; k < this.getColumns(); k++) {
					prodSum = prodSum + this.matrix[j][k]*m.matrix[k][i];
				}
				mult.matrix[i][j] = prodSum;
				prodSum = 0;
			}
		}
		
		return mult;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		IntMatrix m = (IntMatrix) obj;
		if(!this.sameSize(m))
			return false;
		for(int i = 0; i < getLines(); i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if (this.matrix[i][j] != m.matrix[i][j]) {
					return false;
				}
			}	
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		int maxLength = 0;
		for(int flv[] : this.matrix ) {
			for(Integer val : flv) {
				if (val.toString().length() > maxLength) {
					maxLength = val.toString().length();
				}
			}
		}
		
		String format = "%"+(maxLength + 1)+"d";
		for(int i = 0; i < getLines(); i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				out.append(String.format(format, matrix[i][j]));
				if (j < matrix[i].length - 1) {
					out.append(",");
				}
			}
			if (i < getLines() - 1) {
				out.append("\n");
			}
		}
		
		return out.toString();
	}
	
	private void initValuesWith(int initValue) {
		for(int i = 0; i < getLines(); i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = initValue;
			}
		}	
	}
	
	private void initRandomValues(int maxRandom) {
		int addOne = 1;
		if (maxRandom < 0) {
			addOne = -1;
		}
		for(int i = 0; i < getLines(); i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * (maxRandom + addOne));
			}
		}	
	}

	

	@SuppressWarnings("serial")
	public static class IntMatrixSizeException extends RuntimeException {
		IntMatrixSizeException() {
			super("IntMatrix() lines/colums must be greater than Zero!");
		}
	}
	
	@SuppressWarnings("serial")
	public static class IntMatrixRandomInitException extends RuntimeException {
		IntMatrixRandomInitException() {
			super("Can't init randoms between Zero and Zero!");
		}
	}
	
	@SuppressWarnings("serial")
	public static class IntMatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {
		IntMatrixIndexOutOfBoundsException() {
			super("Index out of bounds!");
		}
		IntMatrixIndexOutOfBoundsException(int line, int column) {
			super("Index 'line' " + line + " and/or 'colum' " + column + " out of bounds!");
		}
	}
	
	@SuppressWarnings("serial")
	public static class IntMatrixNotAddOrSubableException extends RuntimeException {
		IntMatrixNotAddOrSubableException() {
			super("The condition for 'addition' or 'substraction* is: MatrixA 'size' equals MatrixB 'size'!");
		}
	}
	
	@SuppressWarnings("serial")
	public static class IntMatrixNotMultipliableException extends RuntimeException {
		IntMatrixNotMultipliableException() {
			super("The condition for 'multiplication' is: MatrixA 'lines' equals MatrixB 'columns'!");
		}
	}
}
