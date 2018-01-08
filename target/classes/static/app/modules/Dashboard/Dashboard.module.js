(function() {
  'use strict';

  var module = angular.module('sahajApp.Dashboard', [
    'ui.router',
    'ui.jq',
    'sahajApp.components.rickshaw'
  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.dashboard', {
        url: '/Dashboard',
        templateUrl: 'app/modules/Dashboard/Dashboard.html',
        controller: 'DashboardController'
      })
  }
})();
