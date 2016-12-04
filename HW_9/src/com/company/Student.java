package com.company;

/*
  3) Описать объект студента который должен обладать свойствами: имя(строка), фамилия(строка), возраст(число), язык(перечисление), факультет(перечисление).
 */
public class Student {
    String name;
    String surName;
    int age;
    Lang lang;
    Faculty faculty;


    Student(String name, String surName, int age, Lang lang, Faculty faculty) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.lang = lang;
        this.faculty = faculty;
    }

    /*
      4) Переопределить в классе студента метод toString() таким образом, чтобы в результате его вызова для объекта
         студента с выбранным языком EN возвращалась строка вида: "Ron Weasley is 24 years old and studying
         at Griffindor faculty". Либо, если язык был выбран RU возвращалась строка вида: "Ron Weasley 24 лет,
         студент факультета Гриффиндор".
     */

    @Override
    public String toString(){
        switch (lang){
            case EN:return name+" "+surName+" is "+age+" old and studying at "+faculty.getNameEn()+" faculty";
            case RU:return name+" "+surName+" "+age+" лет, студент факультета "+faculty.getNameRu();
            default:return "error";
        }
    }
}


