package assignment_day_15;

class EvenThread implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class OddThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 19; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}	
	public class evenodd
	{
	public static void main(String[] args) {
		Thread evenThread = new Thread(new EvenThread());
        Thread oddThread = new Thread(new OddThread());

        evenThread.start();
        oddThread.start();

	}
	}
	
	

