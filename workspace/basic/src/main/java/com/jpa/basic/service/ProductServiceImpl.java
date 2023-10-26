package com.jpa.basic.service;

import com.jpa.basic.entity.Product;
import com.jpa.basic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Page<Product> getList(PageRequest pageRequest) {
        return productRepository.findAllWithPaging(pageRequest);
    }
}
