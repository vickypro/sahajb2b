(function() {
  'use strict';

  angular.module('sahajApp.Dashboard')
    .controller('DashboardController', DashboardController)
    .controller('GeoLocationsWidgetDemoController', GeoLocationsWidgetDemoController)
    .controller('MarketStatsWidgetDemoController', MarketStatsWidgetDemoController)
    .controller('BootstrapCalendarDemoController', BootstrapCalendarDemoController)
    .controller('ChartsDemoController', ChartsDemoController)
    .directive('flotChartAnimator', flotChartAnimator)
    .directive('bootstrapCalendar', bootstrapCalendar)
  ;

  DashboardController.$inject = ['$scope'];
  function DashboardController ($scope) {

  }

  ChartsDemoController.$inject = ['$scope', 'Rickshaw', 'd3', 'nv'];
  function ChartsDemoController ($scope, Rickshaw, d3, nv) {
    $scope.data1 = [
      [1, 20],
      [2, 20],
      [3, 40],
      [4, 30],
      [5, 40],
      [6, 35],
      [7, 47]
    ];
    $scope.data2 = [
      [1, 13],
      [2, 8],
      [3, 17],
      [4, 10],
      [5, 17],
      [6, 15],
      [7, 16]
    ];
    $scope.data3 = [
      [1, 23],
      [2, 13],
      [3, 33],
      [4, 16],
      [5, 32],
      [6, 28],
      [7, 31]
    ];

    $scope.applyRickshawData = function(){
      $scope.seriesData = [ [], [] ];
      $scope.random = new Rickshaw.Fixtures.RandomData(30);

      for (var i = 0; i < 30; i++) {
        $scope.random.addData($scope.seriesData);
      }
      $scope.series = [
        {
          color: '#96E593',
          data: $scope.seriesData[0],
          name: 'Uploads'
        }, {
          color: '#ecfaec',
          data: $scope.seriesData[1],
          name: 'Downloads'
        }
      ];
    };

    $scope.applyRickshawData();


    $scope.sparklineCompositeData = [[2,4,6,2,7,5,3,7,8,3,6], [5,3,7,8,3,6,2,4,6,2,7]];
    $scope.sparklineCompositeOptions = [{
      width: '100%',
      fillColor: '#ddd',
      height: '100px',
      lineColor: 'transparent',
      spotColor: '#c0d0f0',
      minSpotColor: null,
      maxSpotColor: null,
      highlightSpotColor: '#ddd',
      highlightLineColor: '#ddd'
    }, {
      lineColor: 'transparent',
      spotColor: '#c0d0f0',
      fillColor: 'rgba(192, 208, 240, 0.76)',
      minSpotColor: null,
      maxSpotColor: null,
      highlightSpotColor: '#ddd',
      highlightLineColor: '#ddd'
    }];

    $scope.sparklinePieData = [2,4,6];
    $scope.sparklinePieOptions = {
      type: 'pie',
      width: '100px',
      height: '100px',
      sliceColors: ['#F5CB7B', '#FAEEE5', '#f0f0f0']
    };

    $scope.applyNvd3Data = function(){
      /* Inspired by Lee Byron's test data generator. */
      function _stream_layers(n, m, o) {
        if (arguments.length < 3) o = 0;
        function bump(a) {
          var x = 1 / (.1 + Math.random()),
            y = 2 * Math.random() - .5,
            z = 10 / (.1 + Math.random());
          for (var i = 0; i < m; i++) {
            var w = (i / m - y) * z;
            a[i] += x * Math.exp(-w * w);
          }
        }
        return d3.range(n).map(function() {
          var a = [], i;
          for (i = 0; i < m; i++) a[i] = o + o * Math.random();
          for (i = 0; i < 5; i++) bump(a);
          return a.map(function(d, i) {
            return {x: i, y: Math.max(0, d)};
          });
        });
      }

      function testData(stream_names, pointsCount) {
        var now = new Date().getTime(),
          day = 1000 * 60 * 60 * 24, //milliseconds
          daysAgoCount = 60,
          daysAgo = daysAgoCount * day,
          daysAgoDate = now - daysAgo,
          pointsCount = pointsCount || 45, //less for better performance
          daysPerPoint = daysAgoCount / pointsCount;
        return _stream_layers(stream_names.length, pointsCount, .1).map(function(data, i) {
          return {
            key: stream_names[i],
            values: data.map(function(d,j){
              return {
                x: daysAgoDate + d.x * day * daysPerPoint,
                y: Math.floor(d.y * 100) //just a coefficient,
              }
            })
          };
        });
      }

      $scope.nvd31Chart = nv.models.lineChart()
        .useInteractiveGuideline(true)
        .margin({left: 28, bottom: 30, right: 0})
        .color(['#82DFD6', '#ddd']);

      $scope.nvd31Chart.xAxis
        .showMaxMin(false)
        .tickFormat(function(d) { return d3.time.format('%b %d')(new Date(d)) });

      $scope.nvd31Chart.yAxis
        .showMaxMin(false)
        .tickFormat(d3.format(',f'));

      $scope.nvd31Data = testData(['Plan', 'Actual'], 50).map(function(el, i){
        el.area = true;
        return el;
      });

      $scope.nvd32Chart = nv.models.multiBarChart()
        .margin({left: 28, bottom: 30, right: 0})
        .color(['#F7653F', '#ddd']);

      $scope.nvd32Chart.xAxis
        .showMaxMin(false)
        .tickFormat(function(d) { return d3.time.format('%b %d')(new Date(d)) });

      $scope.nvd32Chart.yAxis
        .showMaxMin(false)
        .tickFormat(d3.format(',f'));

      $scope.nvd32Data = testData(['Actual', 'Plan'], 10).map(function(el, i){
        el.area = true;
        return el;
      });
    };

    $scope.applyNvd3Data();

    $scope.morris1Options = {
      resize: true,
      data: [
        { y: '2006', a: 100, b: 90 },
        { y: '2007', a: 75,  b: 65 },
        { y: '2008', a: 50,  b: 40 },
        { y: '2009', a: 75,  b: 65 },
        { y: '2010', a: 50,  b: 40 },
        { y: '2011', a: 75,  b: 65 },
        { y: '2012', a: 100, b: 90 }
      ],
      xkey: 'y',
      ykeys: ['a'],
      labels: ['Series A'],
      lineColors: ['#88C4EE']
    };

    $scope.morris2Options = {
      resize: true,
      data: [
        { y: '2006', a: 100, b: 90 },
        { y: '2007', a: 75,  b: 65 },
        { y: '2008', a: 50,  b: 40 },
        { y: '2009', a: 75,  b: 65 },
        { y: '2010', a: 50,  b: 40 },
        { y: '2011', a: 75,  b: 65 },
        { y: '2012', a: 100, b: 90 }
      ],
      xkey: 'y',
      ykeys: ['a', 'b'],
      labels: ['Series A', 'Series B'],
      lineColors: ['#80DE78', '#9EEE9B'],
      lineWidth: 0
    };

    $scope.morris3Options = {
      data: [
        {label: 'Exp Stock', value: 22},
        {label: 'AED Stock', value: 30},
        {label: 'Accessory', value: 10}
      ],
      colors: ['#F7653F', '#F8C0A2', '#e6e6e6']
    };

    var bar_customised_1 = [[1388534400000, 120], [1391212800000, 70],  [1393632000000, 100], [1396310400000, 60], [1398902400000, 35]];
    var bar_customised_2 = [[1388534400000, 90], [1391212800000, 60], [1393632000000, 30], [1396310400000, 73], [1398902400000, 30]];
    var bar_customised_3 = [[1388534400000, 80], [1391212800000, 40], [1393632000000, 47], [1396310400000, 22], [1398902400000, 24]];

    $scope.flotBarsData = [
      {
        label: 'RajEnter',
        data: bar_customised_1,
        bars: {
          show: true,
          barWidth: 12*24*60*60*300,
          fill: true,
          lineWidth:0,
          order: 1
        }
      },
      {
        label: 'RamRaja',
        data: bar_customised_2,
        bars: {
          show: true,
          barWidth: 12*24*60*60*300,
          fill: true,
          lineWidth: 0,
          order: 2
        }
      },
      {
        label: 'AtoZ Exp',
        data: bar_customised_3,
        bars: {
          show: true,
          barWidth: 12*24*60*60*300,
          fill: true,
          lineWidth: 0,
          order: 3
        }
      }

    ];

    $scope.flotBarsOptions = {
      series: {
        bars: {
          show: true,
          barWidth: 12*24*60*60*350,
          lineWidth: 0,
          order: 1,
          fillColor: {
            colors: [{
              opacity: 1
            }, {
              opacity: 0.7
            }]
          }
        }
      },
      xaxis: {
        mode: 'time',
        min: 1387497600000,
        max: 1400112000000,
        tickLength: 0,
        tickSize: [1, 'month'],
        axisLabel: 'Month',
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 13,
        axisLabelPadding: 15
      },
      yaxis: {
        axisLabel: 'Value',
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 13,
        axisLabelPadding: 5
      },
      grid: {
        hoverable: true,
        borderWidth: 0
      },
      legend: {
        backgroundColor: 'transparent',
        labelBoxBorderColor: 'none'
      },
      colors: ['#64bd63', '#f0b518', '#F7653F']
    }
  }

  flotChartAnimator.$inject = ['jQuery'];
  function flotChartAnimator(jQuery){
    return {
      link: function (scope, $el, attrs){
        function render(){
          jQuery.plotAnimator($el, scope[attrs.ngModel],{
            xaxis: {
              tickLength: 0,
              tickDecimals: 0,
              min:2,
              font :{
                lineHeight: 13,
                weight: "bold",
                color: scope.app.settings.colors['gray-semi-light']
              }
            },
            yaxis: {
              tickDecimals: 0,
              tickColor: "#f3f3f3",
              font :{
                lineHeight: 13,
                weight: "bold",
                color: scope.app.settings.colors['gray-semi-light']
              }
            },
            grid: {
              backgroundColor: { colors: [ "#fff", "#fff" ] },
              borderWidth:1,
              borderColor:"#f0f0f0",
              margin:0,
              minBorderMargin:0,
              labelMargin:20,
              hoverable: true,
              clickable: true,
              mouseActiveRadius:6
            },
            legend: false
          });
        }
        render();
      }
    }
  }




  GeoLocationsWidgetDemoController.$inject = ['$scope', 'config'];
  function GeoLocationsWidgetDemoController ($scope, config) {
    var state;
    $scope.mapData = {
      map:{
        name : 'usa_states',
        defaultArea : {
          attrsHover : {
            fill : '#242424',
            animDuration : 100
          },
          tooltip: {
            content: function(){
              return '<strong>' + state + '</strong>';
            }
          },
          eventHandlers: {
            mouseover: function(e, id){
              state = id;
            }
          }
        },
        defaultPlot:{
          size: 17,
          attrs : {
            fill : config.settings.colors['brand-warning'],
            stroke : '#fff',
            'stroke-width' : 0,
            'stroke-linejoin' : 'round'
          },
          attrsHover : {
            'stroke-width' : 1,
            animDuration : 100
          }
        },
        zoom : {
          enabled : true,
          step : 0.75,
          mousewheel: false
        }
      },
      plots:{
        'ny' : {
          latitude:18.6499225 ,
          longitude:  73.7710342,
          tooltip: {content : 'India'}
        },
        /*'on' : {
          latitude: 33.145235,
          longitude: -83.811834,
          size: 18,
          tooltip: {content : 'Oconee National Forest'}
        },
        'sf' : {
          latitude: 37.792032,
          longitude: -122.394613,
          size: 12,
          tooltip: {content : 'San Francisco'}
        },
        'la' : {
          latitude: 26.935080,
          longitude: -80.851766,
          size: 26,
          tooltip: {content : 'Lake Okeechobee'}
        },
        'gc' : {
          latitude: 36.331308,
          longitude: -83.336050,
          size: 10,
          tooltip: {content : 'Grainger County'}
        },
        'cc' : {
          latitude: 36.269356,
          longitude: -76.587477,
          size: 22,
          tooltip: {content : 'Chowan County'}
        },
        'll' : {
          latitude: 30.700644,
          longitude: -95.145249,
          tooltip: {content : 'Lake Livingston'}
        },
        'tc' : {
          latitude: 34.546708,
          longitude: -90.211471,
          size: 14,
          tooltip: {content : 'Tunica County'}
        },
        'lc' : {
          latitude: 32.628599,
          longitude: -103.675115,
          tooltip: {content : 'Lea County'}
        },
        'uc' : {
          latitude: 40.456692,
          longitude: -83.522688,
          size: 11,
          tooltip: {content : 'Union County'}
        },
        'lm' : {
          latitude: 33.844630,
          longitude: -118.157483,
          tooltip: {content : 'Lakewood Mutual'}
        }*/
      }
    };
  }

  MarketStatsWidgetDemoController.$inject = ['$scope', 'Rickshaw'];
  function MarketStatsWidgetDemoController ($scope, Rickshaw) {

    $scope.seriesData = [ [], [] ];
    $scope.random = new Rickshaw.Fixtures.RandomData(30);

    for (var i = 0; i < 30; i++) {
      $scope.random.addData($scope.seriesData);
    }
    $scope.series = [
      {
        color: '#F7653F',
        data: $scope.seriesData[0],
        name: 'Uploads'
      }, {
        color: '#F7D9C5',
        data: $scope.seriesData[1],
        name: 'Downloads'
      }
    ]

  }

  BootstrapCalendarDemoController.$inject = ['$scope'];
  function BootstrapCalendarDemoController ($scope) {
    var now = new Date();
    $scope.month = now.getMonth() + 1;
    $scope.year = now.getFullYear();
  }

  bootstrapCalendar.$inject = ['jQuery'];
  function bootstrapCalendar(jQuery){
    return {
      restrict: 'A',
      link: function(scope, $el, attrs){
        function render(){
          var monthNames = ['January', 'February', 'March', 'April', 'May', 'June',  'July', 'August', 'September', 'October', 'November', 'December'];

          var dayNames = ['S', 'M', 'T', 'W', 'T', 'F', 'S'];

          var events = scope.$eval(attrs.events);
          var $calendar = $el;
          $calendar.calendar({
            months: monthNames,
            days: dayNames,
            events: events,
            popover_options:{
              placement: 'top',
              html: true
            }
          });
          $calendar.find('.icon-arrow-left').addClass('fa fa-arrow-left');
          $calendar.find('.icon-arrow-right').addClass('fa fa-arrow-right');
          function restyleCalendar(){
            $calendar.find('.event').each(function(){
              var $this = jQuery(this),
                $eventIndicator = jQuery('<span></span>');
              $eventIndicator.css('background-color', $this.css('background-color')).appendTo($this.find('a'));
              $this.css('background-color', '');
            })
          }
          $calendar.find('.icon-arrow-left, .icon-arrow-right').parent().on('click', restyleCalendar);
          restyleCalendar();
        }

        attrs.$observe('events', function(){
          render();
        })
      }
    }
  }
})();
