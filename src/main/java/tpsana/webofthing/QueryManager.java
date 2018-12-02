package tpsana.webofthing;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryException;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;

public class QueryManager {

	public Model model;

	public QueryManager(Model model) {
		this.model = model;
	}

	public ResultSet execute(String request, boolean display) {
		ResultSet results = null;
		
		try {
			Query query = QueryFactory.create(request);
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			results = qexec.execSelect();

			if (display == true) {
				displayOnStandard(query, results);
			}
		} catch (QueryException ex) {
			System.out.println("QUERY HAS FAILED : \n'" + request + "'\n" + ex.getMessage());
		}

		return results;
	}

	public void displayOnStandard(Query query, ResultSet results) {
		System.out.println("QUERY IS A SUCCESS : \n" + query.toString());
		ResultSetFormatter.out(System.out, results, query);
	}

}
