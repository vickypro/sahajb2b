(function() {
	'use strict';

	angular.module('sahajApp.Sector').controller(
			'SectorCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
						
						$scope.sector = {};
						$scope.customerCategoryList = false;
						$scope.addCustomerCategory = false;
						
						$scope.addNewCustomerCategory = function() {
							$scope.customerCategoryList = true;
							$scope.addCustomerCategory = true;
							$scope.sector = {};
						}
						
						$scope.backToCustomerCategoryList = function() {
							$scope.customerCategoryList = false;
							$scope.addCustomerCategory = true;
							$scope.sector = {};
						}
						
						$scope.getSectorList = function() {
							$http({
								method : 'GET',
								url : '/getSectorList'
							}).success(function(data, status, headers, config) {
								$scope.sectorList = data;
								//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.sectorList));
							}).error(function(data, status, headers, config) {
								console.log("failure");
							});
						};

						$scope.saveSector = function() {
							$scope.formData = JSON.stringify($scope.sector);

							var response = $http.post('saveSector',$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.list = data;
								alert("Sector Saved Successfully...",'','success');
								$scope.custCategoryForm = false;
								$scope.addCustomerCategory = true;
								$scope.getSectorList();
							});
							response.error(function(data, status, headers,
									config) {
								alertl("Error In Adding Sector...",'','error');
							});
						};
						
						$scope.getSectorDetails = function(sectorId) {

							$scope.formData = JSON.stringify($scope.sector);
							$scope.updateCustCategory = true;
							$scope.custCategoryForm = true;
							var response = $http.post('getSectorDetails',sectorId);
							response.success(function(data, status, headers,config) {
								$scope.sector = data;	
								//console.log("data-----------"+JSON.stringify(data));
							});
							response.error(function(data, status, headers,config) {
//								SweetAlert.swal("Error In Adding Customer Category...",'','error');
							});
						}
						
						$scope.updateSector  = function() {
							$scope.formData = JSON.stringify($scope.sector);

							var response = $http.post('updateSector',$scope.formData);
							response.success(function(data, status, headers,
									config) {
								$scope.sector = data;
								alert("Sector Updated Successfully...",'','success');
								$scope.custCategoryForm = false;
								$scope.addCustomerCategory = true;
								$scope.getSectorList();
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Updating Customer Category...",'','error');
							});
						};
						
						$scope.deleteSector = function(sectorId) {
							$scope.formData = JSON.stringify($scope.sector);

							var response = $http.post('deleteSector',sectorId);
							response.success(function(data, status, headers,
									config) {
								$scope.list = data;
								alert("Sector Deleted Successfully...",'','success');
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Deleting Customer Category...",'','error');
							});
						};
						
						$scope.addNewCustomerCategory = function(){
							$scope.custCategoryForm=true;
							$scope.sector={};
						};
						
						$scope.backToCustomerCategoryList = function(){
							$scope.custCategoryForm=false;
							$scope.updateCustCategory = false;
						};

						
					} ])
})();


