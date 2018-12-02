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
		builder.append("PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
		builder.append("SELECT ?streamEvent\n");
		builder.append("WHERE{\n");
		builder.append("?streamEvent a sao:streamEvent.");
		builder.append("}");
		builder.append("\nLIMIT 20");
		
		return builder.toString();
	}
	
	private String createStartEndTime() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
		builder.append("PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>\n");
		builder.append("SELECT ?startTime ?endTime\n");
		builder.append("WHERE{\n");
		builder.append("?streamEvent sao:time [tl:end ?endTime; tl:start ?startTime].\n");
		builder.append("}");
		builder.append("\nLIMIT 20");

		return builder.toString();
	}
	
	private String createUnitOfMeasurment() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
		builder.append("SELECT ?unitOfMeasurment\n");
		builder.append("WHERE{\n");
		builder.append("?subject sao:hasUnitOfMeasurement ?unitOfMeasurment.\n");
		builder.append("}");
		builder.append("\nLIMIT 20");

		return builder.toString();
	}
	
	private String createObservationTime() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
		builder.append("PREFIX tl: <http://purl.org/NET/c4dm/timeline.owl#>\n");
		builder.append("SELECT ?observationTime\n");
		builder.append("WHERE{\n");
		builder.append("?subject sao:time [tl:at ?observationTime].\n");
		builder.append("}");
		builder.append("\nLIMIT 20");
		
		return builder.toString();
	}
	
	private String createLongilatitude() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX ct: <http://www.insight-centre.org/citytraffic#>\n");
		builder.append("SELECT ?latitude ?longitude\n");
		builder.append("WHERE{\n");
		builder.append("?subject ct:hasFirstNode [ct:hasLatitude ?latitude; ct:hasLongitude ?longitude].\n");
		builder.append("}");
		builder.append("\nLIMIT 20");

		return builder.toString();
	}
	
	private String createNodeName() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX ct: <http://www.insight-centre.org/citytraffic#>\n");
		builder.append("SELECT ?nodeName\n");
		builder.append("WHERE{\n");
		builder.append("?subject ct:hasFirstNode [ct:hasNodeName ?nodeName].\n");
		builder.append("}");
		builder.append("\nLIMIT 20");

		return builder.toString();
	}
	
	private String createValues() {
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>\n");
		builder.append("SELECT ?value\n");
		builder.append("WHERE{\n");
		builder.append("?subject sao:value ?value.\n");
		builder.append("}");
		builder.append("\nLIMIT 20");

		return builder.toString();
	}
	
}
