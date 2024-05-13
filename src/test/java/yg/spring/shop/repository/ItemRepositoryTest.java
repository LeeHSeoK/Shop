package yg.spring.shop.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yg.spring.shop.constant.ItemSellStatus;
import yg.spring.shop.entity.Item;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 생성 테스트")
    public void createItemTest(){
        Item item = Item.builder()
                .itemNm("테스트 상품")
                .price(10000)
                .stockNumber(100)
                .itemDetail("테스트 상품 상세 설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .regTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        System.out.println("=================== item : "+item);
        Item savedItem = itemRepository.save(item);
        System.out.println("=================== savedItem : "+savedItem);

    }

    public void createItemList(){
        for(int i = 1; i <= 10; i++){
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i )
                    .stockNumber(100 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .regTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();

            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("상품 이름 검색 테스트")
    public void findByItemTest(){
        createItemList();

        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
//        for (Item item : itemList) {
//            System.out.println(item);
//        }
//        itemList.forEach((item -> System.out.println(item)));
        itemList.forEach(System.out::println);
    }


    @Test
    @DisplayName("OR 테스트")
    public void findByItemNmOrItemDetailTest(){
        createItemList();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품2", "테스트 상품 상세 설명8");
        itemList.forEach((item)->{
            System.out.println(item);
        });
    }

    @Test
    @DisplayName("LessThan 테스트")
    public void findByItemNmLessThanTest(){
        createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);
        itemList.forEach((item)->{
            System.out.println(item);
        });
    }

    @Test
    @DisplayName("OrderBy 테스트")
    public void findByPriceLessThanOrderByPriceDesc(){
        createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
        itemList.forEach((item)->{
            System.out.println(item);
        });
    }

    @Test
    @DisplayName("JPQL 테스트")
    public void findByDetailTest(){
        createItemList();
        List<Item> itemList = itemRepository.findByDetail("1");
        itemList.forEach((item)->{
            System.out.println(item);
        });
    }

    @Test
    @DisplayName("Native 테스트")
    public void findByDetailNativeTest(){
        createItemList();
        List<Item> itemList = itemRepository.findByDetailNative("1");
        itemList.forEach((item)->{
            System.out.println(item);
        });
    }
}