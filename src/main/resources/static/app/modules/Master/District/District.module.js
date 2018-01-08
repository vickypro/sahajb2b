(function() {
  'use strict';

  var module = angular.module('sahajApp.District', [
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
      .state('app.District', {
        url: '/District',
        templateUrl: 'app/modules/Master/District/District.html',
        	controller:'DistrictCtrl'
      })
  }
})();
