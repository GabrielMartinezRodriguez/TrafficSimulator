package simulator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public class Vehicle extends SimulatedObject {

	private List<Junction> itinerary;
	private int maxSpeed;
	private int currentSpeed;
	private VehicleStatus status;
	private Road currentRoad;
	private int location;
	private int co2Level;
	private int co2Total;
	private int totalDistance;
	
	public Vehicle(String id, int maxSpeed, int co2perTick, List<Junction> itinerary) {
		super(id);
		this.maxSpeed = maxSpeed;
		this.co2Level = co2perTick;
		this.itinerary = Collections.unmodifiableList(new ArrayList<>(itinerary));
	}

	void setSpeed(int speed)
	{
		if (speed > maxSpeed)
			this.currentSpeed = maxSpeed;
		else
			this.currentSpeed = speed;
	}
	
	void setContaminationClass(int co2perTick)
	{
		this.co2Level = co2perTick;
	}
	
	@Override
	void advance(int time) {
		int previusLocation;
		int co2Emited;

		previusLocation = this.location;
		if (status == VehicleStatus.TRAVELING)
		{
			if (this.location + this.currentSpeed > this.currentRoad.getLength())
				this.location = this.currentRoad.getLength();
			else
				this.location += this.currentSpeed;
			
			co2Emited = (this.location - previusLocation) * this.co2Level;
			this.co2Total += co2Emited;
			this.currentRoad.addContamination(co2Emited);
		}

	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}

}
