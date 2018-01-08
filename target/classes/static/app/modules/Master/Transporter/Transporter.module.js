(function() {
  'use strict';

  var module = angular.module('sahajApp.Transporter', [
	    'ui.router',
	    'ui.jq',
	    'sahajApp.components.sparkline',
	    'sahajApp.components.nvd3',
	    'sahajApp.components.morris'
	  ]);

  module.config(appConfig);

 // appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.Transporter', {
        url: '/Transporter',
        templateUrl: 'app/modules/Master/Transporter/Transporter.html',
        	controller:'TransporterCtrl'
      });
    

  }
})();
