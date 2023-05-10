package esercizio_2;

import java.util.Arrays;

class SumPartition extends Thread {
	private int start;
	private int[] numbers;
	private int result = 0;

	public SumPartition(int[] numbers, int start) {
		this.start = start;
		this.numbers = numbers;
	}

	public int getResult() {
		return result;
	}

	@Override
	public void run() {
		int[] numPart = Arrays.copyOfRange(numbers, start, start + 999);
		// Arrays.stream(numPart).sum();
		// Arrays.stream(numPart).reduce(0, (a, b) -> a + b);

		for (int i = 0; i < numPart.length; i++) {
			result += numPart[i];
		}
	}
}