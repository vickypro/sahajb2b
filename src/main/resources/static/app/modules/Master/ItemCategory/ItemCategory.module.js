(function() {
  'use strict';

  var module = angular.module('sahajApp.ItemCategory', [
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
      .state('app.ItemCategory', {
        url: '/ItemCategory',
        templateUrl: 'app/modules/Master/ItemCategory/ItemCategory.html',
        	controller:'ItemCategoryCtrl'
      })
  }
})();
