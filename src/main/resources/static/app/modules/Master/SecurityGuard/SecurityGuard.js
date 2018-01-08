(function() {
	'use strict';

	angular.module('sahajApp.SecurityGuard').controller(
			'SecurityGuardCtrl',['$scope','$http',function($scope, $http, SweetAlert) {
				
				$scope.guard={};
				$scope.guardList={};
				$scope.agencydataList={};
				$scope.IdcardList={};
				
				$scope.getAgencyList = function() {
					 
					$http({
						method : 'GET',
						url : '/getAgencyList'
					}).success(function(data, status, headers, config) {
						$scope.agencydataList=data;
						 
					}).error(function(data, status, headers, config) {
						alert("failure");
					});
				};
				
				
				
				$scope.updateGuard = function() {
					$scope.guard = JSON.stringify($scope.guard);
					 
					  	var response = $http.post('updateGuard', $scope.guard);
						response.success(function(data, status, headers, config) {
							alert("Security Guard updated Successfully...",'','success');
						});
						response.error(function(data, status, headers, config) {
							console.log(data);
							//SweetAlert.swal("Error In Adding Van...",'','error');
						});
				};
				
				
				
				
				
				$scope.getIdCardList = function() {
					 
					$http({
						method : 'GET',
						url : '/getCardType'
					}).success(function(data, status, headers, config) {
						$scope.IdcardList=data;
					 
					}).error(function(data, status, headers, config) {
						alert("failure");
					});
				};
				
				
				
				$scope.getGuardDetails=function(securityGuardCode){
					$scope.updateAgencybutton = true;
					$scope.updateagencyform = true;
					
				   var response = $http.post('getGuarddetails',securityGuardCode);
				   response.success(function(data, status, headers,config) {
						$scope.guard = data;
						$scope.getIdCardList();
						$scope.getAgencyList();
						 
						});
					response.error(function(data, status, headers,config) {
						 console.log(data);
					});
				
					
				};
				
				
				
				
				$scope.newGuard=function(){
					var response = $http.post('newGuards');
					response.success(function(data, status, headers,
							config) {
						$scope.guard = data;
						$scope.guard.activeStatus= false;
						 
					});
					response.error(function(data, status, headers,
							config) {
					});
				};
				
			     
		 		 
		    	$scope.showItemForm = function() 
		    	{
		    	 $scope.agencyform=true;
		    		$scope.updateAgencybutton = false;
		    		$scope.getAgencyList();
		    		$scope.getIdCardList();
				};
		    	
		    	
		    	
		    	$scope.saveGuard = function() {
		    		 
		    		
		    		$scope.guard = JSON.stringify($scope.guard);
					var response = $http.post('saveguard',$scope.guard);
					response.success(function(data, status, headers,
							config) {
						alert("Data Saved Successfully...",'','success');
						 
					});
					response.error(function(data, status, headers,
							config) {
						 
					});
		    	};
		    	
		    	
		    	
		    	 $scope.getSecurityList = function() {
		    		 
			    		$http({
			 				method : 'GET',
			 				url : '/getSecurityList'
			 			}).success(function(data, status, headers, config) {
			 				$scope.guardList = data;
			 				 
			 			}).error(function(data, status, headers, config) {
			 				console.log("failure");
			 			});
			    		
			    		
						
			 		};
		    
			
			 		
			 		 $scope.deleteGuard = function(securityGuardCode) {
			 			 
							var response = $http.post('deleteGuard',securityGuardCode);
							response.success(function(data, status, headers,
									config) {
								$scope.guardList = data;
								alert("Security Guard Deleted Successfully...",'','success');
						
							});
							response.error(function(data, status, headers,
									config) {
								alert("Error In Deleting Security Guard..",'','error');
							});
						};
				    		
			
		 
			
			
			$scope.hideItemForm = function() {
				$scope.agencyform=false;
				$scope.updateagencyform=false;
			};
			
			
				$scope.getItemList = function() {
						 
					};
				 
				 
		    }])
		})();
