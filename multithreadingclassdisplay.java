package assignment_day_15;

class printingstring implements Runnable
{
	private String[]course;
	printingstring(String []course)
	{
		this.course=course;
	}

	@Override
	public void run() {
		
		for(String coursename:course)
		{
			System.out.println(Thread.currentThread().getName()+" "+course);
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		}	
	}
}

public class multithreadingclassdisplay implements Runnable {
	 private String[] course;
	    private int startIndex;

	    public multithreadingclassdisplay(String[] course, int startIndex) {
	        this.course = course;
	        this.startIndex = startIndex;
	    }

	    public void run() {
	        for (int i = startIndex; i < course.length; i += 3) {
	            System.out.println(Thread.currentThread().getName() + ": " + course[i]);
	        }
	    }

	    public static void main(String[] args) {
	    	String[] course = {"Java", "J2EE", "Spring", "Struts"};
	        Thread thread1 = new Thread(new multithreadingclassdisplay(course, 0), "Thread 1");
	        Thread thread2 = new Thread(new multithreadingclassdisplay(course, 0), "Thread 2");
	        Thread thread3 = new Thread(new multithreadingclassdisplay(course, 0), "Thread 3");

	        thread1.start();
	        thread2.start();
	        thread3.start();
	    }
	}