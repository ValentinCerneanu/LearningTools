/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


/**
 *
 * @author Valentin
 */
public class Tool {
    private int id;
    private String name;
    private String description;
    private String url;
    private String type;
    private String category;
    private boolean isWebBased;
    private boolean isFree;
    private ArrayList<String> subjects;
    private String author;

    public Tool(int id, String description, String url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }
    
    public Tool(int id, String name, String description, String url, String type, String category, boolean isWebBased, boolean isFree, ArrayList<String> subjects, String author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.type = type;
        this.category = category;
        this.isWebBased = isWebBased;
        this.isFree = isFree;
        this.subjects = subjects;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIsWebBased() {
        return isWebBased;
    }

    public void setIsWebBased(boolean isWebBased) {
        this.isWebBased = isWebBased;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
