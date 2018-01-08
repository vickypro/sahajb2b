(function() {
	'use strict';

	angular.module('sahajApp.District').controller(
			'DistrictCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
						;
							
						$scope.district = {};

						$scope.addNewDistrict = function() {
							$scope.getStateList();
							$scope.districtForm = true;
							$scope.updateDistrictForm = false;
							$scope.district = {};
						}
						
						$scope.backToDistrictList = function() {
							$scope.districtForm = false;
							$scope.updateDistrictForm = false;
							$scope.district = {};
						}

						$scope.getStateList = function() {
							$http({
								method : 'GET',
								url : '/getStateList'
							}).success(function(data, status, headers, config) {
								$scope.stateList = data;
							}).error(function(data, status, headers, config) {
								console.log("failure");
							});
						};

						$scope.getDistrictList = function() {
							$http({
								method : 'GET',
								url : '/getDistrictList'
							}).success(function(data, status, headers, config) {
								$scope.districtList = data;
								$scope.getStateList();
							}).error(function(data, status, headers, config) {
								alert("failure");
							});
						};

						$scope.saveDistrict = function() {
							$scope.formData = JSON.stringify($scope.district);

							var response = $http.post('saveDistrict',$scope.formData);
							response.success(function(data, status, headers,
									config) {
								alert("District Saved Successfully...", '','success');
								$scope.districtForm = false;
								$scope.updateDistrictForm = false;
								$scope.getDistrictList();
								$scope.district = {};
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Adding District...", '','error');
							});
						};

						$scope.getDistrictDetails = function(districtId) {

							$scope.formData = JSON.stringify($scope.district);
							$scope.updateDistrictForm = true;
							$scope.districtForm = true;
							var response = $http.post('getDistrictDetails',districtId);
							response.success(function(data, status, headers,config) {
								$scope.district = data;
							});
							response.error(function(data, status, headers,config) {
								alert("Error In Getting District Details...",'', 'error');
							});
						}

						$scope.updateDistrict = function() {
							$scope.formData = JSON.stringify($scope.district);

							var response = $http.post('updateDistrict',$scope.formData);
							response.success(function(data, status, headers,config) {
								$scope.list = data;
								alert("District Updated Successfully...", '','success');
								$scope.updateDistrictForm = false;
								$scope.districtForm = false;
								$scope.getDistrictList();
							});
							response.error(function(data, status, headers,config) {
								alert("Error In Updating District...", '','error');
							});
						};
						
					} ])
})();


