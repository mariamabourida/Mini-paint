/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.pow;
import org.json.simple.JSONObject;

/**
 *
 * @author maria
 */
public class Circle extends AbstractShapeClass{
    private int Vradius;
    private int Hradius;
    
       public Circle(Point point, int Vradius, int Hradius) {
        super(point);
        this.Vradius = Vradius;
        this.Hradius = Hradius;
    }
 
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x, this.getPosition().y, Hradius*2, Vradius*2);
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x, this.getPosition().y, Hradius*2, Vradius*2);
        int x = getPosition().x;
        int y = getPosition().y;        
        if (this.isIsSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(x - 5, y - 5, 10, 10); 
            canvas.fillRect(x + 2*Hradius - 5, y - 5, 10, 10);
            canvas.fillRect(x - 5, y + 2*Vradius - 5, 10, 10);
            canvas.fillRect(x +2* Hradius - 5, y + 2*Vradius - 5, 10, 10);
        
    }
     
    } 

    @Override
    public boolean contains(Point point) {
     return (pow((((int)point.getX()) - (this.getPosition().x + this.Hradius)), 2)/ pow(this.Hradius, 2))+ (Math.pow(((point.y) - (this.getPosition().y+this.Vradius)), 2)/ pow(this.Vradius, 2)) <=1;
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
    obj.put("Width", Hradius + "");
    obj.put("Height", Vradius);
    obj.put("Type", "Ellipse");
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
                Vradius = Vradius + dy;
                Hradius = Hradius + dx;
                this.setPosition(new Point(x - dx, y - dy));
                break;
            case 3:
                Vradius = Vradius - dy;
                Hradius = Hradius + dx;
                this.setPosition(new Point(x-dx , y +dy));
                break;
            case 2:
                Vradius = Vradius + dy;
                Hradius = Hradius - dx;
                this.setPosition(new Point(x +dx, y - dy));
                break;
            case 4:
                Vradius = Vradius - dy;
                Hradius = Hradius - dx;
                this.setPosition(new Point(x +dx, y +dy));
                break;
            default:
                break;
        }
                if(Hradius < 0){
            Hradius =2;
            this.setPosition(new Point(x,y));
        }
        if(Vradius <0){
            Vradius =2;
            this.setPosition(new Point(x,y));
        }
      
    }

    @Override
    public int onCorner(Point p) {
        Point point2, point3, point4;
        point2 = new Point(this.getPosition().x + 2*Hradius, this.getPosition().y);
        point4 = new Point(this.getPosition().x + 2* Hradius, this.getPosition().y + 2*Vradius);
        point3 = new Point(this.getPosition().x , this.getPosition().y + 2 * Vradius);
        
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
        return 0;    
    }
}
