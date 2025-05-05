package SOLIDprinciples.LISCOV_Solution;

import java.util.ArrayList;
import java.util.List;

public class LISCOV_ProblemSolution {

	public static void main(String[] args) {

		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(new MotorCycle());
		vehicleList.add(new Car());
		vehicleList.add(new Bicycle());

		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getNumberOfWheels().toString());
		}
	}

}

// Parent (Put only very generic(common to all) method)
class Vehicle {

	public Integer getNumberOfWheels() {
		return 2;
	}
}

// Extra class to solve problem
class EngineVehicles extends Vehicle {

	public Boolean hasEngine() {
		return true;
	}
}

// EngineVehicles child-1
class MotorCycle extends EngineVehicles {
}

// EngineVehicles child-2
class Car extends EngineVehicles {
}

// Vehicle child-1
class Bicycle extends Vehicle {
}