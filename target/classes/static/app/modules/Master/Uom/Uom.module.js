(function() {
  'use strict';

  var module = angular.module('sahajApp.Uom', [
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
      .state('app.Uom', {
        url: '/Uom',
        templateUrl: 'app/modules/Master/Uom/Uom.html',
        	controller:'UomCtrl'
      })
  }
})();
