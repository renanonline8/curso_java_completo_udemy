package entitie;

public class Student {
	public String name;
	public double finalGrade = 0;
	
	public void addFinalGrade(double grade) {
		finalGrade += grade;
	}
	
	public String checkPass() {
		if (finalGrade >= 60) {
			return "PASS";
		} else {
			return "FAILED";
		}
	}
	
	public double missingPoint() {
		double missingPoint = 0;
		if (finalGrade < 60) {
			missingPoint = 60 - finalGrade;
		}
		return missingPoint;
	}
}
