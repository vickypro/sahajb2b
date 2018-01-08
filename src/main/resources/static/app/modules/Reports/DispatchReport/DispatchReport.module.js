(function() {
  'use strict';

  var module = angular.module('sahajApp.DispatchReport', [
    'ui.router',
    'ngResource',
    'datatables',
    'datatables.bootstrap'
  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.DispatchReport', {
        url: '/DispatchReport',
        templateUrl: 'app/modules/Master/DispatchReport/DispatchReport.html',
        controller: 'DispatchReportCtrl'
      })
  }
})();
