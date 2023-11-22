package hw1_BigNumber;

public class BigNumber {
	private String x;
	private String y;
	
	public BigNumber (String xInput) {
		x = xInput;
	}
	
	public String add(String yInput) {
		y = yInput;
		
		/*
		int xIndex = x.length() - 1;
		int yIndex = y.length() - 1;
		int xDigit = 0, yDigit = 0;
		
		int digitSum;
		int carry;
		String totalSum = "";
		
		while (xIndex >= 0 || yIndex >= 0) {
			xDigit = xIndex >= 0 ? x.charAt(xIndex) : 0;
			yDigit = yIndex >= 0 ? y.charAt(yIndex) : 0;
			
			digitSum = xDigit + yDigit;
			carry = digitSum / 10;
			totalSum = "" + (digitSum % 10) + totalSum;
		}
		*/
		
		return "x = " + x + ", y = " + y;
	}
}
