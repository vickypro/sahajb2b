(function() {
  'use strict';

  var module = angular.module('sahajApp.Bank', [
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
      .state('app.Bank', {
        url: '/Bank',
        templateUrl: 'app/modules/Master/Bank/Bank.html',
        	controller:'BankCtrl'
      })
  }
})();
