(function() {
  'use strict';

  var module = angular.module('sahajApp.Sector', [
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
      .state('app.Sector', {
        url: '/Sector',
        templateUrl: 'app/modules/Master/Sector/Sector.html',
        	controller:'SectorCtrl'
      })
  }
})();
