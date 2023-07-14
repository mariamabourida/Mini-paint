/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Shapes;

import java.awt.Point;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author maria
 */
public class Paint extends javax.swing.JFrame implements Node{
    
    private int index = 0;
    private ColorizeOptions colorizeWindow;
    private LineOptions lineWindow;
    private CircleOptions circleWindow;
    private RectangleOptions rectangleWindow;
    private SquareOptions squareWindow;
    private TriangleOptions triangleWindow;
    private Node parent;
    boolean inside, resize;
    private SaveToJson saveJson;
    private LoadFromJson loadJson;
   

    public void setIndex(int index) {
        this.index = index;
    }
    
    
    public void DrawAndAdd(String name, Shape s){
        ((Canvas)panel).addShape(s);
        panel.repaint();
        index++;
        ComboBox.addItem(name + index);
    }
   
    public void emptyComboBox(){
        ComboBox.removeAllItems();
    }
    
    /**
     * Creates new form Paint
     */
    public Paint() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        panel = new Canvas();
        DrawOval = new javax.swing.JButton();
        DrawLineSegment = new javax.swing.JButton();
        DrawSquare = new javax.swing.JButton();
        DrawRectangle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        Colorize = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        DrawTriangle = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        load = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vector Drawing Application");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        DrawOval.setText("Oval");
        DrawOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawOvalActionPerformed(evt);
            }
        });

        DrawLineSegment.setText("LineSegment");
        DrawLineSegment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawLineSegmentActionPerformed(evt);
            }
        });

        DrawSquare.setText("Square");
        DrawSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawSquareActionPerformed(evt);
            }
        });

        DrawRectangle.setText("Rectangle");
        DrawRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawRectangleActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        ComboBox.setName("Choose Shape"); // NOI18N
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        Colorize.setText("Colorize");
        Colorize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorizeActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        DrawTriangle.setText("Triangle");
        DrawTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawTriangleActionPerformed(evt);
            }
        });

        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyTyped(evt);
            }
        });

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        load.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        load.setText("load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        jMenu1.add(load);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(copy)
                                .addComponent(Colorize))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Delete)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DrawOval)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DrawTriangle)
                        .addGap(29, 29, 29)
                        .addComponent(DrawLineSegment)
                        .addGap(28, 28, 28)
                        .addComponent(DrawSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DrawRectangle))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DrawRectangle)
                        .addComponent(DrawSquare))
                    .addComponent(DrawLineSegment, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DrawOval)
                        .addComponent(DrawTriangle)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Colorize)
                            .addComponent(Delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(copy))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DrawOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawOvalActionPerformed
        circleWindow = new CircleOptions();
        circleWindow.setParentNode(this);
        this.setVisible(false);
        circleWindow.setVisible(true);
     
    }//GEN-LAST:event_DrawOvalActionPerformed

    private void DrawLineSegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawLineSegmentActionPerformed
        lineWindow = new LineOptions();
        lineWindow.setParentNode(this);
        this.setVisible(false);
        lineWindow.setVisible(true);
    }//GEN-LAST:event_DrawLineSegmentActionPerformed

    private void ColorizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorizeActionPerformed
        if(ComboBox.getItemCount() != 0){
        Shape[] shapes = ((Canvas)panel).getShapes();
        colorizeWindow = new ColorizeOptions(shapes[ComboBox.getSelectedIndex()], (Canvas) panel);
        colorizeWindow.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please draw a shape to colorize!");
        }
    }//GEN-LAST:event_ColorizeActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void DrawRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawRectangleActionPerformed
        rectangleWindow = new RectangleOptions();
        rectangleWindow.setParentNode(this);
        this.setVisible(false);
        rectangleWindow.setVisible(true);
    }//GEN-LAST:event_DrawRectangleActionPerformed

    private void DrawSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawSquareActionPerformed
        squareWindow = new SquareOptions();
        squareWindow.setParentNode(this);
        this.setVisible(false);
        squareWindow.setVisible(true);
    }//GEN-LAST:event_DrawSquareActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(ComboBox.getItemCount() != 0){
        Shape[] shapes = ((Canvas)panel).getShapes();
        ((Canvas)panel).removeShape(shapes[ComboBox.getSelectedIndex()]);
        ((Canvas)panel).repaint();
        ComboBox.removeItemAt(ComboBox.getSelectedIndex());
        //index--;
        }
        else{
            JOptionPane.showMessageDialog(null, "No shapes drawn to be deleted");
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
        Shape s[] = ((Canvas)panel).getShapes();
        inside = false;
        resize = false;
        
        Point p = evt.getPoint();
        for(int i = 0; i < s.length; i++){
            ((AbstractShapeClass) s[i]).setIsSelected(false);
            repaint();
           if(((AbstractShapeClass) s[i]).onCorner(p) == 1 || ((AbstractShapeClass) s[i]).onCorner(p) == 2 || ((AbstractShapeClass) s[i]).onCorner(p) == 3 || ((AbstractShapeClass) s[i]).onCorner(p) == 4)
           {
               resize = true;
               ((AbstractShapeClass) s[i]).setDraggingPoint(p);
               ((AbstractShapeClass) s[i]).setIsSelected(true);
               ComboBox.setSelectedIndex(i);
               repaint();
           }
           else if(((AbstractShapeClass) s[i]).contains(p)){
               ComboBox.setSelectedIndex(i);
               ((AbstractShapeClass)s[i]).setDraggingPoint(p);
               inside = true;
               ((AbstractShapeClass) s[i]).setIsSelected(true);
               repaint();
               }
               
           }
        
    }//GEN-LAST:event_panelMousePressed

    private void DrawTriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawTriangleActionPerformed
        triangleWindow = new TriangleOptions();
        triangleWindow.setParentNode(this);
        this.setVisible(false);
        triangleWindow.setVisible(true);
    }//GEN-LAST:event_DrawTriangleActionPerformed

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        Shape s[] = ((Canvas)panel).getShapes();
        Point currentPoint = evt.getPoint();
        
            if(resize){
              ((AbstractShapeClass)s[ComboBox.getSelectedIndex()]).resize(currentPoint);
              ((AbstractShapeClass)s[ComboBox.getSelectedIndex()]).setDraggingPoint(currentPoint);
              panel.repaint();
            }
            else if (inside){
        ((AbstractShapeClass)s[ComboBox.getSelectedIndex()]).moveTo(currentPoint);
        ((AbstractShapeClass)s[ComboBox.getSelectedIndex()]).setDraggingPoint(currentPoint);
        panel.repaint();
        }
    
    }//GEN-LAST:event_panelMouseDragged

    private void panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseReleased

    private void jMenu1MenuKeyTyped(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu1MenuKeyTyped

    }//GEN-LAST:event_jMenu1MenuKeyTyped

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    saveJson = new SaveToJson((Canvas)panel);
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setAcceptAllFileFilterUsed(false);
    FileFilter filter = new FileNameExtensionFilter("json file", new String[]{"json"});
    fileChooser.setFileFilter(filter);
    fileChooser.showSaveDialog(this);
    if(fileChooser.getSelectedFile() != null){
    saveJson.save(fileChooser.getSelectedFile());
    }
    }//GEN-LAST:event_saveActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
      loadJson = new LoadFromJson((Canvas)panel, this);
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setAcceptAllFileFilterUsed(false);
      FileFilter filter = new FileNameExtensionFilter("json file", new String[]{"json"});
      fileChooser.setFileFilter(filter);
      fileChooser.showOpenDialog(this);
      if(fileChooser.getSelectedFile() != null){
        try {
            loadJson.load(fileChooser.getSelectedFile());
        } catch (IOException ex) {
        }  
      }
    }//GEN-LAST:event_loadActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        Shape shapes[] = ((Canvas)panel).getShapes();
        AbstractShapeClass s = (AbstractShapeClass) shapes[ComboBox.getSelectedIndex()];
        Shape cloned = null;
        try {
            cloned = (Shape) s.clone();
        } catch (CloneNotSupportedException ex) {
        }
        if(s instanceof Rectangle)
        {
           DrawAndAdd("Rectangle", cloned);
        }
        else if(s instanceof Triangle)
        {
           DrawAndAdd("Triangle", cloned);
        }
        else if(s instanceof LineSegment)
        {
           DrawAndAdd("Line", cloned);
        }
        else if(s instanceof Circle)
        {
           DrawAndAdd("Ellipse", cloned);
        }
      
    }//GEN-LAST:event_copyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Colorize;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton Delete;
    private javax.swing.JButton DrawLineSegment;
    private javax.swing.JButton DrawOval;
    private javax.swing.JButton DrawRectangle;
    private javax.swing.JButton DrawSquare;
    private javax.swing.JButton DrawTriangle;
    private javax.swing.JButton copy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem load;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panel;
    private javax.swing.JMenuItem save;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
    
     
}
