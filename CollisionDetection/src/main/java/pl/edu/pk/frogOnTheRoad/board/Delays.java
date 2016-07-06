package pl.edu.pk.frogOnTheRoad.board;



public class Delays {
	private long n;
	
	public Delays(int nn)
	{
		n = nn;
	}
	
	private long getN() {
		return n;
	}
	
	public void uspij()
	{
		try {
			Thread.sleep(getN());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uspij(long n){
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
