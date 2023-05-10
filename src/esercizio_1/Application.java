package esercizio_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		PrintSymbol print1 = new PrintSymbol('*');
		PrintSymbol print2 = new PrintSymbol('#');
		print1.start();
		print2.start();
	}
}
