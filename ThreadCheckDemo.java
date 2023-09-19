package assignment_day_15;

class MyThread  extends Thread
{
	public MyThread (String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " is running. Iteration: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadCheckDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread ("Thread 1");
        MyThread thread2 = new MyThread ("Thread 2");

        thread1.start();
        thread2.start();

        // Check whether the threads are running or not
        if (thread1.isAlive()) {
            System.out.println(thread1.getName() + " is running.");
        } else {
            System.out.println(thread1.getName() + " is not running.");
        }

        if (thread2.isAlive()) {
            System.out.println(thread2.getName() + " is running.");
        } else {
            System.out.println(thread2.getName() + " is not running.");
        }
    }
}


