package com.GoodsSite.model.repository;

import com.GoodsSite.model.entity.Category;
import com.google.gwt.user.client.rpc.IsSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, IsSerializable {

    @Query("select name from Category name where name = ?1")
    Category findByName(String name);
}
