package edu.school21.numbers;

public class NumberWorker {
	public boolean isPrime(int number) {
		if (number < 2) {
			throw new IllegalNumberException();
		}
		for (int i = 2; i * i <= number && i <= 46340; i++) {
			if (number % i == 0)
				return (false);
		}
		return (true);
	}

	public int digitsSum(int number) {
		int	sum = 0;

		if (number < 0) {
			number *= -1;
		}
		
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return (sum);
	}
	  
}
