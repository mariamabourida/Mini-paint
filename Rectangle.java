/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public class Rectangle extends AbstractShapeClass{

    public Rectangle(Point point, int width, int height) {
        super(point);
        this.width = width;
        this.height = height;
    }
    
    private int width, height;
    
    
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawRect(this.getPosition().x, this.getPosition().y, width, height);
        canvas.setColor(this.getFillColor());
        canvas.fillRect(this.getPosition().x, this.getPosition().y, width, height);
        
        
        int x = getPosition().x;
        int y = getPosition().y;
        if (this.isIsSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(x - 5, y - 5, 10, 10);
            canvas.fillRect(x + width - 5, y - 5, 10, 10);
            canvas.fillRect(x - 5, y + height - 5, 10, 10);
            canvas.fillRect(x + width - 5, y + height - 5, 10, 10);
        
    }
    }

    @Override
    public boolean contains(Point point) {
        int xp = this.getPosition().x;
        int yp = this.getPosition().y;
        int bottomLeftY = yp + height;
        int topRightX = xp + width;
        return point.x > xp && point.x < topRightX && point.y < bottomLeftY && point.y > yp;
    }

    @Override
    public void moveTo(Point point) {
        int dx = point.x - this.getDraggingPoint().x;
        int dy = point.y - this.getDraggingPoint().y;
        Point newPosition = new Point(this.getPosition().x + dx, this.getPosition().y + dy);
        this.setPosition(newPosition);
    }
    
    @Override
    public JSONObject toJson(){
    JSONObject obj = (JSONObject) super.toJson();
    obj.put("Width", width + "");
    obj.put("Height", height);
    obj.put("Type", "Rectangle");
    return obj;
}

  

 

    @Override
    public void resize(Point point) {
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        int xNew = point.x;
        int yNew = point.y;
        int dx = this.getDraggingPoint().x - xNew;
        int dy = this.getDraggingPoint().y- yNew;
        switch (this.onCorner(this.getDraggingPoint())) {
            case 1:
                height = height + dy;
                width = width + dx;
                this.setPosition(new Point(x - dx, y - dy));
                break;
            case 3:
                height = height - dy;
                width = width + dx;
                this.setPosition(new Point(x - dx, y));
                break;
            case 2:
                height = height + dy;
                width = width - dx;
                this.setPosition(new Point(x , y - dy));
                break;
            case 4:
                height = height - dy;
                width = width - dx;
                this.setPosition(new Point(x , y ));
                break;
            default:
                break;
        }
        if(width < 0){
            width =2;
            this.setPosition(new Point(x,y));
        }
        if(height <0){
            height =2;
            this.setPosition(new Point(x,y));
        }

    }

    @Override
    public int onCorner(Point p) {
        Point point2, point3, point4;
        point2 = new Point(this.getPosition().x + width, this.getPosition().y);
        point3 = new Point(this.getPosition().x, this.getPosition().y + height);
        point4 = new Point(this.getPosition().x + width, this.getPosition().y + height);
        java.awt.Rectangle squareCorner1 = new java.awt.Rectangle (this.getPosition().x -5 , this.getPosition().y - 5, 10,10);
        java.awt.Rectangle squareCorner2 = new java.awt.Rectangle (point2.x -5, point2.y -5, 10,10);
        java.awt.Rectangle squareCorner3 = new java.awt.Rectangle (point3.x -5, point3.y -5, 10,10);
        java.awt.Rectangle squareCorner4 = new java.awt.Rectangle (point4.x -5, point4.y -5, 10,10);
       
        if (squareCorner1.contains(p))
            return 1;
        if(squareCorner2.contains(p))
            return 2;
        if(squareCorner3.contains(p))
            return 3;
        if(squareCorner4.contains(p))
            return 4;
        return 0;    }
    
    
}
