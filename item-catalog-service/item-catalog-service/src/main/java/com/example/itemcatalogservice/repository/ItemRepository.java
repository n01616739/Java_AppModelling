package com.example.itemcatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.itemcatalogservice.entity.Item;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long> {
}
