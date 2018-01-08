(function() {
  'use strict';

  var module = angular.module('sahajApp.Route', [
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
      .state('app.Route', {
        url: '/Route',
        templateUrl: 'app/modules/Master/Route/Route.html',
        	controller:'RouteCtrl'
      })
  }
})();
