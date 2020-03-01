package com.ssergeev.services.impl;

import com.ssergeev.entities.Item;
import com.ssergeev.services.ItemService;
import com.ssergeev.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
}
