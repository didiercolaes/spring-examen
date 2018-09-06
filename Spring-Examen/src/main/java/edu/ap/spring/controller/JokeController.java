package edu.ap.spring.controller;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@Scope("session")
public class JokeController {

    String postUrl = "http://api.icndb.com/jokes/random";

    @Autowired
    JokeRepository repository;

   public JokeController() {
   }
       
   @RequestMapping("/joke")
   public String joke() {
	   return "addJoke";
   }
		   
   @PostMapping("/joke_post")
   public String joke_post(@RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           Model model){
       String urlparams = "?firstName=" + firstname + "&lastName=" + lastname;
       String joke = this.doPost(urlparams);


       model.addAttribute("joke", joke);

       repository.save(new Joke(joke));

	   return "jokelist";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }

    private String doPost(String urlParameters) {

        try {
            URL obj = new URL(postUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
