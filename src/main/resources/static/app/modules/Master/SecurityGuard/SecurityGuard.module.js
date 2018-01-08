(function() {
  'use strict';

  var module = angular.module('sahajApp.SecurityGuard', [
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
      .state('app.SecurityGuard', {
        url: '/SecurityGuard',
        templateUrl: 'app/modules/Master/SecurityGuard/SecurityGuard.html',
        	controller:'SecurityGuardCtrl'
      })
  }
})();
