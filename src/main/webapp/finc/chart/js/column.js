  $(document).ready(function () {
            // prepare the data
	  		var  sampleData = [
								{"month": "Jan", "min":	-1.9, "max": 3.7},
								{"month": "Feb", "min": -0.9, "max": 5.9},
								{"month":"Mar",	"min": 0.8,	"max": 9.8 },
								{"month":"Apr", "min": 4.1, "max": 	13.9},
								{"month":"May", "min": 8.0, "max": 18.4},
								{"month":"Jun", "min": 11.3, "max": 22.2},
								{"month":"Jul", "min": 13.3, "max": 25.3},
								{"month":"Aug", "min": 13.0, "max": 24.4},
								{"month":"Sep", "min": 10.3, "max": 20.8},
								{"month":"Oct", "min": 6.6, "max": 14.9},
								{"month":"Nov", "min": 2.1, "max": 8.4},
								{"month":"Dec", "min": -0.5, "max": 4.5}
								];
             // prepare jqxChart settings
            var settings = {
                title: "Weather in Geneva, Switzerland",
                description: "Climatological Information about Geneva",
                enableAnimations: true,
                showLegend: true,
                padding: { left: 5, top: 5, right: 5, bottom: 5 },
                titlePadding: { left: 90, top: 0, right: 0, bottom: 10 },
                source: sampleData,
                colorScheme: 'scheme05',
                xAxis:
                {
                    dataField: 'month',
                    displayText: 'Month',
                    unitInterval: 1,
                    gridLines: { interval: 3 }
                },
                valueAxis:
                {
                    unitInterval: 5,
                    title: {
                        visible: true,
                        text: 'Temperature [C]<br>'
                    },
                    labels: {
                        formatSettings: {
                            decimalPlaces: 1,
                            negativeWithBrackets: false
                        },
                        horizontalAlignment: 'right'
                    }
                },
                seriesGroups:
                    [
                        {
                            type: 'column',
                            //useGradient: false,
                            series: [
                                    { dataField: 'max', displayText: 'Max Temperature' },
                                    { dataField: 'min', displayText: 'Min Temperature' }
                                ]
                        }
                    ]
            };
            // setup the chart
            $('#chartContainer').jqxChart(settings);
        });