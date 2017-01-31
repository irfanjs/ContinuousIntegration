(function(HighChartHelper) {
	var chartHeight = 315;
	var customColors = ['#31cfce', '#ff9e08', '#99CC71', '#DC9650', '#6BC5DF', '#EBCF5F', '#66D3A1', 'orange', 'pink', 'gray'];

	function renderChart(elem, chartType, chart, clickfunction) {

		if (chartType == 0) {
			renderColumnChart(elem, chart);
		}
		else if (chartType == 1){
			renderBarChart(elem, chart);
		}
		else if (chartType == 2){
			renderPieChart(elem, chart,clickfunction);
		}
		else if (chartType == 3){
			renderAreaChart(elem, chart,clickfunction);
		}
		else if (chartType == 4){
			renderLineChart(elem, chart);
		}
		else if (chartType == 5){
			renderColumnStackChart(elem, chart);
		}
		else {
			renderColumnChart(elem, chart);
		}
	}
	
	function renderColumnStackChart(elem, chart) {
		
		$.ajax({
			dataType: "json",
			url: "http://10.211.162.150/buildinfo/getdetails", //basePath + 'data/chart2.json',
			data: requestData,
			async:true,
			cache: false,
			success: function (data) {
				showReport('#chartUnitTestModulewise', data);
				$('#chartUnitTestModulewise').highcharts({
					chart: {
						type: 'column',
						height: minimizedHeight,
						//width:370
					},
					colors: ['#8497eb','#669933','#3063a7'],
					title: {
						text: ''
					},
					subtitle: {
						text: ''
					},
					xAxis: {
						gridLineWidth: 1,
						categories: data.categories
					},
					yAxis: {
						min: 0,
						title: {
							text: ''
						}
					},
					tooltip: {
						headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
						pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
							'<td style="padding:0"><b>{point.y}</b></td></tr>',
						footerFormat: '</table>',
						shared: true,
						useHTML: true
					},
					credits: {
						enabled: false
					},
					plotOptions: {
                		series: {
                    		stacking: 'normal'
                		}
            		},
					series:  data.data
				});
			},
			error: function (a, err, c) {
				alert("error");
			}
		});
		
		
	}
	
	

	function renderColumnChart(elem, chart) {
		$(elem).highcharts({
			chart: {
				type: 'column',
				height: chartHeight,
				//width:370
			},
			colors: customColors,
			title: {
				text: ''
			},
			subtitle: {
				text: ''
			},
			xAxis: {
				gridLineWidth: 1,
				categories: chart.Categories
			},
			yAxis: {
				min: 0,
				title: {
					text: ''
				}
			},
			tooltip: {
				headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					'<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
				footerFormat: '</table>',
				shared: true,
				useHTML: true
			},
			plotOptions: {
				column: {
					pointPadding: 0,
					borderWidth: 0
				}
			},
			series: [{
			    showInLegend: false,
				name: chart.Data[0].SeriesName,
			    //data: chart.Data[0].Data
				data: getModifiedSeriesData(chart)
			}]
		});
	}


	function renderBarChart(elem, chart) {
		$(elem).highcharts({
			chart: {
				type: 'bar',
				height: chartHeight,
				//width: 370
			},
			colors: customColors,
			title: {
				text: ''
			},
			subtitle: {
				text: ''
			},
			xAxis: {
				gridLineWidth: 1,
				categories: chart.Categories,
				title: {
					text: null
				}
			},
			yAxis: {
				min: 0,
				title: {
					text: '',
					align: 'high'
				},
				labels: {
					overflow: 'justify'
				}
			},
			tooltip: {
				valueSuffix: ' '
			},
			plotOptions: {
				bar: {
					dataLabels: {
						enabled: true
					}
				}
			},
			legend: {
				enabled: false,
				layout: 'vertical',
				align: 'right',
				verticalAlign: 'top',
				x: -40,
				y: 100,
				floating: true,
				borderWidth: 1,
				backgroundColor: '#FFFFFF',
				shadow: true
			},
			credits: {
				enabled: false
			},
			series: [{
			    showInLegend: false,
				name: '',
			    //data: chart.Data[0].Data
				data: getModifiedSeriesData(chart)
			}]
		});
	}


	function renderPieChart(elem, chart,clickfunction) {
		var pieData = getPieFormattedData(chart);

		$(elem).highcharts({
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				height: chartHeight
			},
			colors: customColors,
			title: {
				text: ''
			},
			tooltip: {
				  formatter: function() {
	                    var s;
	                    if (this.point.name) { // the pie chart
	                        s = ''+
	                            this.point.name +': '+ this.y +'';
	                    } else {
	                        s = ''+
	                            this.x  +': '+ this.y;
	                    }
	                    return s;
				  }
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: true,
						color: '#000000',
					//	color: '#FFFFFF',
						connectorColor: '#000000',
						format: '<b>{point.name}</b>: {point.percentage:.1f} %'
					},
					point: {
                        events: {
                            click: clickfunction
                        }
                    }
				}
			},
			series: [{
				type: 'pie',
				name: '',
				data: pieData
			}]
		});
	}


	function renderAreaChart(elem, chart) {
		 $(elem).highcharts({
            chart: {
                type: 'area',
                height: chartHeight
            },
			colors: customColors,
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                labels: {
                    formatter: function() {
                        return this.value; // clean, unformatted number for year
                    }
                }
            },
            yAxis: {
                title: {
                    text: ''
                }
				// ,
                // labels: {
                    // formatter: function() {
                        // return this.value / 1000 +'k';
                    // }
                // }
            },
            tooltip: {
                pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
            },
            plotOptions: {
                area: {
                    pointStart: 1940,
                    marker: {
                        enabled: false,
                        symbol: 'circle',
                        radius: 2,
                        states: {
                            hover: {
                                enabled: true
                            }
                        }
                    }
                }
            },
            series: [{
                showInLegend: false,
                name: chart.Data[0].SeriesName,
                data: chart.Data[0].Data
            }
			// , {
                // name: 'USSR/Russia',
                // data: [null, null, null, null, null, null, null , null , null ,null,
                // 5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322,
                // 4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478,
                // 15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049,
                // 33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000,
                // 35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
                // 21000, 20000, 19000, 18000, 18000, 17000, 16000]
            // }
			]
        });
	}


	function renderLineChart(elem, chart) {
		$(elem).highcharts({
			chart: {
				zoomType: 'x',
				spacingRight: 20,
				reflow: true,
				height: chartHeight
			},
			title: {
				text: ''
			},
			subtitle: {
				//text: document.ontouchstart === undefined ?
				//    'Click and drag in the plot area to zoom in' :
				//    'Pinch the chart to zoom in'
			},
			xAxis: {
				type: 'datetime',
				maxZoom: 14 * 24 * 3600000, // fourteen days
				title: {
					text: null
				}
			},
			colors: customColors,
			yAxis: {
				title: {
					text: ''
				}
			},
			tooltip: {
				shared: true
			},
			legend: {
				enabled: false
			},
			plotOptions: {
				area: {
					fillColor: {
						linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
						stops: [
							[0, Highcharts.getOptions().colors[0]],
							[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
						]
					},
					lineWidth: 1,
					marker: {
						enabled: false
					},
					shadow: false,
					states: {
						hover: {
							lineWidth: 1
						}
					},
					threshold: null
				}
			},

			series: [{
			    showInLegend: false,
				type: 'line',
				pointInterval: 24 * 3600 * 1000,
				pointStart: Date.UTC(2013, 0, 01),
				data: chart.Data[0].Data
			}
			// ,
					// {
						// type: 'line',
						// pointInterval: 24 * 3600 * 1000,
						// pointStart: Date.UTC(2013, 0, 01),
						// data: data.data2
					// }
			]
		});
	}

	function getPieFormattedData(chart) {
		var pieData = [];
		for (var i = 0 ; i < chart.Data[0].Data.length ; i++) {
			if (i == 1) {
				pieData.push({name: chart.Categories[i], y: chart.Data[0].Data[i], sliced: true, selected: true});
			}
			else
			{
				pieData.push([chart.Categories[i], chart.Data[0].Data[i]]);
			}
		}

		return pieData;
	}

	function getModifiedSeriesData(chart) {
	    var seriesData = [];
	    for (var i = 0 ; i < chart.Categories.length ; i++) {
	        seriesData.push({ color: customColors[i], y: chart.Data[0].Data[i] });
	    }

	    return seriesData;
	}

	window.HighChartHelper = {
		renderChart: renderChart
	}

})(window.HighChartHelper = window.HighChartHelper || {});