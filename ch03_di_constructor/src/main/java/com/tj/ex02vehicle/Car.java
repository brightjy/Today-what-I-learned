package com.tj.ex02vehicle;

public class Car implements IVehicle{

	@Override
	public void ride(String name) {
		System.out.println(name+"은(는) 차로 90km/h 속도로 빨리 간다.");
		
	}
	
	
}
