package vttp2022.nusiss.April5Giphy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.nusiss.April5Giphy.models.Giphy;
import vttp2022.nusiss.April5Giphy.services.GiphyService;

@Controller
@RequestMapping("/search")
public class GiphyController {

    @Autowired
    private GiphyService giphySvc;
    
    @GetMapping
    public String search(
        @RequestParam(name="q") String q,
        @RequestParam(name="limit", defaultValue = "10") Integer limit,
        @RequestParam(name="offset", defaultValue = "0") Integer offset,
        @RequestParam(name="rating") String rating,
        @RequestParam(name="lang") String lang,
        @RequestParam(name="width") String width,
        Model model
    ){
        Optional <List<Giphy>> giphy = giphySvc.findGiphy(q, limit, offset, rating, lang, width);

        if(giphy.isEmpty()){
            return "404";
        }

        List<Giphy> validGiphy = giphy.get();
        model.addAttribute("giphyList",validGiphy);
        return "result";
    }

}
