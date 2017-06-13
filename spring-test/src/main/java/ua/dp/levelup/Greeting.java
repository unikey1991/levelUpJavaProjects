package ua.dp.levelup;

/**
 * Created by unity on 13.06.2017.
 */
public class Greeting {

    private String message;

    public Greeting() {
    }

    public void setMessage (String message){
        this.message = message;
    }

    public void sayHello(){
        System.out.println(message);
    }
}
