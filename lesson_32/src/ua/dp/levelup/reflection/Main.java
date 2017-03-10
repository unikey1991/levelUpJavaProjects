package ua.dp.levelup.reflection;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Book book = new Book(1,"Book1",35,"Pushkin");

        Class bookClass = Book.class;  //получения экземпляра класса

        XMLParser parser = new XMLParser();
//        String bookAsXML = parser.toXML(book);
//        System.out.println(bookAsXML);

        Autor autor = new Autor("John","Cena",38);
        String autorAsXML = parser.toXML(autor);
        System.out.println(autorAsXML);

        Autor autorFromXML = (Autor) parser.parseXML(autorAsXML, Autor.class);
        System.out.println(autorFromXML.toString());


//        System.out.println("Book fields:");
//        Field[] fields =  bookClass.getFields();  //возвращает поля с паблик доступом
//        for (Field field:fields) System.out.println(field.getName());
//
//        System.out.println("Book declared fields:");
//        Field[] declaredFields =  bookClass.getDeclaredFields(); //возвращает все поля
//        for (Field field:declaredFields) System.out.println(field.getName());
//
//        System.out.println("Book methods:");
//        Method[] methods =  bookClass.getMethods();  //возвращает методы с паблик доступом
//        for (Method method:methods) System.out.println(method.getName());
//
//        System.out.println("Book declared methods:");
//        Method[] declaredMethods =  bookClass.getDeclaredMethods(); //возвращает все методы
//        for (Method method:declaredMethods) System.out.println(method.getName());


//        book.setAutor("Pushkin");
//
//        try {
//            Field field = bookClass.getDeclaredField("autor");
//            String autor = (String) field.get(book);
//            System.out.println(autor);
//
//            field.set(book, "Gogol");
//            String autor1 = (String) field.get(book);
//            System.out.println(autor1);
//
//
//
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            Field field1 = bookClass.getDeclaredField("id");
//            field1.setAccessible(true);
//
//            field1.set(book, 10L);
//            long id = (long) field1.get(book);
//
//            System.out.println(id);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        Field[] fields =  bookClass.getDeclaredFields();
//        for (Field field:fields) {
//            try {
//                field.setAccessible(true);
//                System.out.println("<"+field.getName()+">");
//                System.out.print("\t<to>"+field.get(book)+"</to>");
//                System.out.println("\r\n</"+field.getName()+">");
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
