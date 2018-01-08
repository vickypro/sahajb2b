(function() {
	'use strict';

	angular.module('sahajApp.TransporterType').controller(
			'TransporterTypeCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
						;
						$scope.transporterType = {};
						
						$scope.addNewTransporterType = function() {
							$scope.transporterTypeForm = true;
							$scope.updateTransporterTypeForm = false;
							$scope.transporterType = {};
						}
						
						$scope.backToTransporterTypeList = function() {
							$scope.transporterTypeForm = false;
							$scope.updateTransporterTypeForm = false;
							$scope.transporterType = {};
						}
						
						$scope.getTransporterTypeList = function() {
							$http({
								method : 'GET',
								url : '/getTransporterTypeList'
							}).success(function(data, status, headers, config) {
								$scope.transporterTypeList = data;
							}).error(function(data, status, headers, config) {
								alert("failure");
							});
						};
						
						$scope.saveTransporterType = function() {
							$scope.formData = JSON
									.stringify($scope.transporterType);

							var response = $http.post('saveTransporterType',
									$scope.formData);
							response.success(function(data, status, headers,
									config) {
								alert("Transporter Type Saved Successfully...",'','success');
								$scope.transporterTypeForm = false;
								$scope.getTransporterTypeList();
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Adding Transporter Type...",'','error');
							});
						};
						
						$scope.getTransporterTypeDetails = function(transporterTypeId) {

							$scope.formData = JSON.stringify($scope.transporterType);
							$scope.updateTransporterTypeForm = true;
							$scope.transporterTypeForm = true;
							var response = $http.post('getTransporterTypeDetails',transporterTypeId);
							response.success(function(data, status, headers,config) {
								$scope.transporterType = data;	
							});
							response.error(function(data, status, headers,config) {
								alert("Error In Getting Transporter Type Details...",'','error');
							});
						}
						
						$scope.updateTransporterType = function() {
							$scope.formData = JSON
									.stringify($scope.transporterType);

							var response = $http.post('updateTransporterType',
									$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.updateTransporterTypeForm = false;
								$scope.transporterTypeForm = false;
								$scope.getTransporterTypeList();
								alert("Transporter Type Updated Successfully...",'','success');
								
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Updating Transporter Type...",'','error');
							});
						};
						
						
					} ])
})();


