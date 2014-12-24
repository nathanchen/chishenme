package com.chishenme.controller.friend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import junit.framework.TestCase;

public class FriendControllerTest extends TestCase
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
	
	public void testFriendController1() throws IOException, JSONException
	{
		URL url = new URL(urlPrefixString + "friend/add?userid=0&friendid=2");
		
		JSONObject json = new JSONObject(getHtml(url));
		assertEquals(1, json.get("code"));
	}
	
	public void testFriendController2() throws IOException, JSONException
	{
		URL url = new URL(urlPrefixString + "friend/add?userid=1&friendid=0");
		
		JSONObject json = new JSONObject(getHtml(url));
		assertEquals(2, json.get("code"));
	}
	
}
