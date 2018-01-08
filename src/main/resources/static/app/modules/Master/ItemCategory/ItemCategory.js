(function() {
	'use strict';

	angular.module('sahajApp.ItemCategory').controller(
			'ItemCategoryCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
						;
						
//						$scope.addNewBank = function() {
//							$scope.bankForm = true;
//							$scope.updateBankForm = false;
//							$scope.bank = {};
//						}
//						
//						$scope.backToBankList = function() {
//							$scope.bankForm = false;
//							$scope.updateBankForm = false;
//							$scope.bank = {};
//						}
//						
//						$scope.getBankList = function() {
//							$http({
//								method : 'GET',
//								url : '/getBankList'
//							}).success(function(data, status, headers, config) {
//								$scope.bankList = data;
//							}).error(function(data, status, headers, config) {
//								alert("failure");
//							});
//						};
//						
//						$scope.saveBank = function() {
//							$scope.formData = JSON
//									.stringify($scope.bank);
//
//							var response = $http.post('saveBank',
//									$scope.formData);
//							response.success(function(data, status, headers,
//									config) {
//								$scope.list = data;
//								alert("Bank Saved Successfully...",'','success');
//								$scope.bankForm = false;
//								$scope.getBankList();
//							});
//							response.error(function(data, status, headers,
//									config) {
//								alert("Error In Adding Bank...",'','error');
//							});
//						};
//						
//						$scope.getBankDetails = function(bankId) {
//
//							$scope.formData = JSON.stringify($scope.bank);
//							$scope.updateBankForm = true;
//							$scope.bankForm = true;
//							var response = $http.post('getBankDetails',bankId);
//							response.success(function(data, status, headers,config) {
//								$scope.bank = data;	
//							});
//							response.error(function(data, status, headers,config) {
//								alert("Error In Getting Bank Details...",'','error');
//							});
//						}
//						
//						$scope.updateBank = function() {
//							$scope.formData = JSON
//									.stringify($scope.bank);
//
//							var response = $http.post('updateBank',
//									$scope.formData);
//							response.success(function(data, status, headers,
//									config) {
//								$scope.list = data;
//								alert("Bank Updated Successfully...",'','success');
//								$scope.updateBankForm = false;
//								$scope.bankForm = false;
//								$scope.getBankList();
//							});
//							response.error(function(data, status, headers,
//									config) {
//								alert("Error In Updating Bank...",'','error');
//							});
//						};
						
					} ])
})();


