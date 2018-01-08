(function() {
  'use strict';

  var module = angular.module('sahajApp.TransporterType', [
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
      .state('app.TransporterType', {
        url: '/TransporterType',
        templateUrl: 'app/modules/Master/TransporterType/TransporterType.html',
        	controller:'TransporterTypeCtrl'
      })
  }
})();
