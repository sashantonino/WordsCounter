package com.gladunalexander.wordcounter.controller;

import com.gladunalexander.wordcounter.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import scala.Tuple2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.gladunalexander.wordcounter.utils.PropertyHolder.ROOT_DIR;

/**
 * Created by user on 08/09/2017.
 */

@RestController
public class WorldCounterController {

    @Autowired
    private WordCounterService wordCounterService;

    @PostMapping("/countWords")
    public List<Tuple2<Integer, String>> getTopTenWords(@RequestParam(value = "file") MultipartFile file){
        List<Tuple2<Integer, String>> words = null;
        if (file != null && !file.isEmpty()){
            String path = ROOT_DIR + File.separator + file.getOriginalFilename();
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            words = wordCounterService.countWords(path);
        }
        return words;
    }
}
