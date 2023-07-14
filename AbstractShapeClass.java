/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public abstract class AbstractShapeClass implements Moveable, Shape, Cloneable{
    private Point position;
    private Color borderColor;
    private Color fillColor;
    private Point draggingPoint;
    private boolean isSelected = false;

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    public AbstractShapeClass(Point position) {
        this.position = position;
    }
    
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

   
    @Override
    public Point getPosition() {
        return this.position;
    }

    
    @Override
    public void setColor(Color color) {
        this.borderColor = color;
    }

    
    @Override
    public Color getColor() {
        return this.borderColor;
    }
    
     
    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    
    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }
    
    @Override
    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        JSONObject point = new JSONObject();
        point.put("X", position.x + "");
        point.put("Y", position.y + "");
        obj.put("point1", point);
        String borderColorString = borderColor.toString();
        if(fillColor != null){
        String fillColorString = fillColor.toString();
        obj.put("FillColor", extractString(fillColorString));
        }
        obj.put("BorderColor", extractString(borderColorString));
        
        return obj;
    }
   
    private String extractString (String s){
        return s.substring(15, s.length()-1);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    
    
}
