package com.GoodsSite.model.repository;


import com.GoodsSite.model.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>,Serializable {
    @Query("select id from Goods id where id.goodsType.goodsTypeId = ?1")
    List<Goods> findAllByGoodsTypeId(Long goodsTypeId);
}
