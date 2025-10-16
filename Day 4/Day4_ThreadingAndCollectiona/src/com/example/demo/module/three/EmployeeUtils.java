package com.example.demo.module.three;

import java.util.Comparator;

public class EmployeeUtils {

	public class NameComarator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getEmployeeName().compareTo(o2.getEmployeeName());
		}
		
	}
	
	public class SalaryComarator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return (int)(o1.getSalary()-o2.getSalary());
		}
	}
	
	public class LocationComarator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getLocation().compareTo(o2.getLocation());
		}
		
	}
	
	public static Comparator<Employee> comparatorFactory(int key){
		
		EmployeeUtils utils = new EmployeeUtils();
		Comparator<Employee> comp = null;
		
		switch(key) {
			case 1:{
				comp = utils.new NameComarator();
				break;
			}
			case 2:{
				comp = utils.new SalaryComarator();
				break;
			}
			case 3:{
				comp = utils.new LocationComarator();
				break;
			}
			default :
				break;
		}
		return comp;
	}
}
