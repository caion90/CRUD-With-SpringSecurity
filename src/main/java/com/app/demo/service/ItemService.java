package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Item;
import com.app.demo.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

    
    @Service
    public class ItemService {
        @Autowired
        private ItemRepository itemRepository;
    
        public List<Item> getAllItems() {
            return itemRepository.findAll();
        }
    
        public Optional<Item> getItemById(Long id) {
            return itemRepository.findById(id);
        }
    
        public Item saveItem(Item item) {
            return itemRepository.save(item);
        }
    
        public void deleteItem(Long id) {
            itemRepository.deleteById(id);
        }
    }