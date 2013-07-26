package com.sys.util.jfreechart;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Month;

import com.sys.util.jfreechart.bar.BarChartData;
import com.sys.util.jfreechart.bar.BarChartDemo;
import com.sys.util.jfreechart.date.DateChartData;
import com.sys.util.jfreechart.date.DateChartDemo;
import com.sys.util.jfreechart.date.TimeData;
import com.sys.util.jfreechart.pie.PieChartData;
import com.sys.util.jfreechart.pie.PieChartDemo;


/** 
 * by dyong 2010-10-20
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test() ;
		t.barChart() ;

		t.dateChart() ;
		
		t.pieChart() ;
		
	}
	public byte[] bytes() {
		String title = "水果产量图" ;
		String x = "水果" ;
		String y = "产量(KG)" ;
		String path = "D:/fruit2.jpg" ;
		BarChartDemo demo= new BarChartDemo(title ,x,y) ;
		
		
		List<BarChartData> data = getDataList_Bar2() ;
		JFreeChart chart = demo.createChart(data) ;
		
		byte[] bs = demo.getJpgBytes(chart, 100, 800) ;
		return bs ;
//		demo.writeToJpg(chart, path) ;
	}

	private void barChart() {
		String title = "水果产量图" ;
		String x = "水果" ;
		String y = "产量(KG)" ;
		String path = "D:/fruit2.jpg" ;
		BarChartDemo demo= new BarChartDemo(title ,x,y) ;
		
		
		List<BarChartData> data = getDataList_Bar2() ;
		JFreeChart chart = demo.createChart(data) ;
		
		demo.writeToJpg(chart, path) ;
	}
	private List<BarChartData> getDataList_Bar() {
		List<BarChartData> list = new ArrayList<BarChartData>() ;
		
		BarChartData data = new BarChartData(100,"苹果","") ;
		list.add(data) ;
		
		data = new BarChartData(200,"梨子","") ;
		list.add(data) ;
		
		data = new BarChartData(300,"葡萄","") ;
		list.add(data) ;

		data = new BarChartData(600,"香蕉","") ;
		list.add(data) ;
		
		data = new BarChartData(300,"荔枝","") ;
		list.add(data) ;

		return list ;
	}
	private List<BarChartData> getDataList_Bar2(){
		List<BarChartData> list = new ArrayList<BarChartData>() ;
		
		BarChartData data = new BarChartData(100, "北京", "苹果") ;
		list.add(data) ;
		data = new BarChartData(100, "上海", "苹果") ;
		list.add(data) ;
		data = new BarChartData(100, "广州", "苹果") ;
		list.add(data) ;
		data = new BarChartData(200, "北京", "梨子") ;
		list.add(data) ;
		data = new BarChartData(200, "上海", "梨子") ;
		list.add(data) ;
		data = new BarChartData(200, "广州", "梨子") ;
		list.add(data) ;
		data = new BarChartData(300, "北京", "葡萄") ;
		list.add(data) ;
		data = new BarChartData(300, "上海", "葡萄") ;
		list.add(data) ;
		data = new BarChartData(300, "广州", "葡萄") ;
		list.add(data) ;
		data = new BarChartData(400, "北京", "香蕉") ;
		list.add(data) ;
		data = new BarChartData(400, "上海", "香蕉") ;
		list.add(data) ;
		data = new BarChartData(400, "广州", "香蕉") ;
		list.add(data) ;
		data = new BarChartData(500, "北京", "荔枝") ;
		list.add(data) ;
		data = new BarChartData(500, "上海", "荔枝") ;
		list.add(data) ;
		data = new BarChartData(500, "广州", "荔枝") ;
		list.add(data) ;
		
		return list ;
	}

	private void dateChart() {
		DateChartDemo demo = new DateChartDemo("测试用例","时间","数据") ;
		String path = "d:/date.jpg" ;
		
		
		List<?> data;
		try {
			data = getDataList_date();
			JFreeChart chart = demo.createChart(data ) ;
			demo.writeToJpg(chart, path) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private List<DateChartData> getDataList_date() throws ParseException{
		ArrayList<DateChartData> list = new ArrayList<DateChartData>() ;
		
		DateChartData dateData = new DateChartData() ;
		dateData.date_title = "测试" ;
		dateData.TimeClass = new Month() ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-01-01"),68)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-02-01"),56.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-03-01"),88.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-04-01"),85)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-05-01"),94.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-06-01"),74.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-07-01"),85)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-08-01"),79)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-09-01"),69.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-11-01"),92)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-10-01"),97.7)) ;
		list.add(dateData) ;
		
		
		dateData = new DateChartData() ;
		dateData.date_title = "测试二" ;
		dateData.TimeClass = new Month() ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-01-01"),129.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-02-01"),124.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-03-01"),126.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-04-01"),128)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-05-01"),122.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-06-01"),124.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-07-01"),110)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-08-01"),121)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-09-01"),123.6)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-11-01"),120)) ;
		dateData.data.add(new TimeData(DateFormat.getDateInstance().parse("2010-10-01"),125.7)) ;
		list.add(dateData) ;
		
		return list ;
	}

	private void pieChart(){
		PieChartDemo demo = new PieChartDemo("水果产量图","千克") ;
		String path = "D:/fruit3.jpg" ;
		
		List<PieChartData> data = new ArrayList<PieChartData>() ;
		data.add(new PieChartData("苹果",100)) ;
		data.add(new PieChartData("荔枝",500)) ;
		data.add(new PieChartData("香蕉",400)) ;
		data.add(new PieChartData("葡萄",300)) ;
		data.add(new PieChartData("梨子",200)) ;
		JFreeChart chart = demo.createChart(data) ;
		demo.writeToJpg(chart, path) ;
		
	
	}

}
