package tpsana.webofthing;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class WOTJena {


	public static final String ROUTIER_FILENAME = "aarhus_parking.ttl";
	public static final String CLIMAT_FILENAME = "humidity.ttl";

	public static void main(String[] args) {
		String selectedFileName = CLIMAT_FILENAME;
		checkFiles(selectedFileName);
		Model model = ModelFactory.createDefaultModel();
		model.read(selectedFileName);
		//model.write(System.out);
		launchAllRequests(model);
	}
	
	private static void checkFiles(String fileName) {
		InputStream in = FileManager.get().open(fileName);
		if (in == null) {
			throw new IllegalArgumentException("File: " + fileName + " not found");
		}
	}
	
	private static List<ResultSet> launchAllRequests(Model model) {
		List<ResultSet> results = new ArrayList<ResultSet>();
		QueryManager requester = new QueryManager(model);
		Queries.getInstance();
		for(Entry<String, String> entry : Queries.getInstance().getAllRequests().entrySet()) {
			results.add(requester.execute(entry.getValue(), true));
		}
		return results;
	}
}
