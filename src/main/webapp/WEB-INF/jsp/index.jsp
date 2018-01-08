<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html ng-app="sahajApp">
<head>
	<meta charset="utf-8">
	<title>Solar dashboard</title>
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="stylesheet" href="styles/vendor.css">
	<link rel="stylesheet" href="styles/app.css">
	 
	
</head>
<body ng-controller="App" sn-demo="" ng-class="{'nav-static': app.state['nav-static'], 'login-page': $state.is('login'), 'error-page': $state.is('error')}">

<!--[if lt IE 10]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

	<div class="app" id="app" ui-view=""></div>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyD50GdjI4FhUFwaugpc8GdvfBMb7haqWEQ&sensor=true"></script>
	 <!--  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>  -->
	<!--  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD50GdjI4FhUFwaugpc8GdvfBMb7haqWEQ&callback=myMap"></script> -->
	
	<!-- LIB 1 -->
	
	<!--  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> -->
		<script type="text/javascript" src="scripts/d3/d3.min.js"></script>
		<script type="text/javascript" src="scripts/nvd3/build/nv.d3.min.js"></script>		
		<script type="text/javascript" src="scripts/jquery/dist/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/jquery-ui/jquery-ui.min.js"></script>
		<script type="text/javascript" src="scripts/jquery.sparkline/index.js"></script>
		<script type="text/javascript" src="scripts/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>		
		<script type="text/javascript" src="scripts/jquery-touchswipe/jquery.touchSwipe.min.js"></script>		
		<script type="text/javascript" src="scripts/raphael/raphael-min.js"></script>
		<script type="text/javascript" src="scripts/jQuery-Mapael/js/jquery.mapael.js"></script>		
		<script type="text/javascript" src="scripts/jQuery-Mapael/js/maps/france_departments.js"></script>
		<script type="text/javascript" src="scripts/jQuery-Mapael/js/maps/usa_states.js"></script>
		<script type="text/javascript" src="scripts/jQuery-Mapael/js/maps/world_countries.js"></script>
		<script type="text/javascript" src="scripts/MetroJS/release/MetroJs.Full/MetroJs.min.js"></script>
		<script type="text/javascript" src="scripts/jquery-animateNumber/jquery.animateNumber.min.js"></script>
		<script type="text/javascript" src="scripts/jquery.nestable/jquery.nestable.js"></script>
		<script type="text/javascript" src="scripts/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
		<script type="text/javascript" src="scripts/jquery-autosize/jquery.autosize.min.js"></script>
		<script type="text/javascript" src="scripts/slimScroll/jquery.slimscroll.min.js"></script>
		<script type="text/javascript" src="scripts/datatables/media/js/jquery.dataTables.min.js"></script>		
		<script type="text/javascript" src="scripts/datatables/media/js/dataTables.bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/modernizr/modernizr.js"></script>
		<script type="text/javascript" src="scripts/moment/moment.js"></script>		
		<script type="text/javascript" src="scripts/moment-timezone/builds/moment-timezone-with-data-2010-2020.min.js"></script>
		<script type="text/javascript" src="scripts/underscore/underscore-min.js"></script>		
		<script type="text/javascript" src="scripts/backgrid-paginator/api/extjs/ext-all.js"></script>		
		<script type="text/javascript" src="scripts/backbone/backbone-min.js"></script>
		<script type="text/javascript" src="scripts/backbone.paginator/lib/backbone.paginator.min.js"></script>		
		<script type="text/javascript" src="scripts/backgrid/lib/backgrid.min.js"></script>
		<script type="text/javascript" src="scripts/backgrid-paginator/backgrid-paginator.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap-sass/assets/javascripts/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap-application-wizard/src/bootstrap-wizard.min.js"></script>		
		<script type="text/javascript" src="scripts/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap_calendar/bootstrap_calendar/js/bootstrap_calendar.min.js"></script>
		<script type="text/javascript" src="scripts/twitter-bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>	
		<script type="text/javascript" src="scripts/bootstrap-markdown/js/bootstrap-markdown.js"></script>
		<script type="text/javascript" src="scripts/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
		<script type="text/javascript" src="scripts/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/angular/angular.min.js"></script>
		<script type="text/javascript" src="scripts/angular-animate/angular-animate.min.js"></script>
		<script type="text/javascript" src="scripts/angular-cookies/angular-cookies.min.js"></script>
		<script type="text/javascript" src="scripts/angular-touch/angular-touch.min.js"></script>
		<script type="text/javascript" src="scripts/angular-sanitize/angular-sanitize.min.js"></script>
		<script type="text/javascript" src="scripts/angular-ui-router/release/angular-ui-router.min.js"></script>
		<script type="text/javascript" src="scripts/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
		<script type="text/javascript" src="scripts/angular-ui-utils/jq.min.js"></script>
		<script type="text/javascript" src="scripts/angular-ui-event/dist/event.min.js"></script>
		<script type="text/javascript" src="scripts/angular-ui-calendar/src/calendar.js"></script>
		<script type="text/javascript" src="scripts/angular-bootstrap-select/build/angular-bootstrap-select.min.js"></script>
		<script type="text/javascript" src="scripts/angular-mocks/angular-mocks.js"></script>
		<script type="text/javascript" src="scripts/angular-resource/angular-resource.min.js"></script>
		<script type="text/javascript" src="scripts/angular-datatables/dist/angular-datatables.min.js"></script>
		<script type="text/javascript" src="scripts/angular-datatables/dist/plugins/bootstrap/angular-datatables.bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/angular-summernote/dist/angular-summernote.min.js"></script>
		<script type="text/javascript" src="scripts/widgster/widgster.js"></script>		
		<script type="text/javascript" src="scripts/rickshaw/rickshaw.min.js"></script>
		<script type="text/javascript" src="scripts/gmaps/gmaps.min.js"></script>
		<script type="text/javascript" src="scripts/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script type="text/javascript" src="scripts/jvectormap-world/index.js"></script>
		<script type="text/javascript" src="scripts/fullcalendar/dist/fullcalendar.min.js"></script>		
		<script type="text/javascript" src="scripts/shufflejs/dist/jquery.shuffle.min.js"></script>		
		<script type="text/javascript" src="scripts/messenger/build/js/messenger.min.js"></script>
		<script type="text/javascript" src="scripts/messenger/build/js/messenger-theme-future.js"></script>
		<script type="text/javascript" src="scripts/messenger/docs/welcome/javascripts/location-sel.js"></script>
		<script type="text/javascript" src="scripts/skycons/skycons.js"></script>
		<script type="text/javascript" src="scripts/flot/jquery.flot.js"></script>
		<script type="text/javascript" src="scripts/flot/jquery.flot.time.js"></script>		
		<script type="text/javascript" src="scripts/flot-orderBars/js/jquery.flot.orderBars.js"></script>		
		<script type="text/javascript" src="scripts/morris.js/morris.min.js"></script>
		<script type="text/javascript" src="scripts/markdown/lib/markdown.js"></script>		
		<script type="text/javascript" src="scripts/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>		
		<script type="text/javascript" src="scripts/parsleyjs/dist/parsley.js"></script>
		<script type="text/javascript" src="scripts/select2/select2.min.js"></script>
		<script type="text/javascript" src="scripts/dropzone/dist/min/dropzone.min.js"></script>
		<script type="text/javascript" src="scripts/holderjs/holder.min.js"></script>
		<script type="text/javascript" src="scripts/switchery/dist/switchery.min.js"></script>		
		<script type="text/javascript" src="scripts/fastclick/lib/fastclick.js"></script>	
		<script type="text/javascript" src="scripts/flot.animator/jquery.flot.animator.min.js"></script>
		<script type="text/javascript" src="scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>		
		<script type="text/javascript" src="scripts/mocha/mocha.js"></script>				
		<script type="text/javascript" src="scripts/summernote/dist/summernote.min.js"></script>		
		<script type="text/javascript" src="scripts/transitionize/dist/transitionize.min.js"></script>
		<script type="text/javascript" src="scripts/ngstorage/ngStorage.min.js"></script>
		<script type="text/javascript" src="scripts/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js"></script>
		<script type="text/javascript" src="scripts/angular-bootstrap-slider-master/slider.js"></script>
		 
		<!-- DEV 1 -->
		<script type="text/javascript" src="app/modules/core/core.module.js"></script>
		<script type="text/javascript" src="app/modules/core/core.js"></script>
		<script type="text/javascript" src="app/modules/core/config.js"></script>
		<script type="text/javascript" src="app/modules/core/chat/chat.js"></script>
		<script type="text/javascript" src="app/modules/core/navigation/navigation.js"></script>
		<script type="text/javascript" src="app/modules/core/notifications/notifications.js"></script>
		<script type="text/javascript" src="app/modules/core/utils/utils.js"></script>
		<script type="text/javascript" src="app/modules/core/widget/widget.js"></script>

		
		<script type="text/javascript" src="app/modules/form-wizard/form-wizard.module.js"></script>
		<script type="text/javascript" src="app/modules/form-wizard/form-wizard.js"></script>
	
		<script type="text/javascript" src="app/modules/form-elements/form-elements.module.js"></script>
		<script type="text/javascript" src="app/modules/form-elements/form-elements.js"></script>
		<script type="text/javascript" src="app/modules/form-validation/form-validation.module.js"></script>
		<script type="text/javascript" src="app/modules/form-validation/form-validation.js"></script>
	
	
		<script type="text/javascript" src="app/modules/components/dropzone/dropzone.module.js"></script>
		<script type="text/javascript" src="app/modules/components/dropzone/dropzone.js"></script>
		<script type="text/javascript" src="app/modules/components/flot/flot.module.js"></script>
		<script type="text/javascript" src="app/modules/components/flot/flot.js"></script>
		<script type="text/javascript" src="app/modules/components/gallery/gallery.module.js"></script>
		<script type="text/javascript" src="app/modules/components/gallery/gallery.js"></script>		
		<script type="text/javascript" src="app/modules/components/gmap/gmap.module.js"></script>
		<script type="text/javascript" src="app/modules/components/gmap/gmap.js"></script>		
		<script type="text/javascript" src="app/modules/components/holderjs/holderjs.module.js"></script>
		<script type="text/javascript" src="app/modules/components/holderjs/holderjs.js"></script>
		<script type="text/javascript" src="app/modules/components/mapael/mapael.module.js"></script>
		<script type="text/javascript" src="app/modules/components/mapael/mapael.js"></script>
		<script type="text/javascript" src="app/modules/components/morris/morris.module.js"></script>
		<script type="text/javascript" src="app/modules/components/morris/morris.js"></script>
		<script type="text/javascript" src="app/modules/components/nvd3/nvd3.module.js"></script>
		<script type="text/javascript" src="app/modules/components/nvd3/nvd3.js"></script>
		<script type="text/javascript" src="app/modules/components/rickshaw/rickshaw.module.js"></script>
		<script type="text/javascript" src="app/modules/components/rickshaw/rickshaw.js"></script>
		<script type="text/javascript" src="app/modules/components/skycon/skycon.module.js"></script>
		<script type="text/javascript" src="app/modules/components/skycon/skycon.js"></script>
		<script type="text/javascript" src="app/modules/components/sparkline/sparkline.module.js"></script>
		<script type="text/javascript" src="app/modules/components/sparkline/sparkline.js"></script>
		<script type="text/javascript" src="app/modules/components/switchery/switcher.module.js"></script>
		<script type="text/javascript" src="app/modules/components/switchery/switchery.js"></script>
		<script type="text/javascript" src="app/modules/components/tile/tile.module.js"></script>
		<script type="text/javascript" src="app/modules/components/tile/tile.js"></script>		
		<script type="text/javascript" src="app/modules/components/wizard/wizard.module.js"></script>
		<script type="text/javascript" src="app/modules/components/wizard/wizard.js"></script>				
					
		<script type="text/javascript" src="app/modules/ui-buttons/ui-buttons.module.js"></script>
		<script type="text/javascript" src="app/modules/ui-buttons/ui-buttons.js"></script>
		<script type="text/javascript" src="app/modules/ui-components/ui-components.module.js"></script>
		<script type="text/javascript" src="app/modules/ui-components/ui-components.js"></script>
		
		<script type="text/javascript" src="app/modules/ui-tabs-accordion/ui-tabs-accordion.module.js"></script>
		<script type="text/javascript" src="app/modules/ui-tabs-accordion/ui-tabs-accordion.js"></script>		
		<script type="text/javascript" src="app/modules/widgets/widgets.module.js"></script>
		<script type="text/javascript" src="app/modules/widgets/widgets.js"></script>
		<script type="text/javascript" src="app/modules/widgets/fake-world-data.js"></script>
	
		<script type="text/javascript" src="app/index.js"></script>
		<script type="text/javascript" src="scripts/pace.js/pace.min.js" data-pace-options='{ "target": ".content-wrap", "ghostTime": 1000 }'></script>
		
		
		<!--  Amar Code Starts Here -->
		
		<script type="text/javascript" src="app/modules/Master/Van/Van.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/van/Van.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/District/District.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/District/District.js"></script>
		<script type="text/javascript" src="app/modules/Master/Transporter/Transporter.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Transporter/Transporter.js"></script>
		
		<!--  Amar Code Ends Here -->
		
		<!--  Amit Code Starts Here -->
		
		<script type="text/javascript" src="app/modules/Master/Bank/Bank.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Bank/Bank.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/CustomerCategory/CustomerCategory.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/CustomerCategory/CustomerCategory.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/Customer/Customer.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Customer/Customer.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/TransporterType/TransporterType.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/TransporterType/TransporterType.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/Route/Route.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Route/Route.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/Uom/Uom.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Uom/Uom.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/IdcardType/IdcardType.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/IdcardType/IdcardType.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/ItemCategory/ItemCategory.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/ItemCategory/ItemCategory.js"></script> 
		
		<!--  Amit Code Ends Here -->
		
		<!--  Ankita Code Starts Here -->
		
		<script type="text/javascript" src="app/modules/Master/Sector/Sector.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Sector/Sector.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/Item/Item.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/Item/Item.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/SecurityAgency/SecurityAgency.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/SecurityAgency/SecurityAgency.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/CompanyProfile/CompanyProfile.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/CompanyProfile/CompanyProfile.js"></script>
		
		<script type="text/javascript" src="app/modules/Master/SecurityGuard/SecurityGuard.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/SecurityGuard/SecurityGuard.js"></script>	

		<!--  Ankita Code Ends Here -->
		
		<!--  Saurabh Code Starts Here -->
		
		<script type="text/javascript" src="app/modules/Dashboard/Dashboard.module.js"></script>
		<script type="text/javascript" src="app/modules/Dashboard/Dashboard.js"></script>
		
		<script type="text/javascript" src="app/modules/Reports/DispatchReport/DispatchReport.module.js"></script>
		<script type="text/javascript" src="app/modules/Reports/DispatchReport/DispatchReport.js"></script>
		
		<!--  Saurabh Code Ends Here -->
		
		<!--  Vicky Code Starts Here -->
		
		<script type="text/javascript" src="app/modules/Master/State/State.module.js"></script>
		<script type="text/javascript" src="app/modules/Master/State/State.js"></script>
		
		<script type="text/javascript" src="app/modules/Transaction/PurchaseOrder/PurchaseOrder.module.js"></script>
		<script type="text/javascript" src="app/modules/Transaction/PurchaseOrder/PurchaseOrder.js"></script>
		
		 
		<!--  Vicky Code Ends Here -->
		
		
		
		
</body>
</html>