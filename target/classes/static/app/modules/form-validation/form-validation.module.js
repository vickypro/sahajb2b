(function() {
  'use strict';

  var module = angular.module('sahajApp.form.validation', [
    'ui.router'

  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.form-validation', {
        url: '/form/validation',
        templateUrl: 'app/modules/form-validation/form-validation.html'
      })
  }
})();
