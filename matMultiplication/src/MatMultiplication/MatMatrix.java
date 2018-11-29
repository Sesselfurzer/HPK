package MatMultiplication;

import java.util.Random;

public class MatMatrix {
	
	double[][] matrix;
	
	public MatMatrix() {
		
	}
	
	public MatMatrix(int zeilen, int spalten) {
		createRNDMatrix(zeilen,spalten);
	}
	
	public MatMatrix(double[][] matrix) {
		this.matrix = matrix;
	}
	
	public void createRNDMatrix(int zeilen, int spalten) {
		Random rnd = new Random();
		matrix = new double[zeilen][spalten];
		for(int i=0 ; i<zeilen ; i++) {
			for(int j=0 ; j<spalten ; j++) {
				matrix[i][j]=rnd.nextDouble()*100; //Zufallszahl zwischen 0 und 99
			}
		}
	}
	
	public int getZeilen() {
		return matrix.length;
	}
	
	public int getSpalten() {
		return matrix[0].length;
	}
	
	public double[][] getMatrix(){
		return matrix;
	}
	
	public void setValue(int zeile, int spalte, double value) {
		matrix[zeile][spalte]=value;
	}
	
	public void addValue(int zeile, int spalte, double value) {
		matrix[zeile][spalte]+=value;
	}
	
	public double getValue(int zeile, int spalte) {
		return matrix[zeile][spalte];
	}
	
	public void mergeMatrix(MatMatrix[][] splittedMatrix) {
		
		int zeile = splittedMatrix[0][0].getMatrix().length + splittedMatrix[1][0].getMatrix().length;
		int spalte = splittedMatrix[0][0].getMatrix()[0].length + splittedMatrix[0][1].getMatrix()[0].length;
		
		this.matrix = new double[zeile][spalte];
		
		for(int i = 0;i<zeile;i++) {
			for(int j =0; j<spalte;j++) {
				if(i < zeile/2) {
					if(j < spalte/2) {
						this.matrix[i][j] = splittedMatrix[0][0].getMatrix()[i][j];
					} else {
						this.matrix[i][j] = splittedMatrix[0][1].getMatrix()[i][j-spalte/2];
					}
				} else if(j < spalte/2) {
					this.matrix[i][j] = splittedMatrix[1][0].getMatrix()[i-zeile/2][j];
				} else {
					this.matrix[i][j] = splittedMatrix[1][1].getMatrix()[i-zeile/2][j-spalte/2];
				}
			}	
		}
			
	}
	
	public MatMatrix[][] splitMatrix() {
		
		int zeile=this.matrix.length;
		int spalte=this.matrix[0].length;
		
		double[][] dbMatrix1 = new double[zeile/2][spalte/2];
		double[][] dbMatrix2 = new double[zeile/2][spalte-spalte/2];
		double[][] dbMatrix3 = new double[zeile-zeile/2][spalte/2];
		double[][] dbMatrix4 = new double[zeile-zeile/2][spalte-spalte/2];
		
		for(int i = 0;i<zeile;i++) {
			for(int j =0; j<spalte;j++) {
				if(i < zeile/2) {
					if(j < spalte/2) {
						dbMatrix1[i][j] = this.matrix[i][j];
					} else {
						dbMatrix2[i][j-spalte/2] = this.matrix[i][j];
					}
				} else if(j < spalte/2) {
					dbMatrix3[i-zeile/2][j] = this.matrix[i][j];
				} else {
					dbMatrix4[i-zeile/2][j-spalte/2] = this.matrix[i][j];
				}
			}	
		}
		
		MatMatrix[][] splittedMatrix= {
			{new MatMatrix(dbMatrix1) , new MatMatrix(dbMatrix2)},
			{new MatMatrix(dbMatrix3) , new MatMatrix(dbMatrix4)}
		};
		
		return splittedMatrix;
	}
	
	public MatMatrix transponierteMatrix() {
		MatMatrix ergebnis= new MatMatrix(new double[getSpalten()][getZeilen()]);
		for (int i = 0; i < getSpalten(); i++) {
            for (int j = 0; j < getZeilen(); j++) {
                ergebnis.getMatrix()[i][j] = getValue(j,i);
            }
		}
		
		return ergebnis;
	}
	
	public void setMatrix(MatMatrix matrix) {
		this.matrix = matrix.getMatrix();
	}
	
}
