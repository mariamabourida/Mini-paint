/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public interface Shape{
        /* set position */
    public void setPosition(java.awt.Point position);

    public java.awt.Point getPosition();

    public JSONObject toJson();
    
    /* colorize */
    public void setColor(java.awt.Color color);

    public java.awt.Color getColor();

    public void setFillColor(java.awt.Color color);

    public java.awt.Color getFillColor();

    /* redraw the shape on the canvas */
    public void draw(java.awt.Graphics canvas);
    
    
}
