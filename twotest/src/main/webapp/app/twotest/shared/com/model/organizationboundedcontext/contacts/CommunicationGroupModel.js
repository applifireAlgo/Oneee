Ext.define('Twotest.twotest.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commGroupId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commGroupName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commGroupDescription",
          "type": "string",
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