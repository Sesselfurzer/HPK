package MatMultiplication;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatCalc {
	
	public static MatMatrix serielleBerechnung(MatMatrix ersteMatrix, MatMatrix zweiteMatrix){
		Objects.requireNonNull(ersteMatrix, "ersteMatrix = null");
		Objects.requireNonNull(zweiteMatrix, "zweiteMatrix = null");
		int mLength = ersteMatrix.getSpalten();
		if(mLength!= zweiteMatrix.getZeilen())
			throw new IllegalArgumentException("Incorrect Matrix sizes");
		
		int zeilen = ersteMatrix.getZeilen();
		int spalten = zweiteMatrix.getSpalten();
		
		MatMatrix ergebnis=new MatMatrix(new double[zeilen][spalten]);
		
		for(int i=0 ; i< zeilen ; i++) {
			for(int j=0 ; j< spalten ; j++) {
				for(int m=0 ; m< mLength ; m++) {
					ergebnis.getMatrix()[i][j] += ersteMatrix.getValue(i,m)*zweiteMatrix.getValue(m,j);
				}
			}
		}
		return ergebnis;
	}
	
	public static MatMatrix paralleleBerechnung(MatMatrix ersteMatrix, MatMatrix zweiteMatrix){
		Objects.requireNonNull(ersteMatrix, "ersteMatrix = null");
		Objects.requireNonNull(zweiteMatrix, "zweiteMatrix = null");
		int mLength = ersteMatrix.getSpalten();
		if(mLength!= zweiteMatrix.getZeilen())
			throw new IllegalArgumentException("Incorrect Matrix sizes");
		
		
		int zeilen = ersteMatrix.getZeilen();
		int spalten = zweiteMatrix.getSpalten();
		
		MatMatrix d = zweiteMatrix.transponierteMatrix();
		
		MatMatrix ergebnis=new MatMatrix(new double[zeilen][spalten]);
		
		ExecutorService executor = Executors.newCachedThreadPool(); 
		
		
		for(int i = 0; i < zeilen; i++)
    	{
    		final int I = i;
    		double[] aI = ersteMatrix.getMatrix()[i];
    		Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < spalten; j++) {
						double[] dj = d.getMatrix()[j];
    					double temp = 0;
    					for(int k = 0; k < mLength; k++) {
    						temp += aI[k] * dj[k];
    					}
    					ergebnis.getMatrix()[I][j] = temp;
    				}
				}
    		});
    		executor.execute(t);
    	}
    	
    	executor.shutdown();
		try {
			if(!executor.awaitTermination(180, TimeUnit.SECONDS))
				executor.shutdownNow();
		} catch (InterruptedException ie) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();
	    }
		
		return ergebnis;
	}
	
	public static MatMatrix DivideandConquer(MatMatrix ersteMatrix, MatMatrix zweiteMatrix) {
		Objects.requireNonNull(ersteMatrix, "ersteMatrix = null");
		Objects.requireNonNull(zweiteMatrix, "zweiteMatrix = null");
		int mLength = ersteMatrix.getSpalten();
		if(mLength!= zweiteMatrix.getZeilen())
			throw new IllegalArgumentException("Incorrect Matrix sizes");
		
		MatMatrix[][] m1 = ersteMatrix.splitMatrix();
		MatMatrix[][] m2 = zweiteMatrix.splitMatrix();
		
		MatMatrix[][][] temp = new MatMatrix[2][2][2];
		MatMatrix[][] tempErgebnis = new MatMatrix[2][2];
		
		MatRessourcePool pool = new MatRessourcePool();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0;i<2;i++) {
			for(int j = 0;j<2;j++) {
				
				final int I=i;
				final int J=j;
				temp[i][j][0] = new MatMatrix();
				temp[i][j][1] = new MatMatrix();
				tempErgebnis[i][j] = new MatMatrix();
				
				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {
						temp[I][J][0].setMatrix(serielleBerechnung(m1[I][0], m2[0][J]));
						pool.release(temp[I][J][0], I*4+J*2);
					}
				});	
				t1.start();
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						temp[I][J][1].setMatrix(serielleBerechnung(m1[I][1], m2[1][J]));
						pool.release(temp[I][J][1], I*4+J*2+1);
					}
				});	
				t2.start();
				Thread t3 = new Thread(new Runnable() {
					@Override
					public void run() {
						tempErgebnis[I][J].setMatrix(addMatrix(pool.require(I*4+J*2),pool.require(I*4+J*2+1)));
					}
				});	
				executor.execute(t3);
			}
		}
		
		executor.shutdown();
		try {
			if(!executor.awaitTermination(800, TimeUnit.SECONDS))
				executor.shutdownNow();
		} catch (InterruptedException ie) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();
	    }
		
		MatMatrix ergebnis = new MatMatrix();
		ergebnis.mergeMatrix(tempErgebnis);
		
		return ergebnis;
	}
	
	public static MatMatrix addMatrix(MatMatrix ersteMatrix, MatMatrix zweiteMatrix) {
		
		int zeilen = ersteMatrix.getZeilen();
		int spalten = zweiteMatrix.getSpalten();
		
		MatMatrix ergebnis=new MatMatrix(new double[zeilen][spalten]);
		
		for(int i=0 ; i<zeilen ; i++) {
			for(int j=0 ; j<spalten ; j++) {
				ergebnis.setValue(i, j, ersteMatrix.getValue(i,j)+zweiteMatrix.getValue(i,j));
			}
		}
		
		return ergebnis;
	}
}
