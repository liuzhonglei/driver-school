package com.medal;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/17
 */
public class Lambda {

    private List<Pay> pays = new ArrayList<>();

    @Before
    public void setup(){
        Pay pay1 = new Pay();
        pay1.setDataUpdateDatetime(ZonedDateTime.now());
        pay1.setPay(100D);
        pays.add(pay1);

        Pay pay2 = new Pay();
        pay2.setDataUpdateDatetime(ZonedDateTime.now());
        pay2.setPay(200D);
        pays.add(pay2);
    }

    @Test
    public void testYear(){
        //1.
        List<Pay> ss =
                pays.stream()
                        .map(
                                t -> {
                                    t.setKey(String.valueOf(t.getDataUpdateDatetime().getYear()));
                                    return t;
                                }
                        ).collect(toList());
        ss.stream().forEach(s -> System.out.printf(s.toString()));

//        pays.stream().c
//        Map<String,List<Pay>> ss =
//                pays.stream()
//                .map(
//                        t -> {
//                            t.setKey(String.valueOf(t.getDataUpdateDatetime().getYear()));
//                            return t;
//                        }
//                )
//                .collect(groupingBy(t -> ,summarizingDouble(Pay::getPay)));
//
//        System.out.printf("ss");
    }
}
