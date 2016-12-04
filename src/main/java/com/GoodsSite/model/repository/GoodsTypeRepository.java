package com.GoodsSite.model.repository;

import com.GoodsSite.model.entity.GoodsType;
import com.google.gwt.user.client.rpc.IsSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long>, IsSerializable {

    @Query("select id from GoodsType id where id.category.categoryId = ?1")
    List<GoodsType> findAllByCategoryId(Long categoryId);

    @Query("select name from GoodsType name where name.goodsTypeName = ?1")
    GoodsType findByName(String name);
}
