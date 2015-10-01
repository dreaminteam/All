package Parsers;

/**
 * Created by dreaminteam on 12.12.14.
 */
public class Doctor {

    public static int id;
    public String fam;
    public String name;
    public String otc;
    public String date;
    public int vdolid;
    public int specid;
    public double stav;

    public static void setId(int id) {
        Doctor.id = id;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtc(String otc) {
        this.otc = otc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVdolid(int vdolid) {
        this.vdolid = vdolid;
    }

    public void setSpecid(int specid) {
        this.specid = specid;
    }

    public void setStav(double stav) {
        this.stav = stav;
    }

    public static int getId() {

        return id;
    }

    public String getFam() {
        return fam;
    }

    public String getName() {
        return name;
    }

    public String getOtc() {
        return otc;
    }

    public String getDate() {
        return date;
    }

    public int getVdolid() {
        return vdolid;
    }

    public int getSpecid() {
        return specid;
    }

    public double getStav() {
        return stav;
    }

    @Override
    public String toString(){

        return "Name "+getName()+"\n"+"Fam "+getFam()+"\n"+"Otc "+getOtc()+"\n"+
                "Date "+getDate()+"\n"+"Vdolid "+getVdolid()+"\n"+"Specid "+getSpecid()+"\n"+
                "Stav "+getStav();

    }
}
