(function() {
  'use strict';

  var module = angular.module('sahajApp.CompanyProfile', [
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
      .state('app.CompanyProfile', {
        url: '/CompanyProfile',
        templateUrl: 'app/modules/Master/CompanyProfile/CompanyProfile.html',
        	controller:'CompanyProfileCtrl'
      })
  }
})();
