package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args){
		ParkingLot lot = new ParkingLot(50, 50);
		List<Vehicle> list = new ArrayList<>();
		for (int i = 0; i < 50; i++){
			final Vehicle v;
			if (i % 20 == 0) {
				v = new Car();
			}
			else {
				
				v = new Truck();
			}
			list.add(v);
			boolean hasSpot = lot.hasSpots(v);
			if (i < 40){
				//System.out.println("i < 40");
				assert hasSpot;
				assert lot.park(v);
			} else{
				//System.out.println("no spot");
				assert !hasSpot;
				assert !lot.park(v);
			}
		}
		assert list.size() == 50;
		int i = 0;
		for (Vehicle v : list){
			assert i >= 40 || lot.leave(v);
			i++;
		}
	}
	

}
