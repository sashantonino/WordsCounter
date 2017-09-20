package com.gladunalexander.wordcounter.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

import static com.gladunalexander.wordcounter.utils.PropertyHolder.ROOT_DIR;


public class FilesCleanerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        FileUtils.cleanDirectory(new File(ROOT_DIR));
    }
}
