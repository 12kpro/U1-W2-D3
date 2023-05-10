package esercizio_1;

class PrintSymbol extends Thread {
	private char symbol;

	public PrintSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			Application.logger.info("" + symbol);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}