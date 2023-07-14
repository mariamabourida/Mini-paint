/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import java.awt.Point;

/**
 *
 * @author maria
 */
public interface Moveable {
    public void setDraggingPoint(Point point);
    public Point getDraggingPoint();
    public boolean contains (Point point);
    public void moveTo(Point point);
    public void resize(Point point);
    public int onCorner(Point p);
}
