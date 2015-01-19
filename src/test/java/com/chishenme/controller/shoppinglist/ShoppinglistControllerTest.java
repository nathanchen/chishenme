package com.chishenme.controller.shoppinglist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import junit.framework.TestCase;

public class ShoppinglistControllerTest extends TestCase
{
	private String urlPrefixString = "http://localhost:8080/";
	private String getHtml(URL url) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String inputLine;
		String text = "";
		while ((inputLine = in.readLine()) != null)
		{
			text += inputLine;
		}
		return text;
	}
	
	public void testShoppinglistController1() throws JSONException, IOException
	{
		URL url = new URL(urlPrefixString + "/shoppinglist/item/add?creator_id=1&subject=apple&quantity=1&unit=&checksum=b44aba5baec9c83a35bc2bc43e41b43d");
		
		JSONObject jsonObject = new JSONObject(getHtml(url));
		assertEquals(0, jsonObject.get("code"));
	}
}
