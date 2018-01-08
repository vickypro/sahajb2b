(function() {
	'use strict';

	angular.module('sahajApp.Van').controller('VanCtrl',

	[ '$scope', '$http', function($scope, $http, SweetAlert) {
		;
		
		
		
		// var insuranceValidityDate;
		$scope.van = {};
		$scope.vanList = true;
		$scope.addvan = false;
		// $scope.getVanDetails =true;
		  	 
		 
		 
		 $scope.updateVan = function() {
		  		 
			   $scope.formData = JSON.stringify($scope.van);
			   console.log($scope.formData);
			  	var response = $http.post('updateVan', $scope.formData);
				response.success(function(data, status, headers, config) {
					$scope.list = data;
					// JsonObj.get("Description"));
					alert("Van updated Successfully...",'','success');
				});
				response.error(function(data, status, headers, config) {
					//SweetAlert.swal("Error In Adding Van...",'','error');
				});
			  
			};
		
		
		
		$scope.getVanList = function() {
			alert();
			$http({
				method : 'GET',
				url : '/getVanList'
			}).success(function(data, status, headers, config) {
				$scope.vanList = data;
				console.log(data);
			}).error(function(data, status, headers, config) {
				alert("failure");
			});
		};


		
		
		$scope.saveVan = function() {
		
		  
			console.log("++++++++++++++++++" + JSON.stringify($scope.van));
			$scope.formData = JSON.stringify($scope.van);
		   console.log($scope.formData);

			var response = $http.post('saveVan', $scope.formData);
			response.success(function(data, status, headers, config) {
				$scope.list = data;
				if($scope.vanId== ""){
					 alert("Insufficient Data! Please provide all the deatils");
				}else{
					$scope.list = data
				
				alert("Van save Successfully...",'','success');
				}
			
			});
			response.error(function(data, status, headers, config) {

		});
		};

		
		  $scope.getVanDetails = function(vanId) {
			  // console.log(vanId);
			  alert("ok");
				$scope.formData = JSON.stringify($scope.van);
				$scope.updateVan = true;
				//$scope.addvan = true;
				$scope.VanCategoryForm = true;
		
				var response = $http.post('getVanDetails',vanId);
			
				response.success(function(data, status, headers,config) {
					$scope.van = data;	
					console.log($scope.van);
					/*$scope.van.insuranceDate =$scope.van.insuranceValidityDate;
					alert($scope.van.insuranceDate);*/
				});
				response.error(function(data, status, headers,config) {
					//alert(data);
//					SweetAlert.swal("Error In Adding Customer Category...",'','error');
				});
			};
		 
		 
		 
			
			  $scope.deleteVan = function(vanId) {
			

						var response = $http.post('deleteVan',vanId);
						response.success(function(data, status, headers,
								config) {
							
							$scope.vanList = data;
							console.log(data);
							
							alert("Van Deleted Successfully...",'','success');
					
						});
						response.error(function(data, status, headers,
								config) {
							alert("Error In Deleting Van..",'','error');
						});
					};
				
				 
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
					 
					 $scope.submit=function(){
						 
						 if($scope.van.vanId ==  null || $scope.van.vanNo == null || $scope.van.descripton == null)
							{
							
								   alert("Insufficient Data! Please provide all the deatils");
							}
						else{
								   
							$scope.saveVan();
								  } 
					 };
					
					
				  $scope.addNewvan = function() {
					  console.log("++++++++++++++++++" + JSON.stringify($scope.van));
						$scope.formData = JSON.stringify($scope.van);

						var response = $http.post('addNewVan', $scope.formData);
						response.success(function(data, status, headers, config) {
							$scope.list = data;
						});
						response.error(function(data, status, headers, config) {
							SweetAlert.swal("Error In Adding Van...",'','error');
					
						});
				  }
				  
					
				 $scope.addNewVan = function(){
						$scope.VanCategoryForm=true;
						$scope.getStateList();
						 $scope.getVanDetails =true;
						/*$scope.submitVan()=true;*/
					
					};
					
					$scope.backToVanList = function(){
						$scope.VanCategoryForm=false;
						$scope.updateVan = false;
						/*$scope.submitVan=false;*/
					};
					 
		  

	} ])
})();
