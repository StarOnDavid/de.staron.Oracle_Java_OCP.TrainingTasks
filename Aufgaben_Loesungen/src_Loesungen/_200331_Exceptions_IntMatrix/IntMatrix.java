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
		if (line >= matrix.length || column >= matrix[0].length) {
			throw new IntMatrixIndexOutOfBoundsException(line, column);
		}
		return matrix[line][column];
	}
	
	public void set(int line, int column, int value) {
		if (line >= matrix.length || column >= matrix[0].length) {
			throw new IntMatrixIndexOutOfBoundsException(line, column);
		}
		matrix[line][column] = value;
	}
	
	public boolean equals(IntMatrix m) {
		if (!this.sameSize(m)) {
			return false;
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if (this.matrix[i][j] != m.matrix[i][j]) {
					return false;
				}
			}	
		}
		return true;
	}
	
	public boolean sameSize(IntMatrix m) {
		if (this.matrix.length == m.matrix.length && this.matrix[0].length == m.matrix[0].length) {
			return true;
		} else {
			return false;
		}
	}
	
	public IntMatrix transposed() {
		IntMatrix m = new IntMatrix(this.matrix[0].length, this.matrix.length);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				m.set(j, i, matrix[i][j]);
			}
		}
		return m;
	}
	
	public IntMatrix add(IntMatrix m) {
		if(!this.sameSize(m)) {
			throw new IntMatrixNotAddOrSubableException();
		}
		IntMatrix add = new IntMatrix(this.matrix.length, this.matrix[0].length);
		for(int i = 0; i < this.matrix.length; i++) {
			for(int j = 0; j < this.matrix[0].length; j++) {
				add.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
			}
		}
		return add;
	}
	
	public IntMatrix sub(IntMatrix m) {
		if(!this.sameSize(m)) {
			throw new IntMatrixNotAddOrSubableException();
		}
		IntMatrix add = new IntMatrix(this.matrix.length, this.matrix[0].length);
		for(int i = 0; i < this.matrix.length; i++) {
			for(int j = 0; j < this.matrix[0].length; j++) {
				add.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
			}
		}
		return add;
	}
	
	public IntMatrix multiply(IntMatrix m) {
		if(this.matrix.length != m.matrix[0].length) {
			throw new IntMatrixNotMultipliableException();
		}
		int prodSum = 0;
		
		IntMatrix mult = new IntMatrix(m.matrix[0].length, this.matrix.length);
		for(int i = 0; i < mult.matrix.length; i++) {		
			for (int j = 0; j < mult.matrix[0].length; j++) {
				for(int k = 0; k < this.matrix[0].length; k++) {
					prodSum = prodSum + this.matrix[j][k]*m.matrix[k][i];
				}
				mult.matrix[i][j] = prodSum;
				prodSum = 0;
			}
		}
		
		return mult;
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
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				out.append(String.format("%"+(maxLength + 1)+"d", matrix[i][j]));
				if (j < matrix[i].length - 1) {
					out.append(",");
				}
			}
			if (i < matrix.length - 1) {
				out.append("\n");
			}
		}
		
		return out.toString();
	}
	
	private void initValuesWith(int initValue) {
		for(int i = 0; i < matrix.length; i++) {
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
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * (maxRandom + addOne));
			}
		}	
	}

	static class IntMatrixSizeException extends RuntimeException {
		private static final long serialVersionUID = -2795992773190380045L;

		IntMatrixSizeException() {
			super("IntMatrix() lines/colums must be greater than Zero!");
		}
	}
	
	static class IntMatrixRandomInitException extends RuntimeException {
		private static final long serialVersionUID = -8893475541371908828L;

		IntMatrixRandomInitException() {
			super("Can't init randoms between Zero and Zero!");
		}
	}
	
	static class IntMatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {
		private static final long serialVersionUID = 7097032814541766248L;
		
		IntMatrixIndexOutOfBoundsException() {
			super("Index out of bounds!");
		}
		IntMatrixIndexOutOfBoundsException(int line, int column) {
			super("Index 'line' " + line + " and/or 'colum' " + column + " out of bounds!");
		}
	}
	
	static class IntMatrixNotAddOrSubableException extends RuntimeException {
		private static final long serialVersionUID = -2665797842923679141L;

		IntMatrixNotAddOrSubableException() {
			super("The condition for 'addition' or 'substraction* is: MatrixA 'size' equals MatrixB 'size'!");
		}
	}
	
	static class IntMatrixNotMultipliableException extends RuntimeException {
		private static final long serialVersionUID = -7741926619626455083L;

		IntMatrixNotMultipliableException() {
			super("The condition for 'multiplication' is: MatrixA 'lines' equals MatrixB 'columns'!");
		}
	}
}
