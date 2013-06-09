package edu.danib.flickrapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import edu.danib.boilerplate.R;
import edu.danib.flickrapp.model.SearchResult;

public class MainActivity extends Activity {
	
	private EditText searchText;
    private Button searchButton;
    private ListView searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsById();
        searchButton.setOnClickListener(new SearchClickListener(searchText, this));
    }

    public void showResults(List<SearchResult> results) {
    	if (results != null && results.size() > 0) {
    		ListAdapter searchResultsListAdapter = 
    				new ArrayAdapter<SearchResult>(this, android.R.layout.simple_list_item_1, results);
			searchResults.setAdapter(searchResultsListAdapter);
			searchResults.setOnItemClickListener(new FlickrListItemClickListener(this));
    	} 
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void findAllViewsById() {
        searchText = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchResults = (ListView) findViewById(R.id.searchResults);
    }
    
}
