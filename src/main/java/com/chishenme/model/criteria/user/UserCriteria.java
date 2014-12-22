package com.chishenme.model.criteria.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCriteria
{
	private static final String USER_NAME_CRITERIA = "^.*[A-Za-z0-9\\w_-]+.*$";
	private static final String PASSWORD_CRITERIA = "^.*[A-Za-z0-9\\w_-]+.*$";
	private static final String EMAIL_CRITERIA = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
	private static Pattern pattern;
	private static Matcher matcher;
	
	public static boolean isValidUserNameFormat(String candidate_text)
	{
		return isMatched(USER_NAME_CRITERIA, candidate_text);
	}
	
	public static boolean isValidPasswordFormat(String candidate_text)
	{
		return isMatched(PASSWORD_CRITERIA, candidate_text);
	}
	
	public static boolean isValidEmailFormat(String candidate_text)
	{
		return isMatched(EMAIL_CRITERIA, candidate_text);
	}
	
	private static boolean isMatched(String criteria, String candidate_text)
	{
		pattern = Pattern.compile(criteria);
		matcher = pattern.matcher(candidate_text);
		return matcher.matches();
	}
}
