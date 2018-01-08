(function() {
  'use strict';

  var module = angular.module('sahajApp.CustomerCategory', [
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
      .state('app.CustomerCategory', {
        url: '/CustomerCategory',
        templateUrl: 'app/modules/Master/CustomerCategory/CustomerCategory.html',
        	controller:'CustomerCategoryCtrl'
      })
  }
})();
