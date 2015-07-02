$(document).ready(function () {
            // prepare chart data as an array            
            var  sampleData = [
								{"Browser": "Safari", "Share":	51.2},
								{"Browser": "Opera", "Share": 10.0},
								{"Browser":"Nokia",  "Share": 0.3},
								{"Browser":"Android",  "Share": 23.0},
								{"Browser":"BlackBerry",  "Share": 2.7},
								{"Browser":"Other",  "Share": 12.8}								
								];            
            // prepare jqxChart settings
            var settings = {
                title: "Mobile browsers share",
                description: "(source: wikipedia.org)",
                enableAnimations: true,
                showLegend: true,
                showBorderLine: true,
                legendLayout: { left: 700, top: 160, width: 300, height: 200, flow: 'vertical' },
                padding: { left: 5, top: 5, right: 5, bottom: 5 },
                titlePadding: { left: 0, top: 0, right: 0, bottom: 10 },
                source: sampleData,
                colorScheme: 'scheme03',
                seriesGroups:
                    [
                        {
                            type: 'pie',
                            showLabels: true,
                            series:
                                [
                                    { 
                                        dataField: 'Share',
                                        displayText: 'Browser',
                                        labelRadius: 170,
                                        initialAngle: 15,
                                        radius: 145,
                                        centerOffset: 0,
                                        formatFunction: function (value) {
                                            if (isNaN(value))
                                                return value;
                                            return parseFloat(value) + '%';
                                        },
                                    }
                                ]
                        }
                    ]
            };
            // setup the chart
            $('#chartContainer').jqxChart(settings);
        });