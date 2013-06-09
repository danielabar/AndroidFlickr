package edu.danib.flickrapp.component;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import edu.danib.flickrapp.ExtraKeys;
import edu.danib.flickrapp.FlickrDetailActivity;
import edu.danib.flickrapp.model.SearchResult;

public class FlickrItemClickListener implements OnItemClickListener {
	
	private Activity parentActivity;
	
	public FlickrItemClickListener(Activity parentActivity) {
		super();
		this.parentActivity = parentActivity;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		SearchResult selectedItem = (SearchResult) parent.getItemAtPosition(position);
		Intent intent = createFlickrDetailIntent(selectedItem);
		parentActivity.startActivity(intent);
	}

	private Intent createFlickrDetailIntent(SearchResult searchResult) {
		Intent intent = new Intent(parentActivity, FlickrDetailActivity.class);
		intent.putExtra(ExtraKeys.FLICKR_IMAGE_URL, searchResult.getImgUrl());
		intent.putExtra(ExtraKeys.FLICKR_DETAIL_URL, searchResult.getFlickrUrl());
		return intent;
	}

}
