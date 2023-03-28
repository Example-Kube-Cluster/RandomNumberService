package examplekubecluster.randomnumberservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
@RestController
public class RandomNumberController {
  
  @GetMapping("/randomNumber")
  public double RandomNumber(){
    Random rand = new Random();

    return rand.nextInt(25); 
  }
}
