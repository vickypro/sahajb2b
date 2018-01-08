(function() {
  'use strict';

  angular.module('sahajApp.Customer')
    .controller('CustomerCtrl', ['$scope','$http','$filter', function($scope,$http,$filter) {
    
  ;
    
    $scope.getData = function() {
        alert("abcd");
          $http.get('http://192.168.1.106:8081/JAXRSJsonCRUDExample/rest/countries').success(function(data) {
            $scope.data = data;
            console.log($scope.data);
           
          });
        };
  
      $scope.showCustomerForm=function(){
    	  $scope.customerForm=true;
    	  $scope.customerButton=true;
    	  $scope.getStateList();
    	  $scope.getCustomerCategoryList();
    	  $scope.getItemCategoryList();
    	  $scope.getUomList();
    	  $scope.getBankList();
    	  
    	  $scope.customer = {};
    	  $scope.magazine = {};
    	  $scope.magazineCapacity = {};
    	  $scope.magazineList = [];
          $scope.magazineCapacityList = [];
          
          $scope.customer.hasSubdealer = 'false';
          $scope.customer.showToSubdealer = 'false';
          $scope.customer.acceptDailyStock = 'false';
          $scope.customer.clubPo = 'false';
          $scope.customer.goodsReceipt = 'false';
          $scope.customer.phoneReportCheck = 'false';
          $scope.customer.activeStatus = 'false';
          $scope.customer.priorityLoadingRequest = 'false';
      };
      
      $scope.hideCustomerForm = function(){
    	 $scope.customerForm=false;
    	 $scope.customer = {};
    	 $scope.magazine = {};
    	 $scope.magazineCapacity = {};
    	 $scope.magazineList = [];
         $scope.magazineCapacityList = [];
      };
      
      $scope.customer = {};
      $scope.magazine = {};
      $scope.magazineCapacity = {};
      $scope.customerList = [];
      $scope.magazineList = [];
      $scope.magazineCapacityList = [];
      
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
		
		$scope.getCustomerCategoryList = function() {
			$http({
				method : 'GET',
				url : '/getCustomerCategoryList'
			}).success(function(data, status, headers, config) {
				$scope.customerCategoryList = data;
			}).error(function(data, status, headers, config) {
				console.log("failure");
			});
		};
		
		$scope.getItemCategoryList = function() {
			$http({
				method : 'GET',
				url : '/getItemCategoryList'
			}).success(function(data, status, headers, config) {
				$scope.itemCategoryList = data;
			}).error(function(data, status, headers, config) {
				console.log("failure");
			});
		};
		
		$scope.getUomList = function() {
			$http({
				method : 'GET',
				url : '/getUomList'
			}).success(function(data, status, headers, config) {
				$scope.uomList = data;
			}).error(function(data, status, headers, config) {
				console.log("failure");
			});
		};
		
		$scope.getBankList = function() {
			$http({
				method : 'GET',
				url : '/getBankList'
			}).success(function(data, status, headers, config) {
				$scope.bankList = data;
			}).error(function(data, status, headers, config) {
				console.log("failure");
			});
		};
		
		$scope.addMagazineDetails = function() { 
		    var count = 0;
		    var chkprtcnt = 0;

		    if($scope.magazineList!=''){
		      angular.forEach($scope.magazineList,function(it){
		        if($scope.magazine.magazineCode == it.magazineCode){
		          alert("Magazine Already Exist...!","","warning");
		          chkprtcnt++;
		        }
		      });
		      if(chkprtcnt==0){
		    	  $scope.magazine.magazineId = parseInt($scope.magazineList.length) + parseInt(1);
		        $scope.addMagazineDetailsFinal();
		        $scope.magazine={};
		        $scope.magazine.stateId = '';
		      }
		    }else{
		    	$scope.magazine.magazineId = parseInt(1);
		    	$scope.addMagazineDetailsFinal();
		    	$scope.magazine={};
		    	$scope.magazine.stateId = '';
		    }
		  };
		
		$scope.addMagazineDetailsFinal = function() { 
		    $scope.magazineList.push({
		      "magazineId": $scope.magazine.magazineId,
		      "magazineCode": $scope.magazine.magazineCode,
		      "magazineName": $scope.magazine.magazineName,
		      "description": $scope.magazine.description,
		      "documentKey":$scope.magazine.documentKey,
		      "licenseNumber":$scope.magazine.licenseNumber,
		      "licenseExpiryDate": $scope.magazine.licenseExpiryDate,
		      "address": $scope.magazine.address,
		      "city": $scope.magazine.city,
		      "stateId": $scope.magazine.stateId,
		      "districtId": $scope.magazine.districtId,
		      
		    });
		  };
		  
		  $scope.removeMagazineDetails = function(index){ 
			    $scope.magazineList.splice(index,1);
		  };
		  
		  $scope.addMagazineCapacityDetails = function() { 
			    var count = 0;
			    var chkprtcnt = 0;
			    if($scope.magazineCapacityList!=''){
			      angular.forEach($scope.magazineCapacityList,function(it){
			        if($scope.magazineCapacity.magazineId==it.magazineId && $scope.magazineCapacity.itemCategoryId == it.itemCategoryId){
			          alert("Magazine Capacity Already Exist...!","","warning");
			          chkprtcnt++;
			        }
			      });
			      if(chkprtcnt==0){
			        $scope.addMagazineCapacityDetailsFinal();
			        $scope.magazineCapacity={};
			      }
			    }else{
			      $scope.addMagazineCapacityDetailsFinal();
			      $scope.magazineCapacity={};
			    }
			  };
			
			$scope.addMagazineCapacityDetailsFinal = function() { 
			    $scope.magazineCapacityList.push({
			      "magazineId": $scope.magazineCapacity.magazineId,
			      "itemCategoryId": $scope.magazineCapacity.itemCategoryId,
			      "capacity": $scope.magazineCapacity.capacity,
			      "uomId": $scope.magazineCapacity.uomId,
			      "rotationCapacity":$scope.magazineCapacity.rotationCapacity,			      
			    });
			  };
			  
			  $scope.removeMagazineCapacityDetails = function(index){ 
				    $scope.magazineCapacityList.splice(index,1);
			  };
			  
			  $scope.setDate = function(date) {
				console.log("date-------"+date);
			}
			  
			  $scope.saveCustomer = function() {
				  
				  console.log("customer.tempDate-----------"+$scope.customer.maxMonthTargetDate);
				  
				  $scope.customer.magazineList = $scope.magazineList;
				  $scope.customer.magazineCapacityList = $scope.magazineCapacityList;
				  
				  if($scope.customer.hasSubdealer1 == true || $scope.customer.hasSubdealer2 == true){
					  $scope.customer.hasSubdealer = true;
					} else {
						$scope.customer.hasSubdealer = false;
					}
					
					if($scope.customer.showToSubdealer1 == true || $scope.customer.showToSubdealer2 == true){
						$scope.customer.showToSubdealer = true;
					} else {
						$scope.customer.showToSubdealer = false;
					}
					
					if($scope.customer.acceptDailyStock1 == true || $scope.customer.acceptDailyStock2 == true){
						$scope.customer.acceptDailyStock = true;
					} else {
						$scope.customer.acceptDailyStock = false;
					}
					
					if($scope.customer.clubPo1 == true || $scope.customer.clubPo2 == true){
						$scope.customer.clubPo = true;
					} else {
						$scope.customer.clubPo = false;
					}
					
					if($scope.customer.goodsReceipt1 == true || $scope.customer.goodsReceipt2 == true){
						$scope.customer.goodsReceipt = true;
					} else {
						$scope.customer.goodsReceipt = false;
					}
					
					if($scope.customer.phoneReportCheck1 == true || $scope.customer.phoneReportCheck2 == true){
						$scope.customer.phoneReportCheck = true;
					} else {
						$scope.customer.phoneReportCheck = false;
					}
					
					if($scope.customer.activeStatus1 == true || $scope.customer.activeStatus2 == true){
						$scope.customer.activeStatus = true;
					} else {
						$scope.customer.activeStatus = false;
					}
					
					if($scope.customer.priorityLoadingRequest1 == true || $scope.customer.priorityLoadingRequest2 == true){
						$scope.customer.priorityLoadingRequest = true;
					} else {
						$scope.customer.priorityLoadingRequest = false;
					}
					
				  console.log("customer---------"+JSON
							.stringify($scope.customer));
				  
				  $scope.formData = JSON
							.stringify($scope.customer);

					var response = $http.post('saveCustomer',
							$scope.formData);
					response.success(function(data, status, headers,
							config) {
						$scope.list = data;
						$scope.getCustomerList();
						$scope.customerForm=false;
				    	 $scope.customer = {};
				    	 $scope.magazine = {};
				    	 $scope.magazineCapacity = {};
				    	 $scope.magazineList = [];
				         $scope.magazineCapacityList = [];
						alert("Customer Saved Successfully...",'','success');
					});
					response.error(function(data, status, headers,
							config) {
						alert("Error In Adding Customer...",'','error');
					});
				};
				
				$scope.getCustomerDetails = function(customerId) {
					$scope.customerButton=false;
					$scope.customerForm=true;
					var response = $http.post('getCustomerDetails',customerId);
					response.success(function(data, status, headers,config) {
						$scope.customer = data;
						$scope.customer.stateId = parseInt(data.stateId);
						$scope.getStateList();
						$scope.getDistrictList(data.stateId);
				    	$scope.getCustomerCategoryList();
				    	$scope.getItemCategoryList();
				    	$scope.getUomList();
				    	$scope.getBankList();
				    	
				    	$scope.magazineList = data.magazineList;
				    	$scope.magazineCapacityList = data.magazineCapacityList;
				    	
				    	console.log("$scope.customer-----"+JSON.stringify($scope.customer));
				    	
					});
					response.error(function(data, status, headers,config) {
						console.log("Error",'','error');
					});
				}
				
				$scope.updateCustomer = function() {
					
					if($scope.customer.hasSubdealer1 == true || $scope.customer.hasSubdealer2 == true){
						$scope.customer.hasSubdealer = true;
					} else {
						$scope.customer.hasSubdealer = false;
					}
					
					if($scope.customer.showToSubdealer1 == true || $scope.customer.showToSubdealer2 == true){
						$scope.customer.showToSubdealer = true;
					} else {
						$scope.customer.showToSubdealer = false;
					}
					
					if($scope.customer.acceptDailyStock1 == true || $scope.customer.acceptDailyStock2 == true){
						$scope.customer.acceptDailyStock = true;
					} else {
						$scope.customer.acceptDailyStock = false;
					}
					
					if($scope.customer.clubPo1 == true || $scope.customer.clubPo2 == true){
						$scope.customer.clubPo = true;
					} else {
						$scope.customer.clubPo = false;
					}
					
					if($scope.customer.goodsReceipt1 == true || $scope.customer.goodsReceipt2 == true){
						$scope.customer.goodsReceipt = true;
					} else {
						$scope.customer.goodsReceipt = false;
					}
					
					if($scope.customer.phoneReportCheck1 == true || $scope.customer.phoneReportCheck2 == true){
						$scope.customer.phoneReportCheck = true;
					} else {
						$scope.customer.phoneReportCheck = false;
					}
					
					if($scope.customer.activeStatus1 == true || $scope.customer.activeStatus2 == true){
						$scope.customer.activeStatus = true;
					} else {
						$scope.customer.activeStatus = false;
					}
					
					if($scope.customer.priorityLoadingRequest1 == true || $scope.customer.priorityLoadingRequest2 == true){
						$scope.customer.priorityLoadingRequest = true;
					} else {
						$scope.customer.priorityLoadingRequest = false;
					}
					console.log("****customer************"+JSON
							.stringify($scope.customer));
					$scope.formData = JSON
							.stringify($scope.customer);

					var response = $http.post('updateCustomer',
							$scope.formData);
					response.success(function(data, status, headers,
							config) {
						$scope.getCustomerList();
						$scope.customerForm=false;
				    	 $scope.customer = {};
				    	 $scope.magazine = {};
				    	 $scope.magazineCapacity = {};
				    	 $scope.magazineList = [];
				         $scope.magazineCapacityList = [];
						alert("Customer Updated Successfully...",'','success');
					});
					response.error(function(data, status, headers,
							config) {
						alert("Error In Updating Customer...",'','error');
					});
				};
        
    }])
})();