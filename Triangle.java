/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.abs;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public class Triangle extends AbstractShapeClass{
    private Point point2, point3;

    public Triangle(Point point1 ,Point point2, Point point3) {
        super(point1);
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawPolygon(new int[] {this.getPosition().x, point2.x, point3.x}, new int[] {this.getPosition().y, point2.y, point3.y}, 3);
        canvas.setColor(this.getFillColor());
        canvas.fillPolygon(new int[] {this.getPosition().x, point2.x, point3.x}, new int[] {this.getPosition().y, point2.y, point3.y}, 3);
    }

    @Override
    public boolean contains(Point point) {
        int x1 = this.getPosition().x;
        int y1 = this.getPosition().y;
        int x2 = point2.x;
        int y2 = point2.y;
        int x3 = point3.x;
        int y3 = point3.y;
        int px = point.x;
        int py = point.y;
        double area = abs((x1 *(y2 - y3) + x2 *(y3 - y1) + x3 *(y1 - y2))/2.0); 
        double area1 = abs((px *(y2 - y3) + x2 *(y3 - py) + x3 *(py - y2))/2.0); 
        double area2 = abs((x1 *(y2 - py) + x2 *(py - y1) + px *(y1 - y2))/2.0);
        double area3 = abs((x1 *(py - y3) + px *(y3 - y1) + x3 *(y1 - py))/2.0); 
        return (area1 + area2 + area3) == area;
    }

    @Override
    public void moveTo(Point point) {
        int dx = point.x - this.getDraggingPoint().x;
        int dy = point.y - this.getDraggingPoint().y;
        Point newPosition = new Point(this.getPosition().x + dx, this.getPosition().y + dy);
        this.setPosition(newPosition);
        point2 = new Point(point2.x + dx, point2.y + dy);
        point3 = new Point(point3.x + dx, point3.y + dy);     
    }
    
    @Override
    public JSONObject toJson(){
    JSONObject obj = (JSONObject) super.toJson();
    JSONObject jpoint2 = new JSONObject();
    JSONObject jpoint3 = new JSONObject();
    jpoint2.put("X", point2.x + "");
    jpoint2.put("Y", point2.y + "");
    jpoint3.put("X", point3.x + "");
    jpoint3.put("Y", point3.y + "");
    obj.put("point2", jpoint2);
    obj.put("point3", jpoint3);
    obj.put("Type", "Triangle");
    return obj;
}
    @Override
    public void resize(Point point) {
        switch (this.onCorner(this.getDraggingPoint())) {
            case 1:
                this.setPosition(point);
                break;
            case 2:
                point2 =point;
                break;
            case 3:
                point3 =point;  
                break;
            default:
                break;
        }
    }

    @Override
    public int onCorner(Point p) {
        java.awt.Rectangle squareCorner1 = new java.awt.Rectangle (this.getPosition().x -5 , this.getPosition().y - 5, 10,10);
        java.awt.Rectangle squareCorner2 = new java.awt.Rectangle (point2.x -5, point2.y -5, 10,10);
        java.awt.Rectangle squareCorner3 = new java.awt.Rectangle (point3.x -5, point3.y -5, 10,10);
        if (squareCorner1.contains(p))
            return 1;
        if(squareCorner2.contains(p))
            return 2;
        if(squareCorner3.contains(p))
            return 3;
        return 0;
    }
}
