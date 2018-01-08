(function() {
	'use strict';

	angular.module('sahajApp.Route').controller(
			'RouteCtrl',
			[
				'$scope',
				'$http',
				function($scope, $http, SweetAlert) {
					;

					$scope.route = {};
					$scope.routeMapping = {};
					$scope.routeMappingList = [];

					$scope.addNewRoute = function() {
						$scope.getCustomerList();
						$scope.getStateList();
						$scope.routeForm = true;
						$scope.updateRouteForm = false;
						$scope.route = {};
						$scope.routeMapping = {};
						$scope.routeMappingList = [];
												
						$http({
							method : 'GET',
							url : '/getDistrictId'
						}).success(function(data, status, headers, config) {
							
							var response = $http.post('getStateDetails',data.stateId);
							response.success(function(stateData, status, headers,config) {
								
								$scope.routeMappingList.push({
									"routeMappingId" : 1,
									"stateId" : data.stateId,
									"districtId" : data.districtId,
									"emailId" : data.emailId,
									"ccEmailId": stateData.ccEmailId,
									"ccOfficeAddress1": stateData.ccOfficeAddress1,
									"ccOfficeAddress2": stateData.ccOfficeAddress2,
									"reachedDays": 0,
								});
							}).error(function(data, status, headers, config) {
								console.log("failure");
							});
						}).error(function(data, status, headers, config) {
							console.log("failure");
						});
					}

					$scope.backToRouteList = function() {
						$scope.routeForm = false;
						$scope.updateRouteForm = false;
						$scope.route = {};
						$scope.routeMapping = {};
						$scope.routeMappingList = [];
					}
					
					$scope.getRouteList = function() {
						$http({
							method : 'GET',
							url : '/getRouteList'
						}).success(function(data, status, headers, config) {
							$scope.routeList = data;
						}).error(function(data, status, headers, config) {
							console.log("failure");
						});
					};

					$scope.getCustomerList = function() {
						$http({
							method : 'GET',
							url : '/getCustomerList'
						}).success(function(data, status, headers, config) {
							$scope.customerList = data;
						}).error(function(data, status, headers, config) {
							console.log("failure");
						});
					};

					$scope.getMagazineListForCustomer = function(customerId) {
						var response = $http.post('getMagazineListForCustomer',customerId);
						response.success(function(data, status, headers,config) {
							$scope.magazineList = data;								
						});
						response.error(function(data, status, headers,config) {
							console.log("failure");
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

					$scope.getStateDetails = function(stateId) {

						var response = $http.post('getStateDetails',stateId);
						response.success(function(data, status, headers,config) {
							$scope.routeMapping.ccEmailId = data.ccEmailId;
							$scope.routeMapping.ccOfficeAddress1 = data.ccOfficeAddress1;
							$scope.routeMapping.ccOfficeAddress2 = data.ccOfficeAddress2;
						});
						response.error(function(data, status, headers,config) {
							console.log("failure");
						});
					};

					$scope.getDistrictListForState = function(stateId) {
						var response = $http.post('getDistrictListForState',stateId);
						response.success(function(data, status, headers,config) {
							$scope.districtList = data;								
						});
						response.error(function(data, status, headers,config) {
							console.log("failure");
						});
					};
					
					$scope.getDistrictDetails = function(districtId) {
						var response = $http.post('getDistrictDetails',districtId);
						response.success(function(data, status, headers,config) {
							$scope.routeMapping.emailId = data.emailId;
						});
						response.error(function(data, status, headers,config) {
							alert("Error In Getting District Details...",'', 'error');
						});
					}
					
					$scope.addRouteDetails = function() { 
					    var count = 0;
					    var chkprtcnt = 0;
					    
					    if($scope.routeMappingList!=''){
					      angular.forEach($scope.routeMappingList,function(it){
					        if($scope.routeMapping.districtId == it.districtId){
					          alert("District Already Exist...!","","warning");
					          chkprtcnt++;
					        }
					      });
					      
					      if(chkprtcnt==0){
					    	$scope.routeMapping.routeMappingId = parseInt($scope.routeMappingList.length) + parseInt(1);
					        $scope.addRouteDetailsFinal();
					        $scope.routeMapping={};
					      }
					    }else{
					    	$scope.routeMapping.routeMappingId = parseInt(2);
					    	$scope.addRouteDetailsFinal();
					    	$scope.routeMapping={};
					    }
					  };
					  
					  $scope.addRouteDetailsFinal = function() { 
						  
						  $scope.routeMappingList.push({
								"routeMappingId" : $scope.routeMapping.routeMappingId,
								"stateId" : $scope.routeMapping.stateId,
								"districtId" : $scope.routeMapping.districtId,
								"emailId" : $scope.routeMapping.emailId,
								"ccEmailId": $scope.routeMapping.ccEmailId,
								"ccOfficeAddress1": $scope.routeMapping.ccOfficeAddress1,
								"ccOfficeAddress2": $scope.routeMapping.ccOfficeAddress2,
								"reachedDays": $scope.routeMapping.reachedDays,
							});
						  };
						  
						  $scope.removeRouteDetails = function(index){ 
							    $scope.routeMappingList.splice(index,1);
						  };

					$scope.saveRoute = function() {
						$scope.route.routeMappingList = $scope.routeMappingList;
						$scope.formData = JSON.stringify($scope.route);

						var response = $http.post('saveRoute',$scope.formData);
						response.success(function(data, status, headers,
								config) {
							alert("Route Added Successfully...", '','success');
							$scope.backToRouteList();
						});
						response.error(function(data, status, headers,
								config) {
							alert("Error In Adding Route...", '','error');
						});
					};
					
					$scope.getRouteDetails = function(routeId) {
						$scope.routeForm=true;
						$scope.updateRouteForm = true;
						var response = $http.post('getRouteDetails',routeId);
						response.success(function(data, status, headers,config) {
							$scope.route = data;
							$scope.route.customerId = parseInt(data.customerId);
							$scope.getCustomerList();
							$scope.getMagazineListForCustomer(data.customerId);
					    	
					    	$scope.routeMappingList = data.routeMappingList;
					    	
						});
						response.error(function(data, status, headers,config) {
							console.log("Error",'','error');
						});
					}

					$scope.updateRoute = function() {
						$scope.route.routeMappingList = $scope.routeMappingList;
						$scope.formData = JSON.stringify($scope.route);

						var response = $http.post('updateRoute',$scope.formData);
						response.success(function(data, status, headers,config) {
							alert("Route Updated Successfully...", '','success');
							$scope.updateRouteForm = false;
							$scope.routeForm = false;
							$scope.getRouteList();
						});
						response.error(function(data, status, headers,config) {
							alert("Error In Updating Route...", '','error');
						});
					};

				} ])
})();


