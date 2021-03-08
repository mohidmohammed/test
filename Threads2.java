public class Threads2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new MultiplesOfFive());
        thread1.start();

        Thread thread2 = new Thread(new EvenNumbers());
        thread2.start();

        Thread thread3 = new Thread(new OddNumbers());
        thread3.start();

    }

}

class MultiplesOfFive implements Runnable {

    synchronized void printMultiplesOfFive() {
        try {
            int sleepCounter = 1;

            // Multiples of five below 5000
            for (int number = 5; number <= 5000; number++) {
                if (number % 5 == 0 && sleepCounter % 10 != 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    sleepCounter++;
                } else if (number % 5 == 0 && sleepCounter % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    Thread.sleep(100000);
                    sleepCounter = 1;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printMultiplesOfFive();
    }
}

class EvenNumbers implements Runnable {

    synchronized void printEvenNumbers() {
        try {
            int sleepCounter = 1;

            // Even numbers below 2000
            for (int number = 2; number <= 2000; number++) {
                if (number % 2 == 0 && sleepCounter % 10 != 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    sleepCounter++;
                } else if (number % 2 == 0 && sleepCounter % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    Thread.sleep(100000);
                    sleepCounter = 1;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printEvenNumbers();
    }
}

class OddNumbers implements Runnable {
    synchronized void printOddNumbers() {
        try {
            int sleepCounter = 1;

            // Odd numbers below 2000
            for (int number = 1; number <= 2000; number++) {
                if (number % 2 != 0 && sleepCounter % 10 != 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    sleepCounter++;
                } else if (number % 2 != 0 && sleepCounter % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    Thread.sleep(100000);
                    sleepCounter = 1;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printOddNumbers();
    }
}