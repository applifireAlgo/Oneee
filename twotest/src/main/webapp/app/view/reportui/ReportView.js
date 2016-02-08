Ext.define('Twotest.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Twotest.view.reportui.querycriteria.QueryCriteriaView',
			'Twotest.view.reportui.datachart.DataChartViewTab',
			'Twotest.view.reportui.datachart.DataChartViewPanel',
			'Twotest.view.reportui.ReportViewController' ,
			'Twotest.view.fw.MainDataPointPanel',
			'Twotest.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
