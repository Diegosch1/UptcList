package co.edu.uptc.ejercicio1.controllers;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.ejercicio1.models.Node;
import co.edu.uptc.ejercicio1.models.Person;
import co.edu.uptc.ejercicio1.models.UptcList;
import co.edu.uptc.ejercicio1.models.UptcList.UptcListIterator;

@RestController
@RequestMapping("/")
public class MessageController {
    @GetMapping("/")
    public String runCode() {
        UptcList<String> list = new UptcList<>();

        String t1 = "text1";
        String t2 = "text2";
        String t3 = "text3";
        String t4 = "text4";
        
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        return "<br><br><br><br><br><br><div style=\"display: flex; justify-content: center; align-items: center;\"><h1 style=\"width: 300px; font-family: arial;\">Hope this thing does not explode man</h1><img src=\"https://s3.getstickerpack.com/storage/uploads/sticker-pack/funny-meme-gif-pack-small-version/sticker_3.gif?b353a73c46798a7e57d4b083aac5390b\" style=\"border-radius: 30px; width: 300px;\"></div>";

    }
}
