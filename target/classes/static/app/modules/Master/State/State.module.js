(function() {
  'use strict';

  var module = angular.module('sahajApp.State', [
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
      .state('app.State', {
        url: '/State',
        templateUrl: 'app/modules/Master/State/State.html',
        	controller:'StateCtrl'
      })
  }
})();
