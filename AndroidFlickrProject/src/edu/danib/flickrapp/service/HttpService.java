package edu.danib.flickrapp.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.text.TextUtils;
import android.util.Log;

public class HttpService {
	
	public String cleanInput(String input) {
		String returnValue = input;
		if (!TextUtils.isEmpty(input)) {
			try {
				returnValue = URLEncoder.encode(input, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				Log.e(HttpService.class.toString(), "cleanInput", e);
			}
		}
		return returnValue;
	}

	public String doGet(String urlString) {
		HttpURLConnection urlConnection = null;
		URL url;
		try {
			url = new URL(urlString);
			urlConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
			String convertStreamToString = convertStreamToString(inputStream);
			Log.i(HttpService.class.toString(), convertStreamToString);
			return convertStreamToString;
		} catch (Exception e) {
			Log.e(HttpService.class.toString(), "doGet", e);
		} finally {
			urlConnection.disconnect();
		}
		return null;
	}
	
	protected String convertStreamToString(InputStream is) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");	//TODO do we need new line?
	        }
	    } catch (IOException e) {
	    	Log.e(HttpService.class.toString(), "convertStreamToString", e);
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	        	Log.e(HttpService.class.toString(), "convertStreamToString close", e);
	        }
	    }
	    return sb.toString();
	}
	
}

//	 public String doGet(String url) {
//	        StringBuilder builder = new StringBuilder();
//	        HttpClient client = new DefaultHttpClient();
//	        HttpGet httpGet = new HttpGet(url);
//	        try {
//	            HttpResponse response = client.execute(httpGet);
//	            StatusLine statusLine = response.getStatusLine();
//	            int statusCode = statusLine.getStatusCode();
//	            if (statusCode == 200) {
//	                HttpEntity entity = response.getEntity();
//	                InputStream content = entity.getContent();
//	                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//	                String line;
//	                while ((line = reader.readLine()) != null) {
//	                    builder.append(line);
//	                }
//	                String resultsString = builder.toString();
//	                Log.i(HttpService.class.toString(), "resultsString");
//	                return resultsString;
//	            } else {
//	                Log.e(ImdbService.class.toString(), "Failed to get response, status = " + statusCode);
//	            }
//	        } catch (ClientProtocolException e) {
//	            Log.e(ImdbService.class.toString(), "protocol", e);
//	        } catch (IOException e) {
//	            Log.e(ImdbService.class.toString(), "protocol", e);
//	        }
//			return null;
//	    }
//}
