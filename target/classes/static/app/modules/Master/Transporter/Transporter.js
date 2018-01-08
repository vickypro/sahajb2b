(function() {
	'use strict';

	angular.module('sahajApp.Transporter').controller('TransporterCtrl',

	[ '$scope', '$http', function($scope, $http, SweetAlert) {
		;

		$scope.transporter={};
		$scope.transporterList={};
		
		
		
		$scope.newTransporter=function(){
		
			var response = $http.post('newTransporter');
			response.success(function(data, status, headers,
					config) {
				$scope.transporter = data;
				 console.log(data);
			});
			response.error(function(data, status, headers,
					config) {
			});
		};
	
		
		 $scope.sendMail = function() {
			 var response =	$http({
	 				method : 'GET',
	 				url : '/SendMail'
	 			 
	 			}).success(function(data, status, headers, config) {
	 			
	 			}).error(function(data, status, headers, config) {
	 				alert("failure");
	 			});
	 		};
		
		
		  $scope.deleteTransporter = function(partyCode) {

				var response = $http.post('deleteTransporter',partyCode);
				response.success(function(data, status, headers,
						config) {
				 $scope.transporterList = data;
					alert("Transporter Deleted Successfully...",'','success');
			
				});
				response.error(function(data, status, headers,
						config) {
					alert("Error In Deleting Transporter..",'','error');
				});
			};
	    		
	 
			$scope.getTransporterDetails = function(partyCode) {
				  
					$scope.updateTransporterbutton = true;
					$scope.updateTransporterform = true;
					
				   var response = $http.post('getTransporterDetails',partyCode);
				   response.success(function(data, status, headers,config) {
						$scope.transporter = data;	
						 
						$scope.getStateList();
						console.log($scope.transporter);
						
						 
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
 		
 		
    	
    	$scope.showItemForm = function() {
    	 
    		$scope.Transporterform=true;
    		$scope.updateTransporterbutton = false;
			$scope.getStateList();
			$scope.newTransporter();
			$scope.sendMail();
			
		
    	
    	};
    	
    	
    	
 	$scope.saveTransporter = function() {
 		$scope.transporter = JSON.stringify($scope.transporter);
	console.log($scope.transporter);
	var response = $http.post('saveTransporter ',$scope.transporter);
	response.success(function(data, status, headers,
			config) {
		$scope.list = data;
		alert("data Saved Successfully...",'','success');
		 
	});
	response.error(function(data, status, headers,
			config) {
		 
	});
	
	};
	
	
	$scope.getTransporterList = function() {
		 
		$http({
			method : 'GET',
			url : '/getTransporterList'
		}).success(function(data, status, headers, config) {
			$scope.transporterList = data;
			console.log($scope.transporterList);
			 
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
	};
	
	
	
	$scope.hideItemForm = function() {
		$scope.Transporterform=false;
		$scope.updateTransporterform=false;
	};
	
			
			$scope.updateTransporter = function() {
				
				$scope.agency = JSON.stringify($scope.transporter);
				   console.log($scope.transporter);
				   alert("update");
				  	var response = $http.post('updateTransporter', $scope.transporter);
					response.success(function(data, status, headers, config) {
				
					 
						alert("Transporter updated Successfully...",'','success');
					});
					response.error(function(data, status, headers, config) {
						console.log(data);
						alert("Error in udating Transporter ...",'','success');
						
					});
				
				
				 
			};
			
			
			
			
			 
			
		 
			 
		 
    }])
})();
