package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private Map<Long, Book> map = new HashMap<>();

    @Autowired
    public Map<Long,Book>getMap(){
        return map;
    }
    public boolean insert(Book book){
        if(map.containsKey(book.getId())){
            return  false;
        }
        map.put(book.getId(),book);
        return true;
    }

    public boolean update(Book book){
        if(map.containsKey(book.getId())){
            return  false;
        }
        map.put(book.getId(),book);
        return true;
    }

    public boolean delete(Book book){
        if(map.containsKey(book.getId())){
            map.remove(book.getId());
            return true;
        }
        return  false;
    }

}
