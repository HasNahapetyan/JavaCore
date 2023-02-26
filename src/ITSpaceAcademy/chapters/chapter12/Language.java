package ITSpaceAcademy.chapters.chapter12;

public enum Language { //սահմանափակ քանակությամբ հաստատուններ //singleton են // ընդունված է ստուգում անել== ով, ոչ թե equals()ով
    //բոլոր enum-ները ժառանգվում են Enum-ից

    HY("Armenia"),
    ENG,
    RU("Russia"),
    FR("France");
    private String country;
    Language(String country){
        this.country = country;
    }
    Language(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
