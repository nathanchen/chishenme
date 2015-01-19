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
		URL url = new URL(urlPrefixString + "/shoppinglist/item/add?creator_id=1&shoppinglist_id=1&subject=apple&quantity=1&unit=&checksum=8b93081401b7b1a73e5ed9dce3071337");
		
		JSONObject jsonObject = new JSONObject(getHtml(url));
		assertEquals(0, jsonObject.get("code"));
	}
	
	public void testAddAShoppinglist() throws IOException, JSONException
	{
		URL url = new URL(urlPrefixString  + "/shoppinglist/add?creator_id=1&subject=test&checksum=ba88c155ba898fc8b5099893036ef205");
		
		JSONObject jsonObject = new JSONObject(getHtml(url));
		assertEquals(0, jsonObject.get("code"));
	}
}
