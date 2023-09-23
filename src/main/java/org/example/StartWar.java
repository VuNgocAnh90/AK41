package org.example;

public class StartWar {
//    {
//        "name": "Luke Skywalker",
//            "height": "172",
//            "mass": "77",
//            "hair_color": "blond",
//            "skin_color": "fair",
//            "eye_color": "blue",
//            "birth_year": "19BBY",
//            "gender": "male"
//    }

    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;

    public StartWar(String name, int height, int mass, String hairColor, String skinColor,
                    String eyeColor, String birthYear, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public void info(){
        System.out.printf("name: %s\n",this.name);
        System.out.printf("height: %s\n", this.height);
        System.out.printf("mass: %s\n", this.mass);
        System.out.printf("hairColor: %s\n", this.hairColor);
        System.out.printf("eyeColor: %s\n", this.eyeColor);
        System.out.printf("birthYear: %s\n", this.birthYear);
        System.out.printf("gender: %s\n", this.gender);
        System.out.println("--------------------------");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }
}
