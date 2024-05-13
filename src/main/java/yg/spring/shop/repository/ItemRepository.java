package yg.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yg.spring.shop.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

   List<Item> findByItemNm(String itemNm);

   List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

   List<Item> findByPriceLessThan(int price);

   List<Item> findByPriceLessThanOrderByPriceDesc(int price);

   //JPQL
   @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")    //*대신 변수명을 적어주어야한다,  %: 를 붙여서 변수로선언
   List<Item> findByDetail(@Param("itemDetail")String itemDetail);   // @Param을 통해서 이름을 지정해준다(같은이름이 생길것을 대비)

   //Native
   @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price asc", nativeQuery = true)
   List<Item> findByDetailNative(@Param("itemDetail")String itemDetail);
}
