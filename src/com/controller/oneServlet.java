package com.controller;

import com.dao.sushedao;
import com.entity.susheduixiang;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strsusheid=request.getParameter("susheid");
        String json="{}";
        String xyl;
        if (strsusheid != null && strsusheid.trim().length()>0) {
            sushedao dao=new sushedao();
            susheduixiang s=dao.sushebianhao(Integer.valueOf(strsusheid));
            ObjectMapper om = new ObjectMapper();
            json=om.writeValueAsString(s);
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}
