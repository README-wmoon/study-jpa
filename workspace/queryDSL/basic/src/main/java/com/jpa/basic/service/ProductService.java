package com.jpa.basic.service;

import com.jpa.basic.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {
    public Page<Product> getList(PageRequest pageRequest);
}
