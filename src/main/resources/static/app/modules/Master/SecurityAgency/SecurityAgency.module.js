(function() {
  'use strict';

  var module = angular.module('sahajApp.SecurityAgency', [
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
      .state('app.SecurityAgency', {
        url: '/SecurityAgency',
        templateUrl: 'app/modules/Master/SecurityAgency/SecurityAgency.html',
        	controller:'SecurityAgencyCtrl'
      })
  }
})();
