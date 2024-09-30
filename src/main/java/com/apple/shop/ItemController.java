package com.apple.shop;

import com.apple.shop.not.Note;
import com.apple.shop.not.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;


    @GetMapping("/list")
    public String list(Model model) {
       List<Item> result= itemRepository.findAll(); //테이블 모든 데이터 가져옴 List자료형으로 나온다
        model.addAttribute("itmes", result);

        return "list.html" ;
    }

    @GetMapping("/write")
    public String write() { return "write.html"; }

    @PostMapping("/add")
    public String writeadd(@RequestParam String title, @RequestParam Integer price) {
        itemService.saveItem(title, price);
        //        Item item = new Item(title, price);
        //        itmeRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) throws Exception{

         Optional<Item> result = itemRepository.findById(id);  //findById가 Optional을 반환함 그래서 Optional 쓰는 거임
         if(result.isPresent()){
             model.addAttribute("data", result.get());//Optional안에 값을 뽑으려면 .get을 사용해야 한다.
        }
        return "detail.html";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);  //findById가 Optional을 반환함 그래서 Optional 쓰는 거임
        if(result.isPresent()){
            model.addAttribute("data", result.get());//Optional안에 값을 뽑으려면 .get을 사용해야 한다.
        }
        return "update.html" ;
    }

    @PostMapping("/correction")
    public String correctionUpdate(@RequestParam Long id,
                                   @RequestParam String title,
                                   @RequestParam Integer price){
        itemService.updateItem(id,title,price);
        return "redirect:/list";
    }



}
