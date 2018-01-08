(function() {
	'use strict';

	angular.module('sahajApp.CustomerCategory').controller(
			'CustomerCategoryCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
						;
						$scope.customerCategory = {};
						$scope.customerCategoryList = false;
						$scope.addCustomerCategory = false;
						
//						$scope.addNewCustomerCategory = function() {
//							$scope.customerCategoryList = true;
//							$scope.addCustomerCategory = true;
//							$scope.customerCategory = {};
//						}
//						
//						$scope.backToCustomerCategoryList = function() {
//							$scope.customerCategoryList = false;
//							$scope.addCustomerCategory = true;
//							$scope.customerCategory = {};
//						}
						
						$scope.addNewCustomerCategory = function(){
							$scope.custCategoryForm=true;
							$scope.updateCustCategory = false;
							$scope.customerCategory = {};
						};
						
						$scope.backToCustomerCategoryList = function(){
							$scope.custCategoryForm=false;
							$scope.updateCustCategory = false;
						};
						
						$scope.getCustomerCategoryList = function() {
							$http({
								method : 'GET',
								url : '/getCustomerCategoryList'
							}).success(function(data, status, headers, config) {
								$scope.customerCategoryList = data;
							}).error(function(data, status, headers, config) {
								alert("failure");
							});
						};

						$scope.saveCustomerCategory = function() {
							$scope.formData = JSON
									.stringify($scope.customerCategory);

							var response = $http.post('PostCustomerCategory',
									$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.list = data;
								alert("Customer Category Saved Successfully...",'','success');
								$scope.custCategoryForm=false;
								$scope.getCustomerCategoryList();
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Adding Customer Category...",'','error');
							});
						};
						
						$scope.getCustomerCategoryDetails = function(customerCategoryId) {

							$scope.formData = JSON.stringify($scope.customerCategory);
							$scope.updateCustCategory = true;
							$scope.custCategoryForm = true;
							var response = $http.post('getCustomerCategoryDetails',customerCategoryId);
							response.success(function(data, status, headers,config) {
								$scope.customerCategory = data;	
								console.log("data-----------"+JSON.stringify(data));
							});
							response.error(function(data, status, headers,config) {
//								SweetAlert.swal("Error In Adding Customer Category...",'','error');
							});
						}
						
						$scope.updateCustomerCategory = function() {
							$scope.formData = JSON
									.stringify($scope.customerCategory);

							var response = $http.post('updateCustomerCategory',
									$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.list = data;
								alert("Customer Category Updated Successfully...",'','success');
								$scope.custCategoryForm=false;
								$scope.getCustomerCategoryList();
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Updating Customer Category...",'','error');
							});
						};
						
						$scope.deleteCustomerCategory = function() {
							$scope.formData = JSON
									.stringify($scope.customerCategory);

							var response = $http.post('deleteCustomerCategory',
									$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.list = data;
								alert("Customer Category Deleted Successfully...",'','success');
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Deleting Customer Category...",'','error');
							});
						};

						
					} ])
})();


