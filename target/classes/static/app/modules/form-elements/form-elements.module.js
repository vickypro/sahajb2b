

(function() {
  'use strict';

  var module = angular.module('sahajApp.form.elements', [
    'ui.router',
    'ui.jq',
    'ui.event',
    'ngResource',
    'sahajApp.components.dropzone',
    'sahajApp.components.switchery',
    'sahajApp.components.holderjs',
    'angular-bootstrap-select',
    'summernote',
    'ui.bootstrap-slider'
  ]);

  module.config(appConfig);

  appConfig.$inject = ['$stateProvider'];

  function appConfig($stateProvider) {
    $stateProvider
      .state('app.form-elements', {
        url: '/form/elements',
        templateUrl: 'app/modules/form-elements/form-elements.html'
      })
  }
})();
