package com.chishenme.controller.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

public class UserControllerTest extends TestCase
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
	
	public void testCreateUser4() throws JSONException, IOException
	{
		URL url = new URL(urlPrefixString + "user/add?name=John@g&pwd=123456&confirm_pwd=123456");
		
		JSONObject json = new JSONObject(getHtml(url));
		assertEquals(4, json.get("code"));
	}
	
	public void testLogin0() throws JSONException, IOException
	{
		URL url = new URL(urlPrefixString + "user/login?name=tringchen@gai.com&pwd=123456");
		
		JSONObject json = new JSONObject(getHtml(url));
		assertEquals(0, json.get("code"));
	}
}
