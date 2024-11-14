package packVisu;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleInsets;
import packData.MyData;

import java.awt.*;


/**
 * @author Eric
 */
public class BarGraph extends JPanel {

    private MyData data;
    private DefaultCategoryDataset dataset;
    
    public BarGraph(MyData data){
        this.data = data;
        this.dataset = createDataset();

        JFreeChart barchart = ChartFactory.createBarChart(
                null,      // chart title
                null,                 // domain axis label
                null,                    // range axis label
                dataset,                     // data
                PlotOrientation.VERTICAL,    // orientation
                false,                        // include legend
                false,                        // tooltips
                false                        // urls
        );

        // Theme
        CategoryPlot cplot = barchart.getCategoryPlot();
        cplot.setBackgroundPaint(Color.WHITE);
        cplot.getDomainAxis().setTickLabelsVisible(false);
        cplot.getRangeAxis().setTickLabelsVisible(false);

        BarRenderer renderer = (BarRenderer)cplot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(barchart);
        chartPanel.setPreferredSize(new java.awt.Dimension( 500 , 350 ) );
        this.add(chartPanel);
    }

    private DefaultCategoryDataset createDataset( ) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        for (int i = 0; i < data.getData().length; i++) {
            dataset.addValue(data.getData()[i], "Value", Integer.toString(i));
        }

        return dataset;
    }

    public void updateDataset() {
        dataset.clear();

        for (int i = 0; i < data.getData().length; i++) {
            dataset.addValue(data.getData()[i], "Value", Integer.toString(i));
        }
    }
}
