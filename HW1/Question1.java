public class Question1 {
    public static void main(String[] args) {
        // Create and start four threads
        Thread thread1 = new Thread(new FourThreads(), "Thread 1");
        Thread thread2 = new Thread(new FourThreads(), "Thread 2");
        Thread thread3 = new Thread(new FourThreads(), "Thread 3");
        Thread thread4 = new Thread(new FourThreads(), "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Wait for all threads to complete before exiting main thread
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FourThreads implements Runnable {
    public void run() {
        // Code to be executed in each thread goes here
        System.out.println(Thread.currentThread().getName() + " started");
        // Simulate some work by sleeping for a random amount of time
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}