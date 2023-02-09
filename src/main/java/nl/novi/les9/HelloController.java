package nl.novi.les9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Maak een restcontroller annotatie die springboot verteld om een (controller) gatekeeper component te implementeren in de klasse.

@RestController
public class HelloController {
    private String myName;

    //Maak een method en vertel springboot wanneer de method aangeroepen worden door de @GetMapping annotatie.
    //@GetMapping maakt het mogelijk als er een GET req wordt gedaan een pad op te geven welke gekoppeld kan worden aan de method. De client kan dan navigeren naar deze pad.

    @GetMapping("hello")
    public String sayHello(@RequestParam(required = false) String name){
        //Parameter (String name) meegeven door @RequestParam en in je browser (door URL parameters) door een vraagteken in de URL en spatie door %20 in de URL
        //Parameter optioneel maken door (required = false)

        if(name == null){
            return "Hello stranger";
        }
        else {
            return "Hello " + name;
        }
    }

    //@PostMapping maakt het mogelijk om informatie aan te maken op de webserver. PostMapping heeft de pad "save".
    @PostMapping("save")
    public String saveName(@RequestParam String name) {
        this.myName = name;
        return "Name saved";
    }

    // @GetMapping met pad retrieve gebruiken om de informatie weer op de halen van de server.
    //this. verwijst naar controller object waarin je nu zit.

    @GetMapping("retrieve")
    public String retrieveName(){
        return this.myName;
    }

    //Nu twee endpoints aangemaakt voor de naam: eentje om de naam op te slaan (save) in de controller en een eentje om de naam weer terug te kunnen lezen (retrieve).
    //Met browser kun je retrieve pad aanroepen, dit is een GET request (regel 40/41), echter krijg je in eerste instantie een lege pagina aangezien myName nog geen waarde heeft, want dan zou je de "save" (regel31) pad moeten gebruiken.
    //Probleem die nu ontstaat: vanuit de browser / webserver kun je geen POST request doen! Je kunt in de browser / webserver wel een GET request doen.
    //Oplossing: Tool om de POST request te kunnen doen naar de webserver: POSTMAN
    //POSTMAN maakt het mogelijk je requests te POSTEN (versturen) naar de webserver en zo je service te testen!

}
