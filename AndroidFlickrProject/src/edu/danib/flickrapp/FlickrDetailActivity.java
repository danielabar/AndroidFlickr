package edu.danib.flickrapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import edu.danib.boilerplate.R;

public class FlickrDetailActivity extends Activity {

	private ImageView flickrImageView;
	private EditText flickrDetailUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flickr_detail);
		findAllViewsById();
		loadFlickrImage();
		loadFlickrDetailUrl();
	}

	private void loadFlickrImage() {
		String flickrImageUrl = getIntent().getStringExtra(ExtraKeys.FLICKR_IMAGE_URL);
		UrlImageViewHelper.setUrlDrawable(flickrImageView, flickrImageUrl, R.drawable.loading);
	}

	private void loadFlickrDetailUrl() {
		
		makeTextViewLookLikeALink();
		
		final String flickrDetailUrlText = getIntent().getStringExtra(ExtraKeys.FLICKR_DETAIL_URL);
		flickrDetailUrl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse(flickrDetailUrlText);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
	}

	private void makeTextViewLookLikeALink() {
		flickrDetailUrl.setInputType(InputType.TYPE_NULL);
		flickrDetailUrl.setClickable(true);
		flickrDetailUrl.setTextColor(android.graphics.Color.BLUE);
	}

	private void findAllViewsById() {
		flickrImageView = (ImageView) findViewById(R.id.flickrImageView);
		flickrDetailUrl = (EditText) findViewById(R.id.flickrDetailUrl);
	}

}
