package MatMultiplication;

public class MatRessourcePool {
	MatMatrix[] ergebnisse;
	boolean[] isReleased;
	
	public MatRessourcePool(){
		ergebnisse=new MatMatrix[8];
		isReleased = new boolean[] {false,false,false,false,false,false,false,false};
	}
	
	public void release(MatMatrix ergebnis, int i) {
		synchronized(ergebnisse) {
			ergebnisse[i]=ergebnis;
			isReleased[i]=true;
			ergebnisse.notifyAll();
		}
	}
	
	public MatMatrix require(int i) {
		synchronized(ergebnisse) {
			try{
				while(!isReleased[i]) {
					ergebnisse.wait();
				}
			} catch (InterruptedException e) {
				
			}
			return ergebnisse[i];
		} 
	}
}
