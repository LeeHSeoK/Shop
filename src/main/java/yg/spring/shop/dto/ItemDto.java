package yg.spring.shop.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.*;
import yg.spring.shop.constant.ItemSellStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;

    private String itemNm;                  // 상품 이름

    private int price;                      // 가격

    private int stockNumber;                //재고 수량

    private String itemDetail;              //상품 상세 설명

    private String itemSellStatus;  // 상품 판매 상태

    private LocalDateTime regTime;          // 등록 시간

    private LocalDateTime updateTime;       // 수정 시간
}
