package com.simplilearn.servlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "homeServlet", value = "/homePage")
public class HomeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("userName");
		out.print("Welcome " + n);
	}

}