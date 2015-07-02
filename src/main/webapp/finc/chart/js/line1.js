 $(document).ready(function () {
            // prepare chart data as an array
            var days = [
                { Day: 'Monday' },
                { Day: 'Tuesday' },
                { Day: 'Wednesday' },
                { Day: 'Thursday' },
                { Day: 'Friday' },
                { Day: 'Saturday' },
                { Day: 'Sunday' }
            ];
            var Keith = [
                 { Minutes: 30 },
                 { Minutes: 25 },
                 { Minutes: 30 },
                 { Minutes: 35 },
                 { Minutes: 20 },
                 { Minutes: 30 },
                 { Minutes: 60 }
            ];
            var Erica = [
                 { Minutes: 15 },
                 { Minutes: 25 },
                 { Minutes: 20 },
                 { Minutes: 25 },
                 { Minutes: 20 },
                 { Minutes: 20 },
                 { Minutes: 45 }
            ];
            var George = [
                 { Minutes: 25 },
                 { Minutes: 30 },
                 { Minutes: 25 },
                 { Minutes: 45 },
                 { Minutes: 25 },
                 { Minutes: 30 },
                 { Minutes: 90 }
            ];
            // prepare jqxChart settings
            var settings = {
                title: "Fitness & exercise weekly scorecard",
                description: "Time spent in vigorous exercise",
                enableAnimations: true,
                showLegend: true,
                padding: { left: 5, top: 5, right: 40, bottom: 5 },
                titlePadding: { left: 90, top: 0, right: 0, bottom: 10 },
                source: days,
                source: days,
                xAxis:
                {
                    dataField: 'Day',
                    gridLines: { visible: true }
                },
                colorScheme: 'scheme02',
                valueAxis:
                {
                    visible: true,
                    title: { text: 'Time in minutes' }
                },
                seriesGroups:
                    [
                        {
                            type: 'stackedline',
                            source: Keith,
                            series: [
                                  { dataField: 'Minutes', displayText: 'Keith' }
                            ]
                        },
                        {
                            type: 'stackedline',
                            source: Erica,
                            series: [
                                    { dataField: 'Minutes', displayText: 'Erica' }
                            ]
                        },
                        {
                            type: 'stackedline',
                            source: George,
                            series: [
                                    { dataField: 'Minutes', displayText: 'George' }
                            ]
                        }
                    ]
            };
            // setup the chart
            $('#jqxChart').jqxChart(settings);
        });