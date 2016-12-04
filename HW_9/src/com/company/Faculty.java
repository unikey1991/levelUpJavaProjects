package com.company;

/*
 2) Объявить класс перечислений Faculty у которого будут свойства nameEn(строка), nameRu(строка),
    и элементы перечисления: GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW.

 */
public enum Faculty {
    GRYFFINDOR("Gryffindor","Гриффиндор"), SLYTHERIN("Slytherin","Слизерин"), HUFFLEPUFF("Hufflepuff","Хаффлпуф"), RAVENCLAW("Ravenclav","Равэнклав");


    String nameEn;
    String nameRu;

    Faculty(String nameEn, String nameRu) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }
}


