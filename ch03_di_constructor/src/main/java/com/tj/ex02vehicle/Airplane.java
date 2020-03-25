package com.tj.ex02vehicle;

public class Airplane implements IVehicle {

	@Override
	public void ride(String name) {
		System.out.println(name+"은(는) 비행기로 500km/h로 날아간다.");
		
	}
	
}
