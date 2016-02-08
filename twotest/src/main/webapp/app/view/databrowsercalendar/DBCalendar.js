Ext.define('Twotest.view.databrowsercalendar.DBCalendar', {
	extend : 'Twotest.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Twotest.view.databrowsercalendar.DBCalendarController',
	             'Twotest.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
