package edu.danib.flickrapp.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;
import edu.danib.flickrapp.model.SearchResult;


public class FlickrService {

    protected static final String FLICKR_FEED_URL_FORMAT = "http://api.flickr.com/services/feeds/photos_public.gne?format=json&tags=%s&tagmode=any";
    
    private HttpService httpService;
    
    public FlickrService() {
		super();
		this.httpService = new HttpService();
	}

	public List<SearchResult> getFlickrSearchResults(String query) {
		String resultsString = getHttpService().doGet(buildApiUrl(query));
		String atomPartRemoved = removeAtomFeedPrefix(resultsString);
		List<SearchResult> results = parseResponse(atomPartRemoved);
        return results;
    }

	private List<SearchResult> parseResponse(String atomPartRemoved) {
		List<SearchResult> results = new ArrayList<SearchResult>();
        try {
            JSONObject json = new JSONObject(atomPartRemoved);
            JSONArray jsonArray = json.getJSONArray("items");
            int numberOfResults = jsonArray.length();
            for (int i = 0; i<numberOfResults; i++) {
                SearchResult searchResult = new SearchResult();
                JSONObject result = jsonArray.getJSONObject(i);
                searchResult.setTitle(result.getString("title"));
                searchResult.setAuthorId(result.getString("author_id"));
                searchResult.setFlickrUrl(result.getString("link"));
                searchResult.setImgUrl(result.getJSONObject("media").getString("m"));
                results.add(searchResult);
            }

        } catch (JSONException e) {
            Log.e(FlickrService.class.toString(), "Failed to parse response", e);
        }
		return results;
	}

	protected String removeAtomFeedPrefix(String resultsString) {
		int start = "jsonFlickrFeed(".length();
		int end = resultsString.length()-1;
		return TextUtils.substring(resultsString, start, end);
	}

	protected String buildApiUrl(String query) {
		String cleanInput = getHttpService().cleanInput(query);
        return String.format(FLICKR_FEED_URL_FORMAT, cleanInput);
	}

	public HttpService getHttpService() {
		return httpService;
	}
    
}
