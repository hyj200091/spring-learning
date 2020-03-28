package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/24
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("list")
    public String home(Model model) {
        Book[] books = {
                new Book(1, "小行星掉在下午", "https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20200324211317.png", "小说/短篇集", "沈大成", "一生的改变就是从这个微不足道的夜晚开始的"),
                new Book(2, "饱食穷民", "https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20200324211725.png", "日本/社会", "[日]斋藤茂男", "看看被怪兽般膨胀的泡沫经济挤碎在旁的人们，同时审视一下洪流中的我们自己"),
                new Book(3, "动物帝国", "https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20200324211808.png", "科幻 / 漫画", "[法] 恩基·比拉", "经典母题的漫画诠释"),
                new Book(4, "马可瓦尔多", "https://soft1851.oss-cn-beijing.aliyuncs.com/markdown/20200324212011.png", "意大利文学/小说", "[意] 伊塔洛·卡尔维诺", "泥沼中的点滴诗意"),
        };
        List<Book> bookList = Arrays.asList(books);
        model.addAttribute("bookList", bookList);
        return "list";
    }
}
