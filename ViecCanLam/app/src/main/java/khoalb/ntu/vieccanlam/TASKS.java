package khoalb.ntu.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;

public class TASKS implements Serializable {
    String name;
    String date;
    String message;

    public TASKS(String name, String date, String message) {
        this.name = name;
        this.date = date;
        this.message = message;
    }

    public TASKS() {
        // Default constructor required for Firebase
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public HashMap<String, String> toFirebaseObject() {
        HashMap<String, String> taskObject = new HashMap<String, String>();
        taskObject.put("name", name);
        taskObject.put("date", date);
        taskObject.put("message", message);
        return taskObject;
    }
}
