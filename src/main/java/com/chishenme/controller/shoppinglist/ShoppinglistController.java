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
import com.chishenme.dao.shoppinglist.ShoppinglistItemMapper;
import com.chishenme.model.response.shoppinglist.ShoppinglistItemAddResponseModel;
import com.chishenme.model.response.shoppinglist.ShoppinglistItemsResponseModel;
import com.chishenme.model.shoppinglist.ShoppinglistItem;
import com.chishenme.util.MD5Encryption;
import com.chishenme.util.Strings;


@RestController
public class ShoppinglistController
{
	private static final Logger logger = LoggerFactory.getLogger(ShoppinglistController.class);
	
	private final String DEFAULT_SHOPPINGLIST_ITEM_QUANTITY_STRING = "1";

	@Autowired
	private ShoppinglistItemMapper shoppinglistItemMapper;
	
	@RequestMapping(value = "/shoppinglist/item/add")
	@Transactional
	public ShoppinglistItemAddResponseModel requestToAddShoppinglistItem(@RequestParam("creator_id") String creator_idString, @RequestParam("subject") String subject, 
			@RequestParam("quantity") String quantityString, @RequestParam("unit") String unit, @RequestParam("checksum") String checksum)
	{
		int code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_REQUEST_FINISHED_SUCCESSFULLY.getRtnCode();
		
		// creator_idString is null or empty or not an integer
		if (Strings.isNullOrEmpty(creator_idString)|| ! Strings.isInteger(creator_idString))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_CREATORID.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		int creator_id = Integer.parseInt(creator_idString);
		
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
		
		// checksum should equal to encrypted(creator_id + subject + quantity + unit)
		if (! checksum.equals(MD5Encryption.encrypt(creator_idString + subject + quantityString + unit)))
		{
			code = RtnCodeReference.SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_CHECKSUM_FAIL.getRtnCode();
			return new ShoppinglistItemAddResponseModel(code);
		}
		
		logger.debug(MD5Encryption.encrypt(creator_idString + subject + quantityString + unit));
		
		ShoppinglistItem shoppinglistItem = new ShoppinglistItem(creator_id, subject, quantity, unit, 
				RtnCodeReference.SHOPPINGLIST_ITEM_ENABLED.getRtnCode(), ModifierCodeReference.SELF.getModifierCode());
		shoppinglistItemMapper.addShoppinglistItem(shoppinglistItem);
		return new ShoppinglistItemAddResponseModel(code);
	}
	
	@RequestMapping(value = "/shoppinglist/items")
	@Transactional
	public ShoppinglistItemsResponseModel getShoppinglistItemsResponseModel(@RequestParam("entryids") String entry_ids, @RequestParam("checksum") String checksum)
	{
		return null;
	}
}
