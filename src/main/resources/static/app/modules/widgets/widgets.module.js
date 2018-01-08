(function() {
  'use strict';

  var module = angular.module('sahajApp.widgets', [
    'ui.router',
    'ui.bootstrap',
    'sahajApp.components.mapael',
    'sahajApp.components.tile',
    'sahajApp.components.flot',
    'sahajApp.components.skycon',
    'sahajApp.components.sparkline',
    'ui.jq'
  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.widgets', {
        url: '/widgets',
        templateUrl: 'app/modules/widgets/widgets.html'
      })
  }
})();
