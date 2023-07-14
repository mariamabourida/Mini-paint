/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class Canvas extends JPanel implements DrawingEngine{
    private ArrayList<Shape> shapeList;

    public Canvas() {
        shapeList = new ArrayList<>();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        refresh(g);
    }

    @Override
    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapeList.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapeList.toArray(Shape[]::new);
    }

    @Override
    public void refresh(Graphics canvas) {
        for(int i = 0; i < shapeList.size(); i++){
            shapeList.get(i).draw(canvas);
        }
    }

    @Override
    public ArrayList<Shape> getShapesList() {
        return shapeList;
    }

    
}
