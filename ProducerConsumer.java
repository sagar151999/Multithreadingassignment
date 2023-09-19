package assignment_day_15;



class  SharedResource implements Runnable
{
	 private int data;
	    private boolean isProduced;

	    public synchronized void produce(int value) {
	        try {
	            while (isProduced) {
	                wait(); 
	            }
	            data = value;
	            System.out.println("Producer produced: " + data);
	            isProduced = true;
	            notify(); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    public synchronized int consume() {
	        try {
	            while (!isProduced) {
	                wait(); 
	            }
	            System.out.println("Consumer consumed: " + data);
	            isProduced = false;
	            notify(); 
	            return data;
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            return -1;
	        }
	    }

		@Override
		public void run() {
			
		}
	}

	class Producer implements Runnable {
	    private SharedResource sharedResource;

	    public Producer(SharedResource sharedResource) {
	        this.sharedResource = sharedResource;
	    }

	    @Override
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            sharedResource.produce(i);
	            try {
	                Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	}

	class Consumer implements Runnable {
	    private SharedResource sharedResource;

	    public Consumer(SharedResource sharedResource) {
	        this.sharedResource = sharedResource;
	    }

	    @Override
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            int consumedValue = sharedResource.consume();
	            try {
	                Thread.sleep(1500); 
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	}

	public class ProducerConsumer {
	    public static void main(String[] args) {
	        SharedResource sharedResource = new SharedResource();

	        Thread producerThread = new Thread(new Producer(sharedResource));
	        Thread consumerThread = new Thread(new Consumer(sharedResource));

	        producerThread.start();
	        consumerThread.start();
	    }
	}