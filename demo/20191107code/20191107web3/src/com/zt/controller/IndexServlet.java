package com.zt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/index")
@WebServlet(name="IndexServlet",urlPatterns="/index")
public class IndexServlet extends HttpServlet{
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("IndexServlet service...");
    }
}
