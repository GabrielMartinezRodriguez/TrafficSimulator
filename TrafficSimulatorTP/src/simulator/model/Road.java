package simulator.model;

import org.json.JSONObject;

public class Road extends SimulatedObject {

	public Road(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	void advance(int time) {
		// TODO Auto-generated method stub

	}
	
	int getLength()
	{
		return 0;
	}
	
	void addContamination(int contamination)
	{
		
	}
	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}

}
