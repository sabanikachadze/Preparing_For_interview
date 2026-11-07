package org.example.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class StudentServlet extends HttpServlet {
    private static final Map<Long, String> STUDENTS = Map.of(1L, "Ann", 2L, "Bob");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String text = req.getParameter("id");
        if (text == null || text.isBlank()) {
            resp.setStatus(400);
            return;
        }

        try {
            long id = Long.parseLong(text);
            String student = STUDENTS.get(id);

            if (student == null) {
                resp.setStatus(404);
            } else {
                resp.setStatus(200);
                resp.setContentType("text/plain");
                resp.getWriter().write(student);
            }
        } catch (NumberFormatException e) {
            resp.setStatus(400);
        }


    }
}