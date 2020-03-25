package com.tj.ex02vehicle;

public class Bicycle implements IVehicle{

	@Override
	public void ride(String name) {
		System.out.println(name+"은(는) 자전거로 10km/h 속도로 간다.");
		
	}
	
}
