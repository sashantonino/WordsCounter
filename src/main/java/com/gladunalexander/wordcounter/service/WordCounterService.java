package com.gladunalexander.wordcounter.service;

import com.gladunalexander.wordcounter.utils.FilterUtils;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 08/09/2017.
 */

@Service
public class WordCounterService {

    private static final int FIRST_TEN = 10;

    @Autowired
    private JavaSparkContext sparkContext;

    public List<Tuple2<Integer, String>> countWords(String path){
        return sparkContext.textFile(path)
                .flatMap(line -> Arrays.asList(line.split("\\s")).iterator())
                .map(FilterUtils::withoutSpecialChars)
                .filter(w -> !StringUtils.isEmpty(w))
                .mapToPair(w -> new Tuple2<>(w, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .take(FIRST_TEN);
    }
}
