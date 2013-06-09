package edu.danib.flickrapp.task;

import java.util.List;

import edu.danib.flickrapp.MainActivity;
import edu.danib.flickrapp.model.SearchResult;
import edu.danib.flickrapp.service.FlickrService;

import android.app.ProgressDialog;
import android.os.AsyncTask;


public class SearchTask extends AsyncTask<String, Void, List<SearchResult>> {

	private FlickrService flickrService;
    private MainActivity mainActivity;
    private ProgressDialog progressDialog;

    public SearchTask(MainActivity mainActivity) {
    	this.flickrService = new FlickrService();
        this.progressDialog = new ProgressDialog(mainActivity);
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setTitle("Searching...");
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected List<SearchResult> doInBackground(String... params) {
        String query = params[0];
        return getFlickrService().getFlickrSearchResults(query);
    }

    @Override
    protected void onPostExecute(final List<SearchResult> result) {
        mainActivity.showResults(result);
        progressDialog.dismiss();
    }
    
    public FlickrService getFlickrService() {
        return flickrService;
    }

}
