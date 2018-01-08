(function() {
  'use strict';

  var module = angular.module('sahajApp.Item', [
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
      .state('app.Item', {
        url: '/Item',
        templateUrl: 'app/modules/Master/Item/Item.html',
        	controller:'ItemCtrl'
      })
  }
})();
