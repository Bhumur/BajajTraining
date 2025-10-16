package traninig;

public class StudentService {
	
	/*
	 * Take the Student as Argument
	 * if the markScore greater than 80 assign A else B
	 */
	
	public char assignGrade(Student s) {
		char grade = 'B';
		if(s.getMarkScored()>80)
			grade = 'A';
		return grade;
	}
}
