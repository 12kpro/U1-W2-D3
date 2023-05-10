package esercizio_2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		int numbers[] = new int[3000];
		Random randNum = new Random();

		Thread[] threads = new Thread[3];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = randNum.nextInt();
		}

		threads[0] = new SumPartition(numbers, 0);
		threads[1] = new SumPartition(numbers, 1000);
		threads[2] = new SumPartition(numbers, 2000);

		int sum = 0;
		for (Thread t : threads) {
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += ((SumPartition) t).getResult();

		}
		Application.logger.info("Totale: " + sum);

	}
}
