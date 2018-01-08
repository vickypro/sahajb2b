(function() {
  'use strict';

  var module = angular.module('sahajApp.PurchaseOrder', [
	    'ui.router',
	    'ui.jq',
	    'sahajApp.components.sparkline',
	    'sahajApp.components.nvd3',
	    'sahajApp.components.morris'
	  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.PurchaseOrder', {
        url: '/PurchaseOrder',
        templateUrl: 'app/modules/Transaction/PurchaseOrder/PurchaseOrder.html',
        	controller:'PurchaseOrderCtrl'
      })
  }
})();
