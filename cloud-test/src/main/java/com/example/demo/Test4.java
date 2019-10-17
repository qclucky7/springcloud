package com.example.demo;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WangRui
 * create at 2019/09/18 下午 4:10
 **/
public class Test4 {
    public static void main(String[] args) throws IOException {

        File file = new File("F://ab.xls");
        InputStream is = new FileInputStream(file);

        //----------------------------------------------------

        HSSFWorkbook wb = new HSSFWorkbook(is);


        double[][] data = new double[][] {{ 0.15, 0.35, 0.20, 0.13, 0.17 }};
        String[] rowKeys = { "苹果" };
        String[] columnKeys = { "控制型\nCP", "养育型\nNP", "成人型\nA", "适应型\nAC", "自由型\nFC" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);


        HSSFSheet sheet3 = wb.createSheet("Sheet 5");
        JFreeChart chart = createBarChart(dataset, false);
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(byteArrayOut, chart, 400, 200);
        HSSFPatriarch patriarch = sheet3.createDrawingPatriarch();
        // 八个参数，前四个表示图片离起始单元格和结束单元格边缘的位置，
        // 后四个表示起始和结束单元格的位置，如下表示从第2列到第12列，从第1行到第15行,需要注意excel起始位置是0
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 2, (short) 1, (short) 12, (short) 15);
        anchor.setAnchorType(3);
        // 插入图片
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
        // excel2003后缀
        FileOutputStream fileOut = new FileOutputStream("F://ab.xls");
        wb.write(fileOut);
        fileOut.close();
    }


    private static JFreeChart createBarChart(CategoryDataset dataset, boolean legend) throws IOException {
        JFreeChart chart = ChartFactory.createBarChart("", // 图表标题
                "", // 目录轴的显示标签
                "", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                legend, // 是否显示图例(对于简单的柱状图必须是false)
                false, // 是否生成工具
                false // 是否生成URL链接
        );
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        /*
         * VALUE_TEXT_ANTIALIAS_OFF表示将文字的抗锯齿关闭,
         * 使用的关闭抗锯齿后，字体尽量选择12到14号的宋体字,这样文字最清晰好看
         */
        // chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.white);
        // create plot
        CategoryPlot plot = chart.getCategoryPlot();
        // 设置横虚线可见
        plot.setRangeGridlinesVisible(true);
        // 虚线色彩
        plot.setRangeGridlinePaint(Color.gray);

        // 数据轴精度
        NumberAxis vn = (NumberAxis) plot.getRangeAxis();
        // vn.setAutoRangeIncludesZero(true);
        DecimalFormat df = new DecimalFormat("#0%");
        vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式
        // x轴设置
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值

        // Lable（Math.PI/3.0）度倾斜
        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions
        // .createUpRotationLabelPositions(Math.PI / 3.0));

        //横坐标文案最多显示两行
        domainAxis.setMaximumCategoryLabelLines(2);

        domainAxis.setMaximumCategoryLabelWidthRatio(10.0f);// 横轴上的 Lable 是否完整显示

        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.1);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.1);
        // 设置 columnKey 是否间隔显示
        // domainAxis.setSkipCategoryLabelsToFit(true);

        plot.setDomainAxis(domainAxis);
        // 设置柱图背景色（注意，系统取色的时候要使用16位的模式来查看颜色编码，这样比较准确）
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // y轴设置
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(labelFont);
        rangeAxis.setTickLabelFont(labelFont);
        // 设置最高的一个 Item 与图片顶端的距离
        rangeAxis.setUpperMargin(0.15);
        // 设置最低的一个 Item 与图片底端的距离
        rangeAxis.setLowerMargin(0.15);
        plot.setRangeAxis(rangeAxis);



        BarRenderer renderer = new BarRenderer();
        // 设置柱子宽度
        renderer.setMaximumBarWidth(0.05);
        // 设置柱子高度
        renderer.setMinimumBarLength(0.2);
        // 设置柱子边框颜色
        renderer.setBaseOutlinePaint(Color.BLACK);
        // 设置柱子边框可见
        renderer.setDrawBarOutline(true);

        // // 设置柱的颜色
        renderer.setSeriesPaint(0, new Color(204, 255, 255));
        renderer.setSeriesPaint(1, new Color(153, 204, 255));
        renderer.setSeriesPaint(2, new Color(51, 204, 204));

        // 设置每个地区所包含的平行柱的之间距离
        renderer.setItemMargin(0.0);

        // 显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);

        plot.setRenderer(renderer);
        // 设置柱的透明度
        plot.setForegroundAlpha(1.0f);

        /*FileOutputStream fos_jpg = null;
        try {
            isChartPathExist(CHART_PATH);
            String chartName = CHART_PATH + charName;
            fos_jpg = new FileOutputStream(chartName);
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 500, true, 10);
            return chartName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        return chart;
    }
}
