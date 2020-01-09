package com.mr.zwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName EasyBuyStart
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/19
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan("com.mr.zwt.*.mapper")
public class EasyBuyStart {
    public static void main(String[] args) {
        SpringApplication.run(EasyBuyStart.class);

    }
}
