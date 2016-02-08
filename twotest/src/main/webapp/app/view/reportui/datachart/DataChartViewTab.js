Ext.define('Twotest.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Twotest.view.reportui.datachart.DataChartTController',
	             'Twotest.view.reportui.datachart.datagrid.DataGridView',
	             'Twotest.view.reportui.datachart.chart.ChartTabView',
	             'Twotest.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:function(me){
        	me.setActiveTab(me.items.items[0]);
        }
	}
});