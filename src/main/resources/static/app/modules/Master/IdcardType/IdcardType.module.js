(function() {
  'use strict';

  var module = angular.module('sahajApp.IdcardType', [
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
      .state('app.IdcardType', {
        url: '/IdcardType',
        templateUrl: 'app/modules/Master/IdcardType/IdcardType.html',
        	controller:'IdcardTypeCtrl'
      })
  }
})();
