package tpsana.webofthing;

import java.util.HashMap;
import java.util.Map;

public class Queries {

	private Queries() {
		allRequests = new HashMap<String, String>();	
		allRequests.put("object", createObject());	
		allRequests.put("startEndTime", createStartEndTime());	
		allRequests.put("unitOfMeasurment", createUnitOfMeasurment());	
		allRequests.put("observationTime", createObservationTime());	
		allRequests.put("longilatitude", createLongilatitude());	
		allRequests.put("nodeName", createNodeName());	
		allRequests.put("values", createValues());	
	}

	private static Queries INSTANCE = new Queries();

	public static Queries getInstance() {
		return INSTANCE;
	}

	private Map<String, String> allRequests;
	
	public Map<String, String> getAllRequests() {
		return allRequests;
	}

	private String createObject() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");
		builder.append("SELECT ?streamEvent\n");
		builder.append("WHERE\n");
		builder.append("{<http://iot.ee.surrey.ac.uk/citypulse/datasets/parking/parkingDataStream> a ?streamEvent}");
		
		return builder.toString();
	}
	
	private String createStartEndTime() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");

		return builder.toString();
	}
	
	private String createUnitOfMeasurment() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");

		return builder.toString();
	}
	
	private String createObservationTime() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");

		return builder.toString();
	}
	
	private String createLongilatitude() {
		StringBuilder builder = new StringBuilder();

		return builder.toString();
	}
	
	private String createNodeName() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");
		
		return builder.toString();
	}
	
	private String createValues() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX dc:<http://purl.org/dc/elements/1.1/>\n");

		return builder.toString();
	}
	
}
