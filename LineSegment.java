/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public class LineSegment extends AbstractShapeClass{
    Point point2;
    
    public LineSegment(Point point1, Point point2) {
        super(point1);
        this.point2 = point2;
    }
    
  //to colorize line from both fill and border color
    /*
    @Override
    public void setFillColor(Color color) {
        this.setColor(color);
    }

    @Override
    public Color getFillColor() {
        return this.getColor();
    }
*/
    
        @Override
    public void resize(Point point) {
      if(this.onCorner(this.getDraggingPoint()) == 1){
          this.setPosition(point);
      }  
        else if(this.onCorner(this.getDraggingPoint()) == 2){
         point2 =point;
      }
    }
    
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawLine(this.getPosition().x, this.getPosition().y, point2.x, point2.y);
    }

    @Override
    public boolean contains(Point point) {
        return Line2D.ptSegDist(this.getPosition().getX(), this.getPosition().getY(), point2.getX(), point2.getY(), point.getX(), point.getY()) <= 1.0;
    }

    @Override
    public void moveTo(Point point) {
        int dx = point.x - this.getDraggingPoint().x;
        int dy = point.y - this.getDraggingPoint().y;
        Point newPosition = new Point(this.getPosition().x + dx, this.getPosition().y + dy);
        this.setPosition(newPosition);
        point2 = new Point(point2.x + dx, point2.y + dy);
    }
    
    @Override
    public JSONObject toJson(){
    JSONObject obj = (JSONObject) super.toJson();
    JSONObject jpoint2 = new JSONObject();
    jpoint2.put("X", point2.x + "");
    jpoint2.put("Y", point2.y + "");
    obj.put("point2", jpoint2);
    obj.put("Type", "Line");
    return obj;
}

    @Override 
    public int onCorner(Point p){
        java.awt.Rectangle squareCorner1 = new java.awt.Rectangle (this.getPosition().x -5 , this.getPosition().y - 5, 10,10);
        java.awt.Rectangle squareCorner2 = new java.awt.Rectangle (point2.x -5, point2.y -5, 10,10);
        if (squareCorner1.contains(p))
            return 1;
        if(squareCorner2.contains(p))
            return 2;
        return 0;
    } 
}

    
      