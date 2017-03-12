package ua.dp.levelup.reflection;

import java.lang.reflect.Field;

/**
 * Created by java on 07.03.2017.
 */
public class XMLParser {

    public String toXML(Object obj) {
        StringBuilder builder = new StringBuilder();

        Class clazz = obj.getClass();

        builder.append(String.format("<%s>", clazz.getSimpleName()));
        builder.append("\r\n");


        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            for (Field f : fields) {
                if (f.isAnnotationPresent(ToXML.class)) {
                    f.setAccessible(true);
                    String fieldName = f.getName();

                    builder.append(String.format("\t<%s>", fieldName));
                    builder.append(f.get(obj));
                    builder.append(String.format("</%s>", fieldName));
                    builder.append("\r\n");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        builder.append(String.format("</%s>", clazz.getSimpleName()));

        return builder.toString();
    }

    public Object parseXML(String xml, Class clazz){
        try {
            Object obj = clazz.newInstance();

            String[] lines = xml.split("\r\n");

            for (String line: lines){
                if (line.equals(String.format("<%s", clazz.getSimpleName()))
                        || line.trim().equals(String.format("</%s", clazz.getSimpleName()))) continue;

                int startIndex = line.indexOf("<")+1;
                int endIndex = line.indexOf(">");
                String fieldName = line.substring(startIndex, endIndex);
                Field field = clazz.getDeclaredField(fieldName);




            }




        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }


        return null;
    }


}
