package com.chishenme.controller.shoppinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chishenme.config.ModifierCodeReference;
import com.chishenme.config.RtnCodeReference;
import com.chishenme.dao.shoppinglist.ShoppinglistInfoMapper;
import com.chishenme.dao.shoppinglist.ShoppinglistItemMapper;
import com.chishenme.dao.shoppinglist.ShoppinglistMapper;
import com.chishenme.model.response.shoppinglist.ShoppinglistAddResponseModel;
import com.chishenme.model.response.shoppinglist.ShoppinglistItemAddResponseModel;
import com.chishenme.model.response.shoppinglist.ShoppinglistItemsResponseModel;
import com.chishenme.model.shoppinglist.Shoppinglist;
import com.chishenme.model.shoppinglist.ShoppinglistInfo;
import com.chishenme.model.shoppinglist.ShoppinglistItem;
import com.chishenme.util.MD5Encryption;
import com.chishenme.util.Strings;
import com.chishenme.util.Users;


@RestController
public class ShoppinglistController
{
	private static final Logger logger = LoggerFactory.getLogger(ShoppinglistController.class);
	
	private final String DEFAULT_SHOPPINGLIST_ITEM_QUANTITY_STRING = "1";

	@Autowired
	private ShoppinglistItemMapper shoppinglistItemMapper;
	
	@Autowired
	private ShoppinglistMapper shoppinglistMapper;
	
	@Autowired
	private ShoppinglistInfoMapper shoppinglistInfoMapper;
	
	
	@RequestMapping(value = "/shoppinglist/item/add")
	@Transactional
	public ShoppinglistItemAddResponseModel requestToAddShoppinglistItem(@RequestParam("creator_id") String creator_idString, 
			@RequestParam("shoppinglist_id") String shoppinglist_idString, @RequestParam("subject") String subject, 
			@RequestParam("quantity") String quantityString, @RequestParam("unit") String unit, @RequestParam("checksum") String checksum)
	{
		int code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_REQUEST_FINISHED_SUCCESSFULLY.getRtnCode();
		
		// creator_idString is null or empty or not an integer
		if (Strings.isNullOrEmpty(creator_idString)|| ! Users.isValidUserId(creator_idString))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_CREATORID.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		int creator_id = Integer.parseInt(creator_idString);
		
		// shoppinglist_idString is null or empty or not an integer
		if (Strings.isNullOrEmpty(shoppinglist_idString) || !Strings.isInteger(shoppinglist_idString))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_SHOPPINGLISTID.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		int shoppinglist_id = Integer.parseInt(shoppinglist_idString);
		
		// subject is null or empty
		if (Strings.isNullOrEmpty(subject))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_SUBJECT.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		
		// quantityString is null or empty or not an integer
		if (Strings.isNullOrEmpty(quantityString))
		{
			quantityString = DEFAULT_SHOPPINGLIST_ITEM_QUANTITY_STRING;
		}
		else if (! Strings.isInteger(quantityString))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_QUANTITY.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		int quantity = Integer.parseInt(quantityString);
		
		// unit is null or empty
		if (Strings.isNullOrEmpty(unit))
		{
			unit = "";
		}
		
		// checksum is null or empty
		if (Strings.isNullOrEmpty(checksum))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_CHECKSUM_IS_NULL_OR_EMPTY.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		
		// checksum should equal to encrypted(creator_id + shoppinglist_idString + subject + quantity + unit)
		if (! checksum.equals(MD5Encryption.encrypt(creator_idString + shoppinglist_idString + subject + quantityString + unit)))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_CHECKSUM_FAIL.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		
		// add shoppinglistitem to TABLE shoppinglist_item
		ShoppinglistItem shoppinglistItem = new ShoppinglistItem(creator_id, subject, quantity, unit, 
				RtnCodeReference.SHOPPINGLIST_ITEM_ENABLED.getRtnCode(), ModifierCodeReference.SELF.getModifierCode());
		shoppinglistItemMapper.addShoppinglistItem(shoppinglistItem);
		
		// add shoppinglistitem item_reference_id to TABLE shoppinglist_info
		long item_id = shoppinglistItem.getEntry_id();
		ShoppinglistInfo shoppinglistInfo = new ShoppinglistInfo(shoppinglist_id, item_id, ModifierCodeReference.SELF.getModifierCode());
		shoppinglistInfoMapper.addShoppinglistInfo(shoppinglistInfo);
		return new ShoppinglistItemAddResponseModel(code);
	}
	
	@RequestMapping(value = "/shoppinglist/items")
	@Transactional
	public ShoppinglistItemsResponseModel getShoppinglistItemsResponseModel(@RequestParam("entryids") String entry_ids, @RequestParam("checksum") String checksum)
	{
		return null;
	}
	
	@RequestMapping(value = "/shoppinglist/add")
	@Transactional
	public ShoppinglistAddResponseModel requestToAddShoppinglist(@RequestParam("creator_id") String creator_idString, @RequestParam("subject") String subject, @RequestParam("checksum") String checksum)
	{
		int code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_REQUEST_FINISHED_SUCCESSFULLY.getRtnCode();
		
		// creator_idString is null or empty or not valid
		if (Strings.isNullOrEmpty(creator_idString) || !Users.isValidUserId(creator_idString))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_INVALID_CREATORID.getRtnCode();
			return new ShoppinglistAddResponseModel(code);
		}
		int creator_id = Integer.parseInt(creator_idString);
		
		// subject is null or empty
		if (Strings.isNullOrEmpty(subject))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_INVALID_SUBJECT.getRtnCode();
			return new ShoppinglistAddResponseModel(code);
		}
		
		// checksum is null or empty
		if (Strings.isNullOrEmpty(checksum))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_CHECKSUM_IS_NULL_OR_EMPTY.getRtnCode();
			return new ShoppinglistAddResponseModel(code);
		}
		
		// checksum should equal to encrypted(creator_idString + subject)
		if (! checksum.equals(MD5Encryption.encrypt(creator_idString + subject)))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_CHECKSUM_FAIL.getRtnCode();
			return new ShoppinglistAddResponseModel(code);
		}
		
		// add a shoppinglist into TABLE shoppinglist
		Shoppinglist shoppinglist = new Shoppinglist(creator_id, subject, RtnCodeReference.SHOPPINGLIST_ENABLED.getRtnCode(), ModifierCodeReference.SELF.getModifierCode());
		shoppinglistMapper.addShoppinglist(shoppinglist);
		return new ShoppinglistAddResponseModel(code);
	}
}
