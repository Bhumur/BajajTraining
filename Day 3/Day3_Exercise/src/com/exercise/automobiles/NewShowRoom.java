package com.exercise.automobiles;

import com.exercise.iface.Automobile;

public class NewShowRoom extends ShowRoom {
	@Override
	public Automobile autoFactory(int choice, String color, double price, String model) {
		Automobile automobile = null;
		if(choice<4) {
			automobile = super.autoFactory(choice, color, price, model);
		}
		switch(choice) {
			case 4:{
				automobile = new ElectricCar(color, price, model);
				break;
			}
			default:{
				break;
			}
		}
		return automobile;
	}
}
