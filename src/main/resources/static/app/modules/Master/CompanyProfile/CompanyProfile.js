(function() {
	'use strict';

	angular.module('sahajApp.CompanyProfile').controller(
			'CompanyProfileCtrl',
			[
					'$scope',
					'$http',
					function($scope, $http, SweetAlert) {
								
				    	
				    	$scope.company={};
				    	$scope.bankDetails={};
				    	$scope.company.bankDetailsList=[];
				    	$scope.bankDetailsList=[];
				 
				    	$scope.showItemForm = function() {
				    		$scope.company={};
					    	$scope.bankDetails={};
					    	$scope.company.bankDetailsList=[];
					    	$scope.bankDetailsList=[];
				    		$scope.getBankList();
				    		$scope.getStateList();
				    		$scope.itemForm=true;
				    				    		
				    	};
				    	
				    	$scope.getBankList = function() {
							$http({
								method : 'GET',
								url : '/getBankList'
							}).success(function(data, status, headers, config) {
								$scope.bankList = data;
							}).error(function(data, status, headers, config) {
								alert("failure");
							});
						};
				    	
				 	$scope.saveCompanyProfile = function(companyFormValid) {
				 		if(companyFormValid){
				 		$scope.company.bankDetailsList = $scope.bankDetailsList;
				 		console.log($scope.company);
						$scope.company = JSON.stringify($scope.company);
							var response = $http.post('saveCompanyProfile',$scope.company);
							response.success(function(data, status, headers,config) {
								
								$scope.itemForm=false;
								$scope.company={};
						    	$scope.bankDetails={};
						    	$scope.company.bankDetailsList=[];
						    	$scope.bankDetailsList=[];
						    	$scope.getCompanyDetailsList();
						    	alert("Company Profile Added Successfully...",'','success');
							});
							response.error(function(data, status, headers,
									config) {
								//SweetAlert.swal("Error In Adding Customer Category...",'','error');
							});
				 		}else
				 			{
				 			alert("Please Enter Valid Data...",'','warning');
				 			}
						};
						
					$scope.hideItemForm = function() {
						$scope.itemForm=false;
						$scope.updateItem=false;
					};
			
					$scope.getStateList = function() {
						$http({
							method : 'GET',
							url : '/getStateList'
						}).success(function(data, status, headers, config) {
							$scope.stateList = data;
							//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.itemCategoryList));
						}).error(function(data, status, headers, config) {
							console.log("failure");
						});
					};
					
					$scope.getDistrictListForState = function(stateId) {
						var response = $http.post('getDistrictListForState',stateId);
						response.success(function(data, status, headers,config) {
							$scope.districtList = data;	
						});
						response.error(function(data, status, headers,config) {
							console.log("+++++++++");
						});
					};
					
					$scope.addBankList = function() { 
						var count = 0;
					    var chkprtcnt = 0;
					  
					    if($scope.bankDetailsList!=''){
					      angular.forEach($scope.bankDetailsList,function(it){
					        if($scope.bankDetails.bankId == it.bankId){
					          alert("Bank  Already Exist...!","","warning");
					          $scope.bankDetails={}; 
					          chkprtcnt++;
					        }
					      });
					      if(chkprtcnt==0){
					    	  $scope.addBankListFinal();
						       $scope.bankDetails={}; 
					      }
					    }else{
					    	  $scope.addBankListFinal();
						       $scope.bankDetails={}; 
					    }
					  
				     
					  };

					    $scope.addBankListFinal = function() {
					    $scope.bankDetailsList.push({
					      "bankId":$scope.bankDetails.bankId,
					      "bankBranchName": $scope.bankDetails.bankBranchName,
					      "accountNumber":$scope.bankDetails.accountNumber,	      
					      "ifscCode":$scope.bankDetails.ifscCode,
					    });
					  };

					 $scope.deleteBankListFinal = function(index){ 
					    $scope.bankDetailsList.splice(index,1);
						  };
						  
					$scope.getCompanyDetailsList = function() {
								$http({
									method : 'GET',
									url : '/getCompanyDetailsList'
								}).success(function(data, status, headers, config) {
									
									$scope.companyDetailsList = data;
								}).error(function(data, status, headers, config) {
									console.log("failure");
								});
							};
						  

							$scope.getCompanyDetails = function(companyId) {
								$scope.formData = JSON.stringify($scope.item);
								$scope.updateItem = true;
								var response = $http.post('getCompanyDetails',companyId);
								response.success(function(data, status, headers,config) {
									$scope.company = data;	
								    $scope.bankDetailsList =  $scope.company.bankDetailsList;
								    $scope.getStateList();
								    $scope.getBankList();
								    $scope.getDistrictListForState($scope.company.stateId);
								});
								response.error(function(data, status, headers,config) {
									console.log("+++++++++");
								});
							};
							
							$scope.updateCompanyProfile = function(companyFormValid) {
								
								$scope.company.bankDetailsList = $scope.bankDetailsList;
						 		console.log($scope.company);
								$scope.company = JSON.stringify($scope.company);
									var response = $http.post('updateCompanyProfile',$scope.company);
									response.success(function(data, status, headers,config) {
										$scope.itemForm=false;
										$scope.updateItem=false;
										$scope.company={};
								    	$scope.bankDetails={};
								    	$scope.company.bankDetailsList=[];
								    	$scope.bankDetailsList=[];
								    	alert("Company Profile Updated Successfully...",'','success');
								    	$scope.getCompanyDetailsList();
								    	
									});
									response.error(function(data, status, headers,
											config) {
										//SweetAlert.swal("Error In Adding Customer Category...",'','error');
									});
							};
							
							$scope.deleteCompanyProfile = function(companyId) {
						
								var response = $http.post('deleteCompanyProfile',companyId);
								response.success(function(data, status, headers,config) {
									$scope.getCompanyDetailsList();
									alert("Company Profile Deleted Successfully...",'','success');
								});
								response.error(function(data, status, headers,config) {

								});
							};
						
					} ])
})();


