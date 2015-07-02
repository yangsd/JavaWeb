$(document).ready(function () {
	/*{ name: 'month' },
                    { name: 'Change' }*/
		var  sampleData = [
							{"month": "Jan", "Change":	-1.9},
							{"month": "Feb", "Change": -0.9},
							{"month":"Mar",	"Change": 0.8 },
							{"month":"Apr", "Change": 4.1},
							{"month":"May", "Change": 8.0},
							{"month":"Jun", "Change": 11.3},
							{"month":"Jul", "Change": 13.3},
							{"month":"Aug", "Change": 13.0},
							{"month":"Sep", "Change": 10.3},
							{"month":"Oct", "Change": 6.6},
							{"month":"Nov", "Change": 2.1},
							{"month":"Dec", "Change": -0.5}
							];
            settings = {
                title: "U.S. GDP Percentage Change",
                borderLineWidth: 1,
                showBorderLine: true,
                enableAnimations: true,
                description: '(source: Bureau of Economic Analysis)',
                showLegend: false,
                //padding: { left: 5, top: 5, right: 10, bottom: 5 },
                //titlePadding: { left: 0, top: 0, right: 0, bottom: 10 },
                source: sampleData,
                xAxis:
                {
                    //description: 'Year and month',
                    dataField: 'month',
                    unitInterval: 1,
                    //textRotationAngle: -75,
                    formatFunction: function (value, iteChangedex, serie, group) {
                        return value;
                    },
                    valuesOnTicks: false
                },
                colorScheme: 'scheme05',
                seriesGroups:
                [
                    {
                        type: 'column',
                        valueAxis:
                        {
                            description: 'Percentage Change',
                            formatFunction: function (value) {
                                return value + '%';
                            },
                            maxValue: 20,
                            ChangeValue: -20,
                            unitInterval: 2
                        },
                        series:
						    [
                                {
                                    dataField: 'Change',
                                    displayText: 'Change',
                                    toolTipFormatFunction: function(value, iteChangedex, serie, group, categoryValue, categoryAxis) {
                                        return '<DIV style="text-align:left";><b>Year-month: </b>' + categoryValue
                                                 + '<br /><b>GDP Change:</b> ' + value + ' %</DIV>'
                                    },
                                    // Modify this function to return the desired colors.
                                    // jqxChart will call the function for each data point.
                                    // Sequential points that have the same color will be
                                    // grouped automatically in a line segment
                                    colorFunction: function (value, iteChangedex, serie, group) {
                                        return (value < 0) ? '#CC1133' : '#55CC55';
                                    }
                                }
                            ]
                    }
                ]
            };
            $("#chart1").jqxChart(settings);
        });