(function() {
	'use strict';

	angular.module('sahajApp.State').controller(
			'StateCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
								
						$scope.state = {};
						
						$scope.addNewState = function() {
							$scope.stateForm = true;
							$scope.state = {};
						}
						
						$scope.getStateList = function() {
							$http({
										method : 'GET',
										url : '/getStateList'
									}).success(function(data, status, headers, config) {
										$scope.stateList = data;
									}).error(function(data, status, headers, config) {
										alert("failure");
									});
								};					
								
								$scope.saveState = function(stateFormValid) {
									if(stateFormValid){
									$scope.formData = JSON.stringify($scope.state);

									var response = $http.post('saveState',$scope.formData);
									response.success(function(data, status, headers,
											config) {
										$scope.list = data;
										$scope.custCategoryForm = false;
										$scope.addCustomerCategory = true;
										$scope.stateForm = false;
										$scope.updateForm = false;
										$scope.state = {};
										$scope.getStateList();
										alert("State Saved Successfully...",'','success');
										
									});
									response.error(function(data, status, headers,
											config) {
										alertl("Error In Adding State...",'','error');
									});
									}else{
										alert("Please Enter Valid Data...",'','error');
									}
								};
								
								$scope.getStateDetails = function(stateId) {

									$scope.formData = JSON.stringify($scope.state);
									$scope.stateForm = true;
									$scope.updateForm = true;
									var response = $http.post('getStateDetails',stateId);
									response.success(function(data, status, headers,config) {
								   $scope.state = data;	
										//console.log("data-----------"+JSON.stringify(data));
									});
									response.error(function(data, status, headers,config) {
//										SweetAlert.swal("Error In Adding Customer Category...",'','error');
									});
								};
								
								$scope.updateState  = function() {
									$scope.formData = JSON.stringify($scope.state);

									var response = $http.post('updateState',$scope.formData);
									response.success(function(data, status, headers,config) {
										$scope.stateForm = false;
										$scope.updateForm = false;
										$scope.state = {};
										$scope.getStateList();
										alert("State Updated Successfully...",'','success');
										
									});
									response.error(function(data, status, headers,config) {
										alert("Error In Updating State...",'','error');
									});
								};
								
								$scope.deleteState = function(stateId) {
									$scope.formData = JSON.stringify($scope.sector);

									var response = $http.post('deleteState',stateId);
									response.success(function(data, status, headers,config) {
										alert("State Deleted Successfully...",'','success');
										
										$scope.getStateList();
									});
									response.error(function(data, status, headers,config) {
										alert("Error In Deleting State...",'','error');
									});
								};
						
						$scope.backToStateList = function() {
							$scope.stateForm = false;
							$scope.state = {};
						}
						
					} ])
})();


