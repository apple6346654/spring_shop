package com.apple.shop;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //엔티티 설정
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Item {
    @Id //자동으로 unique= true 가 붙음
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql id값 자동증가
   private Long id;

    @Column(nullable = false, unique = true) //이 컬럼이 비어있으면 테이블에 입력을 막아라,
                                                // 컬럼값이 유니크 하니 않으면 테이블 입력 막아라
    private String title;
    private Integer price;   //public을 붙이지 않으면 같은 패키지 내에서만 사용가능함


    public Item(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public Item() {  //기본생성자는 왜 필요힘?
    }
}
