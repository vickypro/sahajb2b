(function() {
	'use strict';

	angular.module('sahajApp.SecurityAgency').controller(
			'SecurityAgencyCtrl',['$scope','$http',function($scope, $http, SweetAlert) {
				
				$scope.agency={};
				
				$scope.newAgency=function(){
					var response = $http.post('newAgency');
					response.success(function(data, status, headers,
							config) {
						$scope.agency = data;
						$scope.agency.activeStatus= false;
					});
					response.error(function(data, status, headers,
							config) {
					});
				};
				
				
				  $scope.deleteagency = function(securityagencyCode) {
					  var response = $http.post('deleteAgency',securityagencyCode);
						response.success(function(data, status, headers,
								config) {
							$scope.agencydataList = data;
							alert("Security Agency Deleted Successfully...",'','success');
					
						});
						response.error(function(data, status, headers,
								config) {
							alert("Error In Deleting Security Agency..",'','error');
						});
					};
			    		
			 
					$scope.getAgencydetails = function(securityagencyCode) {
						  
							$scope.updateAgencybutton = true;
							$scope.updateagencyform = true;
							var response = $http.post('getAgencydetails',securityagencyCode);
							response.success(function(data, status, headers,config) {
								$scope.agency = data;	
								$scope.getStateList();
								$scope.getDistrictList($scope.agency.stateId);
							});
							response.error(function(data, status, headers,config) {
								 console.log(data);
							});
						
					};
						
						
					
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
		 		
		 		$scope.getDistrictList = function(stateId) {
		 			var response = $http.post('getDistrictListForState',stateId);
		 			response.success(function(data, status, headers,config) {
		 				$scope.districtList = data;								
		 			});
		 			response.error(function(data, status, headers,config) {
		 				console.log("failure");
		 			});
		 		};
		    	
		    	$scope.showItemForm = function() {
		    	 
		    		$scope.agencyform=true;
		    		$scope.updateAgencybutton = false;
					$scope.getStateList();
					$scope.newAgency();
		    	
		    	};
		    	
		    	
		    	
		 	$scope.saveagency = function() {
		 	$scope.agency = JSON.stringify($scope.agency);
		 
			var response = $http.post('saveagency',$scope.agency);
			response.success(function(data, status, headers,
					config) {
				alert("data Saved Successfully...",'','success');
				 
			});
			response.error(function(data, status, headers,
					config) {
				 
			});
			
			};
			
			
			$scope.getAgencyList = function() {
				 
				$http({
					method : 'GET',
					url : '/getagency'
				}).success(function(data, status, headers, config) {
					$scope.agencydataList = data;
					 
				}).error(function(data, status, headers, config) {
					alert("failure");
				});
			};
			
			
			
			$scope.hideItemForm = function() {
				$scope.agencyform=false;
				$scope.updateagencyform=false;
			};
			
			
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
			
				$scope.getItemList = function() {
						 
					};
					
					
					$scope.updateAgencydata = function() {
						$scope.agency = JSON.stringify($scope.agency);
						  	var response = $http.post('updateAgency', $scope.agency);
							response.success(function(data, status, headers, config) {
								alert("Security Agency updated Successfully...",'','success');
							});
							response.error(function(data, status, headers, config) {
								console.log(data);
					
							});
					};
					
				 
				 
		    }])
		})();
