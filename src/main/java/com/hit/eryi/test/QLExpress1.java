package com.hit.eryi.test;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

public class QLExpress1 {
    @Test
    public void test1() throws Exception {

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
//        context.put("partsNum", 140);
//        context.put("hourNum", 170);
//        context.put("unitPrice", 30);
//        String express = "if  (partsNum>hourNum) then { map = new HashMap(); map.put('partsPrice',partsNum*unitPrice);map.put('hourPrice',hourNum*unitPrice);return map;} else {map = new HashMap(); map.put('partsPrice',partsNum*unitPrice/2);map.put('hourPrice',hourNum*unitPrice/2);return map;}";
//        context.put("parts_num", 140);
//        context.put("hour_num", 170);
//        context.put("unit_price", 130);
        context.put("unit_price",333);
        context.put("hour_num",3);
        String express = " if (hour_num < 10 and unit_price == 3) then {\n" +
                "    hour_price = 20;\n" +
                "    map = NewMap(\"hour_price\": hour_price);\n" +
                "    return map;\n" +
                "} else {\n" +
                "    parts_price = 3;\n" +
                "    hour_price = 40;\n" +
                "    map = NewMap(\"parts_price\": parts_price, \"hour_price\": hour_price);\n" +
                "    return map;\n" +
                "} ";
//        String express = "   if ( unit_price<100 )  then { hour_price=123; map = NewMap(\"hour_price\": hour_price); return map; } else if(unit_price>100 and unit_price<300 ) then { hour_price=456; map = NewMap(\"hour_price\": hour_price); return map; }  else { hour_price=789; map = NewMap(\"hour_price\": hour_price); return map; }  ";
//        String express = " if ( unit_price<100 )  then { hour_price=unit_price*hour_num; map = NewMap('hour_price': hour_price); return map; }  else { parts_price=700; map = NewMap('parts_price': parts_price); return map; } ";
        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);

    }

    @Test
    public void logicalTernaryOperationsTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        String express = "a+b";
        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);
    }
}
