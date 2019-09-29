package com.sda.springdemo;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<User> users = new ArrayList<>();

    public Controller() {

        users.add(new User("Piotr", "Nowak"));
    }
    //
    @GetMapping("/findUser")
public String findUser(@RequestParam String imie)
    {
        String znalezieni = "";

        for ( User user: users)
              {
                  if(user.getImie().equals(imie))
                      znalezieni = znalezieni+user.getImie()+" "+user.getNazwisko()+" ";
        }
        return znalezieni;
    }

    @GetMapping("/addUser")
    public String addUser(@RequestParam String imie, @RequestParam String nazwisko) {
        users.add(new User(imie, nazwisko));
        return imie+" "+nazwisko+" został dodany do bazy";
    }



}
