Ext.define('Twotest.twotest.shared.com.model.defaultcontext.defaultdomain.TestModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "tid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "tnm",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "tno",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});