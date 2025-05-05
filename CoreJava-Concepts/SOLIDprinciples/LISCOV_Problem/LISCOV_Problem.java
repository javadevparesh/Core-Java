package SOLIDprinciples.LISCOV_Problem;

import java.util.ArrayList;
import java.util.List;

public class LISCOV_Problem {
	
	public static void main(String[] args) {
		
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(new MotorCycle());
		vehicleList.add(new Car());
		vehicleList.add(new Bicycle());
		
		for( Vehicle vehicle: vehicleList) {
			System.out.println(vehicle.hasEngine().toString());
		}
	}
}

// Parent
class Vehicle{
	
	public Integer getNumberOfWheels() {
		return 2;
	}
	
	public Boolean hasEngine() {
		return true;
	}
}

// Vehicle child-1
class MotorCycle extends Vehicle{
}

// Vehicle child-2
class Car extends Vehicle{
	
	@Override
	public Integer getNumberOfWheels() {
		return 4;
	}
}

// Vehicle child-3 (Down-sizing capability of Vehicle/Bicycle doesn't have engine
class Bicycle extends Vehicle{
	
	@Override
	public Boolean hasEngine() {
		return null;
	}
}


