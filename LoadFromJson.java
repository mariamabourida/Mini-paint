/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author maria
 */
public class LoadFromJson {
    private Canvas panel;
    private Paint paint;
    
    public LoadFromJson(Canvas panel, Paint p) {
        this.panel = panel;
        this.paint = p;
    }
    
    public void load(File f) throws IOException{
    paint.setIndex(0);
    ((Canvas)panel).getShapesList().clear();
    paint.emptyComboBox();
    ((Canvas)panel).repaint();
    JSONParser parser = new JSONParser();
    try(FileReader reader = new FileReader(f)){
    Object obj = parser.parse(reader);
    JSONArray arr = (JSONArray) obj;
    arr.forEach(e -> extract((JSONObject) e));

}catch(FileNotFoundException e){
    
}catch(IOException e){
    
}catch(ParseException e){   
}
}
    
    private void extract(JSONObject e){

        JSONObject obj = (JSONObject)e.get("point1");
        int x = Integer.parseInt((String) obj.get("X"));
        int y = Integer.parseInt((String) obj.get("Y"));
        Point p1 = new Point(x,y);
        Object shape = e.get("Type");
        
        
        
        Color fill = null;
        String borderS = e.get("BorderColor").toString();
        String [] borderRGB = borderS.substring(0, borderS.length()).split(",");
        String[] borderR = borderRGB[0].split("=");
        String [] borderG = borderRGB[1].split("=");
        String [] borderB = borderRGB[2].split("=");
        Color border = new Color(Integer.parseInt(borderR[1]),Integer.parseInt(borderG [1]),Integer.parseInt(borderB[1]));
       if(e.get("FillColor") != null){
        String fillS = e.get("FillColor").toString();
        String [] fillRGB = fillS.substring(0, fillS.length()).split(",");
        String [] fillR = fillRGB[0].split("=");
        String [] fillG = fillRGB[1].split("=");
        String [] fillB = fillRGB[2].split("=");
        fill = new Color(Integer.parseInt(fillR[1]),Integer.parseInt(fillG[1]),Integer.parseInt(fillB[1]));
       }
       
       
       
        if(shape.equals("Ellipse")){
            int height =  Integer.parseInt(e.get("Height").toString());
            int width =  Integer.parseInt(e.get("Width").toString());
            
            Circle c = new Circle(p1, height, width);
            c.setColor(border);
            c.setFillColor(fill);
            paint.DrawAndAdd("Ellipse ", c);
        }
        if(shape.equals("Rectangle")){
            int height =  Integer.parseInt(e.get("Height").toString());
            int width =  Integer.parseInt(e.get("Width").toString());
            
            Rectangle r = new Rectangle(p1, height, width);
            r.setColor(border);
            r.setFillColor(fill);
            paint.DrawAndAdd("Rectangle ", r); 
        }
        if(shape.equals("Triangle")){
        obj = (JSONObject)e.get("point2");
        x = Integer.parseInt((String) obj.get("X"));
        y = Integer.parseInt((String) obj.get("Y"));
        Point p2 = new Point(x,y);
        obj = (JSONObject)e.get("point3");
        x = Integer.parseInt((String) obj.get("X"));
        y = Integer.parseInt((String) obj.get("Y"));
        Point p3 = new Point(x,y);
        Triangle t = new Triangle(p1, p2, p3);
        t.setColor(border);
        t.setFillColor(fill);
        paint.DrawAndAdd("Triangle ", t);
        }
        
        if(shape.equals("Line")){
        obj = (JSONObject)e.get("point2");
        x = Integer.parseInt((String) obj.get("X"));
        y = Integer.parseInt((String) obj.get("Y"));
        Point p2 = new Point(x,y);   
        LineSegment l = new LineSegment(p1, p2);
        l.setColor(border);
        l.setFillColor(fill);
        paint.DrawAndAdd("Line ", l);
        }
    }
}
