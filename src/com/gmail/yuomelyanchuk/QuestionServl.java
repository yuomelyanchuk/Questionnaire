package com.gmail.yuomelyanchuk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class QuestionServl extends HttpServlet {

    static final String TEMPLATE="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Questionnaire</title>\n" +
            "</head>\n" +
            "<body>%s</body>\n" +
            "</html>";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firsName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean linux = "true".equals(req.getParameter("os"));
        boolean is64bit ="true".equals(req.getParameter("64bit"));
        UserAnswers.rezult.add(new UserAnswer(firstName,lastName,age,linux,is64bit));

        int questionOneRez=0;
        int questionTwoRez=0;
        for (UserAnswer rez : UserAnswers.rezult ){
            if(rez.isQuestionOneAns()){
                questionOneRez++;
            }
            if(rez.isQuestionTwoAns()){
                questionTwoRez++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Use linux: yes=");
        sb.append(questionOneRez);
        sb.append(",no=");
        sb.append(UserAnswers.rezult.size()-questionOneRez);
        sb.append("</p>");

        sb.append("<p>Use 64 bit os: yes=");
        sb.append(questionTwoRez);
        sb.append(",no=");
        sb.append(UserAnswers.rezult.size()-questionTwoRez);
        sb.append("</p>");

        resp.getWriter().println(String.format(TEMPLATE,sb.toString()));

    }
}
