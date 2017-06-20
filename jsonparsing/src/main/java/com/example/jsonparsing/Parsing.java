
package com.example.jsonparsing;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parsing {

    @SerializedName("NewLang")
    @Expose
    private String newLang;
    @SerializedName("famous")
    @Expose
    private String famous;
    @SerializedName("OldLang")
    @Expose
    private List<String> oldLang = null;
    @SerializedName("courses")
    @Expose
    private List<Course> courses = null;
    @SerializedName("studentname")
    @Expose
    private Studentname studentname;

    public String getNewLang() {
        return newLang;
    }

    public void setNewLang(String newLang) {
        this.newLang = newLang;
    }

    public String getFamous() {
        return famous;
    }

    public void setFamous(String famous) {
        this.famous = famous;
    }

    public List<String> getOldLang() {
        return oldLang;
    }

    public void setOldLang(List<String> oldLang) {
        this.oldLang = oldLang;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Studentname getStudentname() {
        return studentname;
    }

    public void setStudentname(Studentname studentname) {
        this.studentname = studentname;
    }

}
