package com.chishenme.dao.shoppinglist;

import java.awt.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.chishenme.model.shoppinglist.ShoppinglistItem;

public interface ShoppinglistItemMapper
{
	public void addShoppinglistItem(ShoppinglistItem shoppinglistItem);
	
	public ArrayList<ShoppinglistItem> getAllShoppinglistItems(@Param("creator_id") int creator_id);
	
	public ArrayList<ShoppinglistItem> getAllEnabledShoppinglistItems(@Param("creator_id") int creator_id);
	
	public ArrayList<ShoppinglistItem> getShoppinglistItemsByIds(int[] item_ids);
	
}
