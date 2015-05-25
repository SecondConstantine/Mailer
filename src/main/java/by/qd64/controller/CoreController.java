package by.qd64.controller;


import by.qd64.service.EmailManager;
import by.qd64.service.SettingManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class CoreController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SettingManager settingManager;

    @Autowired
    private EmailManager emailManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    public void test() {

    }

    @RequestMapping(value = "start", method = RequestMethod.POST)
    public
    @ResponseBody
    Object fileUpload(String subject, MultipartFile emails, MultipartFile template,
                      HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "text/plain; charset=UTF-8");
        StringBuilder whom = new StringBuilder();
        String mailBody;
        try (Scanner s = new Scanner(template.getInputStream()).useDelimiter("\\A")) {
            mailBody = s.hasNext() ? s.next() : "";
        }
        List<String> list = new ArrayList<>();
        try (Scanner s = new Scanner(emails.getInputStream())) {
            while (s.hasNext()) {
                String email = s.nextLine();
                list.add(email);
                whom.append(email + ", ");
            }
        }
        emailManager.send(list, subject, mailBody);
        return "Кому: " + whom + "\n\nСодержимое письма: \n" + mailBody;
    }
}
