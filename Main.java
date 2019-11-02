public class Main {
	public static void main(String[] args) {

		double lower = -10;
		double higher = 10;
		double possibleResult = 0;
		double tolerance = 0.01;
		boolean flag = true;
		int count = 0;

		if (result(0) == 0) {
			flag = false;
			possibleResult = 0;
		}

		if (flag) {
			if (result(lower) * result(higher) >= 0) {
				while (result(lower) * result(higher) >= 0) {
					if (result(lower) < 0 && result(higher) < 0) {
						higher = higher - tolerance;
						lower = lower + tolerance;
						count += tolerance;
						if (count >= Integer.MAX_VALUE - 100) {
							break;
						}
					}

					if (result(lower) > 0 && result(higher) > 0) {
						higher = higher - tolerance;
						lower = lower + tolerance;
						count += tolerance;
						if (count >= Integer.MAX_VALUE - 100) {
							break;
						}
					}

				}
			}
		}

		if (flag) {
			do {
				possibleResult = (lower + higher) / 2;
				if (result(possibleResult) == 0) {
					break;
				}
				if (result(lower) * result(possibleResult) < 0) {
					higher = possibleResult;
				} else {
					lower = possibleResult;
				}
			} while (Math.abs(result(possibleResult)) > tolerance);
		}
		System.out.println(possibleResult);
	}

	static double result(double x) {
		return x * x * Math.sqrt(273 * x) - 233 + 0.31 * x;
	}

}
