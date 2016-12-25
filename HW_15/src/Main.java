import java.util.Objects;

public class Main {


    public static void main(String[] args) {



        try{ int d = 0;
            int a = 42 / d;
            int z = a + d;
        }catch (ArithmeticException e){
            System.out.println("Деление на ноль");
        }

        String szShortString = "123";

        try {
            char chr = szShortString.charAt(10);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("нет такого индекса");
        }


        try{
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42/a;
            int c[] = {1};
            c[42] = 99;
        }catch (ArithmeticException e){
            System.out.println("Деление на ноль " + e);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("index elementa massiva oob: "+e);
        }
        System.out.println("posle bloka try/catch.");



    }
}
