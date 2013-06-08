package edu.danib.flickrapp;

import java.util.List;

import edu.danib.boilerplate.R;
import edu.danib.flickrapp.model.SearchResult;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText searchText;
    private Button searchButton;
    private EditText resultsText;	//TODO: Bind results to list view instead of simple text display

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsById();
        searchButton.setOnClickListener(new SearchClickListener(searchText, this));
    }

    public void showResults(List<SearchResult> results) {
    	if (results != null && results.size() > 0) {
    		resultsText.setText(buildTextResults(results));
    	} else {
    		resultsText.setText(R.string.noResults);
    	}
    }

    private CharSequence buildTextResults(List<SearchResult> results) {
		StringBuilder sb = new StringBuilder();
		for (SearchResult searchResult : results) {
			sb.append(searchResult.toString());
		}
		return sb.toString();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void findAllViewsById() {
        searchText = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.searchButton);
        resultsText = (EditText) findViewById(R.id.resultsText);
    }
    
}
