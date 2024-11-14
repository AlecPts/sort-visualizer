package packVisu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import javax.swing.*;

import org.w3c.dom.ls.LSOutput;
import packData.MyData;
import packTris.*;

/**
 * @author brice.effantin
 */
public class MaFenetre extends JFrame  {

    private MyData data;
    private AbstractTri tri;
    private JButton btNext = new JButton("Next");
    private JComboBox combo = new JComboBox();
    private BarGraph barGraph;
    private JButton btStart = new JButton("Start");
    private JButton btStop = new JButton("Stop");
    private JButton btRAZ = new JButton("RAZ");
    private Timer timer;

    public MaFenetre(MyData data) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.data = data;
        barGraph = new BarGraph(data);
        combo.addItem("Tri Bulle 1");
        combo.addItem("Tri Bulle 2");
        combo.addItem("Tri Selection");

        //placement des composants
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;
        this.getContentPane().add(btNext, gc);
        gc.gridy++;
        this.getContentPane().add(barGraph, gc);
        gc.gridy++;
        this.getContentPane().add(combo, gc);
        gc.gridy++;
        this.getContentPane().add(btStart, gc);
        gc.gridy++;
        this.getContentPane().add(btStop, gc);
        gc.gridy++;
        this.getContentPane().add(btRAZ, gc);

        this.pack();

        // TriBulle1 selectionné par défaut
        tri = new TriBulle1(data);
 
        // add listeners
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String selectedOption = combo.getSelectedItem().toString();

                switch (selectedOption) {

                    case "Tri Bulle 2":
                        tri = new TriBulle2(data);
                        break;

                    case "Tri Selection":
                        tri = new TriSelection(data);
                        break;

                    default:
                        tri = new TriBulle1(data);
                        break;
                }
            }
        });

        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tri.next();
                barGraph.updateDataset();
            }
        });

        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timer = new Timer(100 , new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tri.next();
                        barGraph.updateDataset();
                    }
                });
                timer.start();
                btStart.setBackground(Color.GREEN);
            }
        });

        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timer.stop();
                btStart.setBackground(null);
            }
        });

        btStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btStop.setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btStop.setForeground(null);
            }
        });

        btRAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data.raz();
                barGraph.updateDataset();
            }
        });

    }
}
