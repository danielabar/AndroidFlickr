package edu.danib.flickrapp.component;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import edu.danib.flickrapp.model.SearchResult;

public class FlickrItemLongClickListener implements OnItemLongClickListener {
	
	private Activity parentActivity;
	
	public FlickrItemLongClickListener(Activity parentActivity) {
		super();
		this.parentActivity = parentActivity;
	}

	//FIXME: Regardless of return value, going back from Messaging Intent goes to Home, not my app
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		SearchResult selectedItem = (SearchResult) parent.getItemAtPosition(position);
		Intent sendIntent = createSendIntent(selectedItem);
		parentActivity.startActivity(sendIntent);
		return false;	
	}

	private Intent createSendIntent(SearchResult selectedItem) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, selectedItem.toString());
		sendIntent.setType("text/plain");
		return sendIntent;
	}

}
