### Shoppinglist设计

一个`shoppinglist`（`TABLE shoppinglist`）有一个唯一的`creator`（`creator_id`）

一个`shoppinglist`下的所有`item`在（`TABLE shoppinglist_item`）中保存

这个`creator`可以在`TABLE shoppinglist_share_with`中设置将这个`shoppinglist`分享给好友A，B，C（`friend_id`）

好友A，B，C可以对该`shoppinglist`下的item进行增、删、改。

好友A，B，C在`TABLE shoppinglist_item`对`item`进行增、删、改的时候`creator_id`指的是A，B，C的id不是该`shoppinglist`的`creator_id`



