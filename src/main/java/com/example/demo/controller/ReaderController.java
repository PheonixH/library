package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: library
 * @className: CommonReaderController
 * @description: a common reader controller
 * @author: lov.moran
 * @date 2020-06-02 10:49
 */
@Slf4j
@RestController
@RequestMapping("/reader")
@Api(value = "Reader controller", tags = {"ReaderController"})
public class ReaderController {

    @ApiOperation(value = "just a test, return hello")
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
