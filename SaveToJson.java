/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;

/**
 *
 * @author maria
 */
public class SaveToJson {
    private JSONArray arr;
    private Canvas panel;
    
    public SaveToJson(Canvas panel) {
        this.panel = panel;
    }
public void save(File f){
    this.arr = new JSONArray();
    Shape [] shapes = panel.getShapes();
        for (Shape shape : shapes) {
            arr.add(shape.toJson());
        }
        try {
            FileWriter file = new FileWriter(f);
            file.write(arr.toJSONString());
            file.flush();
        } catch (IOException ex) {
        }
}    
    
}
