package assignment_day_15;

class alphabetThread implements Runnable
{
	 @Override
	    public void run() {
	        for (char ch = 'A'; ch <= 'Z'; ch++) {
	            System.out.print(ch + " ");
	            try {
	                Thread.sleep(500); // Sleep for 500 milliseconds
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	class NumberThread implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 1; i <= 26; i++) {
	            System.out.print(i + " ");
	            try {
	                Thread.sleep(500); // Sleep for 500 milliseconds
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	public class multithread {
	    public static void main(String[] args) {
	        Thread alphabetThread = new Thread(new alphabetThread());
	        Thread numberThread = new Thread(new NumberThread());

	        alphabetThread.start();
	        numberThread.start();
	    }
	}