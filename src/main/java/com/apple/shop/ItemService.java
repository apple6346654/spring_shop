package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem( String title, Integer price){
         Item item = new Item(title,price);
         itemRepository.save(item);
    }

    public void updateItem(Long id, String title, Integer price){
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }


}
