(function() {
  'use strict';

  var module = angular.module('sahajApp.Van', [
	    'ui.router',
	    'ui.jq',
	    'sahajApp.components.sparkline',
	    'sahajApp.components.nvd3',
	    'sahajApp.components.morris'
	  ]);

  module.config(appConfig);

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.Van', {
        url: '/Van',
        templateUrl: 'app/modules/Master/Van/Van.html',
        	controller:'VanCtrl'
      });
    

  }
})();
