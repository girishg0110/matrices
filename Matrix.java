
public class Matrix {
	
	public double[][] elements;
	
	public Matrix(double[][] elements) {
		this.elements = new double[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
				this.elements[i][j] = elements[i][j];
			}
		}
	 }
	 
	 public Matrix add(Matrix y) {
		 Matrix sol = null;
		 if ((elements.length == y.elements.length) && (elements[0].length == y.elements[0].length)) {
			 double[][] solElements = new double[elements.length][elements[0].length];
			 for (int i = 0; i < elements.length; i++) {
					for (int j = 0; j < elements[0].length; j++) {
						solElements[i][j] = elements[i][j] + y.elements[i][j];
					}
				}
			 sol = new Matrix(solElements);
		 }
		 return sol;
	 }
	 
	public Matrix subtract(Matrix y) {
		Matrix sol = null;
		 if ((elements.length == y.elements.length) && (elements[0].length == y.elements[0].length)) {
			 double[][] solElements = new double[elements.length][elements[0].length];
			 for (int i = 0; i < elements.length; i++) {
					for (int j = 0; j < elements[0].length; j++) {
						solElements[i][j] = elements[i][j] - y.elements[i][j];
					}
				}
			 sol = new Matrix(solElements);
		 }
		 return sol;
	 }
	
	 public Matrix multiply(Matrix y) {
		 Matrix sol = null;
		 
		 if (elements[0].length == y.elements.length) {
			 double[][] solElements = new double[elements.length][y.elements[0].length];

			 for (int i = 0; i < elements.length; i++) {
				 for (int j = 0; j < elements[0].length; j++) {
					 solElements[i][j] = rowColProdSum(i, j);
				 }
			 }
			 
			 sol = new Matrix(solElements);
		 }
		 
		 return sol;
	 }
	 
	 private double rowColProdSum(int row, int col) {
		 int prodSum = 0;
		 
		 for (int k = 0; k < elements.length; k++) {
			 prodSum += (elements[row][k] * elements[k][col]);
		 }
		 
		 return prodSum;
	 }
	 
	 public Matrix multiply(double y) {
		double[][] solElements = new double[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
				solElements[i][j] = y * elements[i][j]; 
			}
		}
		Matrix solu = new Matrix(solElements);
		return solu;
	 }
	 
	 public void multiplyRow(int row, double y) {
		for (int j = 0; j < elements[0].length; j++) {
			elements[row][j] = y * elements[row][j]; 
		}
	 }
	 
	 public void addRow(int row1, double factor1, int row2, double factor2, int location) {
		 for (int j = 0; j < elements[0].length; j++) {
			 elements[location][j] = factor1*elements[row1][j] + factor2*elements[row2][j];
		 }
	 }
	 
	 public Matrix transpose() {
		double[][] transEls = new double[elements[0].length][elements.length];
		
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
				transEls[j][i] = elements[i][j];
			}
		}
		
		Matrix trans = new Matrix(transEls);
		return trans;
	 }
	 
	 public Matrix inverse() {
		 Matrix augy = null;
		 if (elements.length == elements[0].length) return augy;
		 
		 double[][] augEls = new double[elements.length][2 * elements[0].length];
		 
		 for (int i = 0; i < elements.length; i++) {
			 for (int j = 0; j < elements[0].length; j++) {
				 augEls[i][j] = elements[i][j];
				 if (j == i) augEls[i][j + elements[0].length] = 1;
				 else augEls[i][j + elements[0].length] = 0;
			 }
		 }
		 
		 		augy = new Matrix(augEls);
	
		 
		 for (int j = 0; j < elements[0].length; j++) {
				for (int i = j; i < elements.length; i++) {
					augy.multiplyRow(i, 1/augEls[i][j]);
				}
				for (int i = j+1; i < elements.length; i++) {
					augy.addRow(j, -1, i, 1, i);
				}
			}
			augy.multiplyRow(elements.length - 1, 1/augEls[elements.length - 1][elements[0].length - 1]);
		 
		 augy.display(25);
		 return augy;
			
			//Matrix aug = new Matrix
		 
		 //Matrix inv = new Matrix();
	 }
	 
	// private double diagProd(int start, boolean xEqualsY) {
		// elements
	 //}
	 
	 public double det() {
		 /*double[][] els = new double[elements.length][elements[0].length * 2];
		 for (int j = 0; j < elements[0].length; j++) {
			 for (int i = 0; i < elements.length; i++) {
				 els[i][j] = elements[i][j];
				 els[i][j+elements[0].length] = elements[i][j];
			 }
		 }
		 
		 //Matrix basket = new Matrix(els);
		 double pos = 1, neg = 1;
		 int diag = 1;
		 
		// for (int i = 1; i < elements.length; i++) {
			 for (int j = 0; j < elements[0].length; j++) {
				 try {
				 	diag *= els[j][j];
				 } catch (ArrayIndexOutOfBoundsException e) {
					 break;
				 }
				 System.out.println("Pos Diag " + j + ": " + diag);
			 }
			 pos *= diag;
			 System.out.println("Pos: " + pos);
			 for (int j = els[0].length; j > 0; j--) {
				 try {
					 diag *= els[j][j];
				 } catch (ArrayIndexOutOfBoundsException e) {
					 break;
				 }
				 System.out.println("Neg Diag " + j + ": " + diag);
			 }
			 neg *= diag;
			 System.out.println("Neg: " + neg);
		 //}
		 
		 return pos - neg;*/
		 /*
		 double det = 0, diag = 1;
		 
		 for (int j = 0; j < elements[0].length; j++) {
			  for (int k = 0; j + k < elements.length; k++) {
				  System.out.println((elements[j+k][(j+k) % elements[0].length]));
				  diag *= (elements[j+k][(j+k) % elements[0].length]);
			  }
			  det += diag;
		 }*/
		 /*
		 for (int j = elements[0].length - 1; j >= 0; j--) {
			  for (int k = 0; j - k >= 0; k++) {
				  diag *= (elements[j-k][(j-k) % elements[0].length]);
			  }
			  det -= diag;
		 }
		 */
		 //System.out.println("");
		 /*
		 double det = 0;
		 
		 if (elements.length == 2) 	return elements[0][0] * elements[1][1] - elements[1][0] * elements[0][1];
		 else {
			double[][] subVals = new double[elements.length - 1][elements.length - 1];
			for (int j = 0; j < elements[0].length; j++) {
				for (int i = 0; i < elements.length; i++) {
					for (int tj = 0; i < elements[0].length; tj++) {
						if (tj != j) subVals[i][(int) (tj - 1 - (Math.pow(-1, j)) * j)] = elements[i][tj];
					}
				}
				Matrix subMatrix = new Matrix(subVals);
				det += (Math.pow(-1, j) * subMatrix.det());
			} 
		 } 
		 */
		 double det = 0;
		 return det;
		 
	 }
	 
	 public void ref() {
	
		for (int j = 0; j < elements[0].length; j++) {
			for (int i = j; i < elements.length; i++) {
				if (elements[i][j] != 0) multiplyRow(i, 1/elements[i][j]);
			}
			for (int i = j+1; i < elements.length; i++) {
				addRow(j, -1, i, 1, i);
			}
		}
		if (elements[elements.length - 1][elements[0].length - 2] != 0) multiplyRow(elements.length - 1, 1/elements[elements.length - 1][elements[0].length - 2]);
	 }
	 
	 public double[] rref() {
		 ref();
		 double[] sol = new double[elements.length];
		 for (int i = elements.length - 1; i > 0; i--) {
			 for (int j = i - 1; j >= 0; j--) {
				 addRow(i, -elements[j][i], j, 1, j);
			 }
		 }
		 
		 for (int i = 0; i < elements.length; i++) {
			 sol[i] = elements[i][elements[0].length - 1];
		 }
		 
		 return sol;
	 }
	 
	 public String encode(String message, Matrix key) {
		 
		 return "";
	 }
	 
	 //private 
	 
	 private int squareGreaterThan(int num) {
		 for (int i = 0; ; i++) {
			 if (i*i >= num) return i;
		 }
	 }
	 
	 private void setw(String x, int space) {
		 for (int i = 0; i < space - x.length(); i++) {
			 System.out.print(" ");
		 }
		 System.out.print(x);
	 }
	 
	 public void display(int space) {
		 
		 System.out.print("_");
		 for (int i = 0; i < elements[0].length; i++) {
			 for (int j = 0; j < space; j++) System.out.print(" ");
		 }
		 System.out.println("_");
		 
		 
		 for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
				if (j == 0) 
				setw(elements[i][j] + "  ", space);	
			}
			System.out.println("");
		}
	}  
}