package MatMultiplication;

import org.junit.Assert;
import org.junit.Test;


public class MatTest {
	final double eps = 1.E-8;

	@Test
	public void testMatrix() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{3,4}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{5,6},
			{7,8}
		});
		MatMatrix erwartetErgebnis = new MatMatrix(new double[][] {
			{19,22},
			{43,50}
		});
		MatMatrix ergebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
	}
	
	@Test
	public void testMatrix2x2mul2x3() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{3,4}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{1,2,3},
			{3,2,1}
		});
		MatMatrix erwartetErgebnis = new MatMatrix(new double[][] {
			{ 7, 6, 5},
			{15,14,13}
		});
		MatMatrix ergebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
	}

	@Test
	public void testMatrix3x2mul2x2() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,3},
			{2,4},
			{3,1}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{4,1},
			{2,3}
		});
		MatMatrix erwartetErgebnis = new MatMatrix(new double[][] {
			{10,10},
			{16,14},
			{14, 6}
		});
		MatMatrix ergebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
	}
	
	@Test
	public void testMatrix4x2mul2x3() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{2,3},
			{3,1},
			{1,4}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{4,1,2},
			{2,3,4}
		});
		MatMatrix erwartetErgebnis = new MatMatrix(new double[][] {
			{ 8, 7,10},
			{14,11,16},
			{14, 6,10},
			{12,13,18}
		});
		MatMatrix ergebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSeriellMatrixIllegalSize2x3mul4x5() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{2,3},
			{3,1}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{4,1,2,3,2},
			{2,3,4,1,3},
			{4,1,2,3,2},
			{2,3,4,1,3}
		});
		MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testParallelMatrixIllegalSize2x3mul4x5() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{2,3},
			{3,1}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{4,1,2,3,2},
			{2,3,4,1,3},
			{4,1,2,3,2},
			{2,3,4,1,3}
		});
		MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDivideandConquerMatrixIllegalSize2x3mul4x5() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,2},
			{2,3},
			{3,1}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{4,1,2,3,2},
			{2,3,4,1,3},
			{4,1,2,3,2},
			{2,3,4,1,3}
		});
		MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
	}
	
	@Test
	public void testMatrix4x5mul5x3() throws Exception {
		MatMatrix ersteMatrix = new MatMatrix(new double[][] {
			{1,4,5,3,2},
			{3,2,1,4,8},
			{2,4,5,3,3},
			{1,1,1,1,1}
		});
		MatMatrix zweiteMatrix = new MatMatrix(new double[][] {
			{2,4,6},
			{2,3,8},
			{5,1,2},
			{6,1,1},
			{3,2,2}
		});
		MatMatrix erwartetErgebnis = new MatMatrix(new double[][] {
			{59,28,55},
			{63,39,56},
			{64,34,63},
			{18,11,19}
		});
		MatMatrix ergebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
	}
	
	@Test
	public void testRNDMatrix() throws Exception{
		int randomZahl = (int)(Math.random()*1000)+10;
		MatMatrix ersteMatrix = new MatMatrix(randomZahl-1,randomZahl);
		MatMatrix zweiteMatrix = new MatMatrix(randomZahl,randomZahl+1);
		MatMatrix erwartetErgebnis = MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
		MatMatrix ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));
		ergebnis = MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
		Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));	
	}

	@Test
	public void testMatrixSpeedup() throws Exception{
		int[] dimension = {64,128,256,512,768,1024,1536,2048};
		int[] repeats = {100,50,25,12,5,2,1,1};
		MatMatrix erwartetErgebnis = new MatMatrix();
		MatMatrix ergebnis = new MatMatrix();
		
		System.err.println("repitions |  dimension  |  seriel  | parallel |  speedup  | DivideandConquer | speedup");
		System.err.println("----------+-------------+----------+----------+-----------+------------------+----------");
		
		for(int i=0;i<8;i++) {
			MatMatrix ersteMatrix = new MatMatrix(dimension[i]+1,dimension[i]);
			MatMatrix zweiteMatrix = new MatMatrix(dimension[i],dimension[i]+1);
			long time;
			double SCALED = -1000*repeats[i];
			
			time=System.nanoTime();
			for(int j =0; j<repeats[i];j++) {
				erwartetErgebnis=MatCalc.serielleBerechnung(ersteMatrix, zweiteMatrix);
			}
			time-=System.nanoTime();
			long timeSeriell=time;
			
			time=System.nanoTime();
			for(int j =0; j<repeats[i];j++) {
				ergebnis=MatCalc.paralleleBerechnung(ersteMatrix, zweiteMatrix);
			}
			time-=System.nanoTime();
			long timeParallel=time;
			
			Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));	
			
			time=System.nanoTime();
			for(int j =0; j<repeats[i];j++) {
				ergebnis=MatCalc.DivideandConquer(ersteMatrix, zweiteMatrix);
			}
			time-=System.nanoTime();
			long timeDivideandConquer=time;
			
			Assert.assertTrue(ergebnis.equalMatrix(erwartetErgebnis));	
			
			timeSeriell /= SCALED;
	        timeParallel /= SCALED;
	        timeDivideandConquer /= SCALED;
	        double speedup = (double)timeSeriell/(double)timeParallel;
	        double speedup2 = (double)timeSeriell/(double)timeDivideandConquer;
			
			System.err.println(String.format("%9d | %4d x %4d | %8d | %8d | %9f | %16d | %9f"
			, repeats[i], dimension[i] , dimension[i]+1, timeSeriell, timeParallel, speedup, timeDivideandConquer, speedup2));

		}
	}
}
