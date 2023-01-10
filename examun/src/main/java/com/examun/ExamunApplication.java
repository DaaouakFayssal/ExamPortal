package com.examun;

import com.examun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@SpringBootApplication(scanBasePackages = {"com.examun"})

public class ExamunApplication  implements CommandLineRunner {
    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(ExamunApplication.class, args);
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
    }
}