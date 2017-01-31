	$(function () {
        $("#dialog").hide();

    var dbserver = "10.0.0.2:8080";
    getProjectnames();
	getdispname(dispname);
	var daterange;
//	getdateranges();

	var projectid = 1;
	
	var selectedtab = 1;
	var data_bld;
	var utbldwise;
	var p;
	var trendType = "week";
	var dispname;

	var moveLeft = -105;
    var moveDown = 30;

    function getdateranges()
    {
    	 $.ajax({
	          dataType: "json",

	          url: "http://" + dbserver + "/ContinuousIntegration/dashboard/daterange",
	          data: null,
	          cache: false,
	          async:false,
	          success: function (data) {
	             // HighChartHelper.renderChart('#utAggregateChart',2,data,null);
	        	  daterange = data;
	          },
	          error: function (a, err, c) {
	              alert(err);
	          }
	      });
    }


    function getbuildwiseut(e,projectid)
    {
            $.ajax({
            dataType: "json",
            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/ut/" + $(e.target).data('buildnumber'),
            data: null,
            cache: false,
            async:false,
            success: function (data) {

                HighChartHelper.renderChart('#aggregatechartut',2,data,clickfunction);
                $("#utAggregateChart").find(".nodata").hide();
                $("#aggregatechartut").show();

            },
            error: function (a, err, c) {

               // alert(err);
            	$("#aggregatechartut").hide();
            	$("#utAggregateChart").find(".nodata").show();
            }
        });
    }

    function getbuildwisecc(e,projectid)
    {
    	  $.ajax({
              dataType: "json",

              url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/cc/" + $(e.target).data('buildnumber'),
              data: null,
              cache: false,
              async:false,
              success: function (data) {
                  HighChartHelper.renderChart('#aggregatechartcc',2,data,clickfunction);
                  $("#ccAggregateChart").find(".nodata").hide();
                  $("#aggregatechartcc").show();

              },
              error: function (a, err, c) {
               //   alert(err);
              	$("#aggregatechartcc").hide();
              	$("#ccAggregateChart").find(".nodata").show();
              }
          });

    }


    function getbuildwisefb(e,projectid)
    {
    	 $.ajax({
             dataType: "json",

             url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/fb/" + $(e.target).data('buildnumber'),
             data: null,
             cache: false,
             async:false,
             success: function (data) {
                 HighChartHelper.renderChart('#AggregateChartfb',2,data,clickfunction);

                 $("#fbAggregateChart").find(".nodata").hide();
                 $("#AggregateChartfb").show();

             },
             error: function (a, err, c) {
                // alert(err);
             	$("#AggregateChartfb").hide();
             	$("#fbAggregateChart").find(".nodata").show();

             }
         });

    }

    function getbuildwisepm(e,projectid)
    {
    	$.ajax({
            dataType: "json",
            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/pm/" + $(e.target).data('buildnumber'),
            data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#AggregateChartpm',2,data,clickfunction);
                $("#pmAggregateChart").find(".nodata").hide();
                $("#AggregateChartpm").show();
            },
            error: function (a, err, c) {
              //  alert(err);
            	$("#AggregateChartpm").hide();
            	$("#pmAggregateChart").find(".nodata").show();
            }
        });

    }

    function getbuildwisebat(e,projectid)
    {
    	$.ajax({
            dataType: "json",
            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/bat/" + $(e.target).data('buildnumber'),
            data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#AggregateChartbat',2,data,clickfunction);
                $("#btAggregateChart").find(".nodata").hide();
                $("#AggregateChartbat").show();
            },
            error: function (a, err, c) {
              //  alert(err);
            	$("#AggregateChartbat").hide();
            	$("#btAggregateChart").find(".nodata").show();
            }
        });

    }

    function getdispname(dispname){

    	  var strn = '</span><span class="pull-left pageSubTitle inlineBlock">"' + dispname + '"</span>';

          $("#disname").html(strn);

    }

    getLatestNightlyBuilds(projectid);
    getid(data_bld);

            function getdetails(e,data_bld)
            {


                    for (p = 0; p < data_bld.length; p++)
                    	{

                    if ($(e.target).data('buildnumber') == data_bld[p].buildnumber)
                    	{
			getbldartifacts(p,data_bld);
                    	}
                   	}
            }

	function getbldartifacts(p,data_bld)
	{
		 $("#BldResult").text(data_bld[p].result);
                 $("#BldNumber").text(data_bld[p].buildnumber);
                 $("#loc").text(data_bld[p].loc);
                 $("#Blddatetime").text(data_bld[p].datetime);
		 $("#Bldreviewidcnt").text(data_bld[p].reviewidcount);
                 if(data_bld[p].result != "SUCCESS"){
                                        $("#BldReason").show();
                        $("#BldReason").text(data_bld[p].reason);
                                }else{

					$("#BldReason").hide();
					$(".reason").hide();
                                }


	}

	$(".showPopup").on("click",function(a){
//		alert ("clicked " + $(a.target).data('id'));
	});

       showpop(data_bld,projectid);

	function showpop(data_bld)
	{
		$('.showPopup').on('mouseover',function(e) {
		  getdetails(e,data_bld);
		  $('div#pop-up').show()
			.css('top', e.pageY + moveDown)
			.css('left', e.pageX + moveLeft)
			.appendTo('body');
		});
		$('.showPopup').on('mouseout', function() {
			$('div#pop-up').hide();
		});

		$(".showPopup").on("click",function(e){
			getbuildwiseut(e,projectid);
			getbuildwisecc(e,projectid);
			getbuildwisefb(e,projectid);
			getbuildwisepm(e,projectid);
			getbuildwisebat(e,projectid);
			
			$('.showPopup').removeClass("selected");
            $(this).toggleClass("selected");

			

        });
	}

	 var selectElement = document.getElementById("product_list");
     selectElement.onchange=function(){

        // alert(selectElement.selectedIndex);
       //  alert(selectElement.value);
         projectid = selectElement.value;
	 dispname = $('#product_list :selected').text();
         getdispname(dispname);
         getLatestNightlyBuilds(projectid);
         getnextmdlbuilds(data_bld);
         showpop(data_bld);

         if (selectedtab == 1)
        	 {
        	 getLatestNightlyBuilds(projectid);
        	 displayUTAggregateChart(projectid);
             displayCCAggregateChart(projectid);
             displayFBAggregateChart(projectid);
             displayPMDAggregateChart(projectid);
             displayBATAggregateChart(projectid);

        	 }
         else if (selectedtab == 2)
        	 {
          displayUTAggregateChartci(projectid);
   		  displayCCAggregateModulewiseChart(projectid);
   		  displayFBAggregateModulewiseChart(projectid);
   		  displayPMDAggregateModulewiseChart(projectid);
   		  displayLocModulewiseChart(projectid);
   		  displayCodeComplexModulewiseChart(projectid);
        	 }

         else if (selectedtab == 3)
    	 {
        	if (selectedtab == 4 || selectedtab == 5 )
        		{
        		 renderTrendData(trendType,projectid);
        		}
        	/*if (selectedtab == 6)
        		{
        		renderCustomTrendData(trendType,objfrom,objto,projectid);
        		}*/

    	 }


     };

	function getnextmdlbuilds(data_bld)
	{
		debugger;
		$("#ULID").empty();
		var i = 0;
		var color;
		var str;
		/*if(data_bld[i].result = "SUCCESS"){
			color = "green";
			}
		else if(data_bld[i].result = "FAILURE"){
			color = "red";
			}
		else if(data_bld[i].result = "UNSTABLE"){
			color = "orange";
			}
			else
				{
				
				}*/
	//	var str = '<li class="bldid"><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
	//	$("#ULID").append(str);
		for (i = 0; i < data_bld.length; i++) {
			if(data_bld[i].result == "SUCCESS"){
				color = "green";
				}
			
			else if(data_bld[i].result == "FAILURE"){
				color = "red";
				}
			else if(data_bld[i].result == "UNSTABLE"){
				color = "orange";
				}
				else
					{
					
					}
			
			if (i == 0)
			{
				str = '<li class="bldid"><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
				$("#ULID").append(str);
				
			}
			else
				{
				str = '<li><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
				$("#ULID").append(str);
				}
        

		}
	}
	$(".cibuildtab").on("click",function(){


		var delay=10;//1 seconds
		projectid = selectElement.value;
		selectedtab = 2;
		setTimeout(function(){
		  displayUTAggregateChartci(projectid);
		  displayCCAggregateModulewiseChart(projectid);
		  displayFBAggregateModulewiseChart(projectid);
		  displayPMDAggregateModulewiseChart(projectid);
		  displayLocModulewiseChart(projectid);
		  displayCodeComplexModulewiseChart(projectid);


		},delay);
        //alert("Hello");
});


	$(".nightlybuildtab").on("click",function(){


		var delay=10;//1 seconds
		projectid = selectElement.value;
		selectedtab = 1;
		setTimeout(function(){
			displayUTAggregateChart(projectid);
            displayCCAggregateChart(projectid);
            displayFBAggregateChart(projectid);
            displayPMDAggregateChart(projectid);

		},delay);
        //alert("Hello");
});

	function addSelect(divname,data) {

	    var newDiv=document.createElement('div');
	    var html = '<select id = "product_list">', i;
	    for(i = 0; i < data.length; i++) {
	        html += "<option value='"+data[i].id+"'>"+data[i].dn+"</option>";
	        dispname = data[0].dn;
	     }
	    html += '</select>';
	    newDiv.innerHTML= html;
	    document.getElementById(divname).appendChild(newDiv);
	}

	function getid(data_bld) {

		var i = 0;
		var s = 0;
		var color;
		var str;
	/*	if(data_bld[i].result != "SUCCESS"){
		color = "red";
		}
		else
			{
			color = "green";
			}*/
	//	var str = '<li class="bldid"><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
		//$("#ULID").append(str);
		debugger;
		for (i = 0; i < data_bld.length; i++) {
			if(data_bld[i].result == "SUCCESS"){
				color = "green";
				}
			
			else if(data_bld[i].result == "FAILURE"){
				color = "red";
				}
			else if(data_bld[i].result == "UNSTABLE"){
				color = "orange";
				}
				else
					{
					
					}
		
		if (i == 0)
		{
			str = '<li class="bldid"><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
			$("#ULID").append(str);
			
		}
		else
			{
			str = '<li><a href="#" target="_self" class="successText showPopup" style="color:'+color+'" id="trigger" data-buildnumber="'+ data_bld[i].buildnumber +'">'+ data_bld[i].buildnumber +'</a></li>';
			$("#ULID").append(str);
			}
		}
	}

	function blinker() {
        $('.bldid').fadeOut(500);
        $('.bldid').fadeIn(500);
}

        setInterval(blinker, 1000); //Runs every second

	function getProjectnames(){
		
		  $.ajax({
	          dataType: "json",
	          
	          url: "http://" + dbserver + "/ContinuousIntegration/dashboard/projects",
	          data: null,
	          cache: false,
	          async:false,
	          success: function (data) {
	             // HighChartHelper.renderChart('#utAggregateChart',2,data,null);
	        	  addSelect("select-container",data);
	          },
	          error: function (a, err, c) {
	              alert(err);
	          }
	      });
	}

	function getLatestNightlyBuilds(projectid){
		  $.ajax({
	          dataType: "json",

	          url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/latestnightlybuilds",
	          data: null,
	          cache: false,
	          async:false,
	          success: function (data) {
			data_bld = data;
	             // HighChartHelper.renderChart('#utAggregateChart',2,data,null);
	     //   	  getid(data);
	          },
	          error: function (a, err, c) {
	              alert(err);
	          }
	      });
	}


	    var objto = null;
        var objfrom = null;
	$("#Button1").on("click",function(){
		//alert("go button clicked");

	debugger;
	objfrom = g_calendarObjectfrom.getSelectedDay();

       // alert("a date was just selected and the date is : " + objfrom.day + "/" + objfrom.month + "/" + objfrom.year);

       	objto = g_calendarObjectto.getSelectedDay();

       // alert("a date was just selected and the date is : " + objto.day + "/" + objto.month + "/" + objto.year);

//	$("#frmdate").empty();
  //      $("#todate").empty();

       dispdatecustom(objfrom,objto);
        trendType = "custom";

		renderCustomTrendData(trendType,objfrom,objto,projectid);
	//	toggleTrendButtonSelection("Button1");
	});



	$(".trendbuildtab").on("click",function(){
		selectedtab = 3;
		$("#daterange").hide();
		getdateranges();
	//	alert(daterange.week.start);
        //	$("#frmdate").empty();
	//	$("#todate").empty();
		dispdate(daterange);
		trendType="week";
		renderTrendData(trendType,projectid);
		toggleTrendButtonSelection("weektrend");
	});

	$("#customtrend").on("click",function(){
		debugger;

		$("#daterange").show();
		$(".container").foggy();
		$( "#dialog" ).dialog({
  		dialogClass: "no-close",
		modal: true,
  		buttons: [
    			{
    			  text: "OK",
     				 click: function() {
        			$( this ).dialog( "close" );
				$(".container").foggy(false);
		//		blinkergo();

      					}
    				}
  			]
		});
		selectedtab = 6;
		trendType = "custom";
	//	renderCustomTrendData(trendType,objfrom,objto,projectid);

		toggleTrendButtonSelection("customtrend");
	});

	$("#weektrend").on("click",function(){
		trendType = "week";
		selectedtab = 4;
		$("#daterange").hide();
	//	alert(daterange.week.start);
		getdateranges();
	//	alert(daterange.week.start);
//		$("#frmdate").empty();
//		$("#todate").empty();
		dispdate(daterange);
		renderTrendData(trendType,projectid,daterange);
		toggleTrendButtonSelection("weektrend");
	});

	$("#monthtrend").on("click",function(){
		selectedtab = 5;
		trendType = "month";
		$("#daterange").hide();
		$("#frmdate").show();
		$("#todate").show();
	//	alert(daterange.week.start);
                getdateranges();
        //      alert(daterange.month.start);
            //  $("#frmdate").empty();
           //   $("#todate").empty();
                dispdate(daterange);

		renderTrendData(trendType,projectid);
		toggleTrendButtonSelection("monthtrend");
	});

	/*$("#Button1").on("click",function(){
		trendType = "custom";

		renderCustomTrendData(trendType,projectid);
		toggleTrendButtonSelection("Button1");
	});*/


	function dispdate(daterange)
	{
	if (selectedtab == 4 || selectedtab == 3)
	{
//	$("#frmdate")[0].children[0].html(daterange.week.start);
        $("#frmdate").children(0).text("'" + daterange.week.start + "'");
	$("#todate").children(0).text("'" + daterange.week.end + "'");
	}

	if (selectedtab == 5)
        {
        $("#frmdate").children(0).text("'" + daterange.month.start + "'");
        $("#todate").children(0).text("'" + daterange.month.end + "'");
	}

	}

	function dispdatecustom(objfrom,objto)
        {
	$("#frmdate").children(0).text("'" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year +  "'");
	$("#todate").children(0).text("'" + objto.day + "/" + objto.month + "/" + objto.year +  "'");

        }

	function toggleTrendButtonSelection(selectBtnId){
		$(".trendbtn").removeClass("btn-primary");
		$("#" + selectBtnId).addClass("btn-primary");
	}

    function renderTrendData(trendType,projectid){
    	var delay=10;//1 seconds
		setTimeout(function(){
			displayUttrendData(trendType,projectid);
			displayCctrendData(trendType,projectid);
			displayFbtrendData(trendType,projectid);
			displayPmtrendData(trendType,projectid);
			displayCodeCollabtrendData(trendType,projectid);
			displayLoctrendData(trendType,projectid);
			displayBattrendData(trendType,projectid);
			displayRegtrendData(trendType,projectid);
			displayRegcoveragetrendData(trendType,projectid);




		},delay);
    }

    function renderCustomTrendData(trendType,objfrom,objto,projectid){
    	var delay=10;//1 seconds
		setTimeout(function(){
			displayCustomUttrendData(trendType,objfrom,objto,projectid);
			displayCustomCctrendData(trendType,objfrom,objto,projectid);
			displayCustomFbtrendData(trendType,objfrom,objto,projectid);
			displayCustomPmtrendData(trendType,objfrom,objto,projectid);
			displayCustomLoctrendData(trendType,objfrom,objto,projectid);
			displayCustomCodeCollabtrendData(trendType,objfrom,objto,projectid);
			displayCustomBattrendData(trendType,objfrom,objto,projectid);
			displayCustomRegtrendData(trendType,objfrom,objto,projectid);
			

		},delay);
    }

	function maximize(element) {
        var parentDiv;
        $(".moveable").hide();
        element.closest('.moveable').show();
        parentDiv = element.closest(".outercontainer");
        CreateDynamicCSS(parentDiv.offset().top, parentDiv.offset().left, parentDiv.width() - 100, $(window).height() - parentDiv.offset().top);

        maxWidth = parentDiv.width() - 100;
        maxHeight = $(window).height() - parentDiv.offset().top -180;

        currentSpan = element.closest('.moveable').attr("class");
        height = element.closest('.moveable').height();
        element.closest('.moveable').height($(window).height() - parentDiv.offset().top - 100);
        currWidth = element.closest('.moveable').find('.c').width();
        element.closest('.moveable').removeClass("span8").removeClass("span4");
        //element.closest('.moveable').addClass('MaximizedChart');
        element.closest('.moveable').find('.c').addClass('MaximizedChartContent');

    };

    function CreateDynamicCSS(top, left, width, height) {
        var maxContent, style;
        style = "<style id=StyleMax>.MaximizedChart { top:" + top + "px;left:" + left + "px;height:" + (height - 100) + "px; }</style>";
        $('html > head').append(style);
        maxContent = "<style id=StyleMaxContent>.MaximizedChartContent { top:0px;left:0px;height:" + (height - 100) + "px;}</style>";
        return $('html > head').append(maxContent);
    };

    function Minimize(element) {
        $(".moveable").show();
        element.closest('.moveable').find('.c').removeClass('MaximizedChartContent');
        element.closest('.moveable').removeClass('MaximizedChart');
        element.closest('.moveable').addClass(currentSpan);
        $('#StyleMax').remove();
        $('#StyleMaxContent').remove();
       element.closest('.moveable').height(height);

    };

    $(".fa-expand").on("click", function (e) {
        $(e.target).closest('.chartcontrols').find('.min').show();
        $(e.target).closest('.chartcontrols').find('.max').hide();
        maximized = true;
        maximize($(e.target));
        var chartinstance = $("#chart" + $(e.target).data().id).highcharts();
        chartinstance.setSize(maxWidth, maxHeight);
    });

    $(".min").on("click", function (e) {
        $(e.target).closest('.chartcontrols').find('.min').hide();
        $(e.target).closest('.chartcontrols').find('.max').show();
        maximized = false;
        Minimize($(e.target));
        var chartinstance = $("#chart" + $(e.target).data().id).highcharts();
        chartinstance.setSize(currWidth, minimizedHeight);
    });


displayCCAggregateChart(projectid);

function clickfunction(){
	  $.ajax({
          dataType: "json",

          url: "http://" + dbserver + "/ContinuousIntegration/dashboard/1/ut/aggregate?build=latest&buildtype=nightly",
                      data: null,
          cache: false,
          async:false,
          success: function (data) {
              HighChartHelper.renderChart('#utAggregateChart',2,data,null);
          },
          error: function (a, err, c) {
             // alert(err);
        	  $("#utAggregateChart").find(".nodata").show();
          }
      });

	//alert("clicked");
}



function displayCCAggregateChart (projectid) {

  $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/cc/aggregate?build=latest&buildtype=nightly",
                        data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#aggregatechartcc',2,data,clickfunction);
                $("#ccAggregateChart").find(".nodata").hide();
                $("#aggregatechartcc").show();

            },
            error: function (a, err, c) {
             //   alert(err);
            	$("#aggregatechartcc").hide();
            	$("#ccAggregateChart").find(".nodata").show();
            }
        });
        }

displayUTAggregateChart(projectid);
        function displayUTAggregateChart(projectid){

        $.ajax({

            dataType: "json",
            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/ut/aggregate?build=latest&buildtype=nightly",
            data: null,
            cache: false,
            async:false,
            success: function (data) {

                HighChartHelper.renderChart('#aggregatechartut',2,data,clickfunction);
                $("#utAggregateChart").find(".nodata").hide();
                $("#aggregatechartut").show();

            },
            error: function (a, err, c) {

               // alert(err);
            	$("#aggregatechartut").hide();
            	$("#utAggregateChart").find(".nodata").show();
            }
        });
        }

        displayFBAggregateChart(projectid);
        function displayFBAggregateChart(projectid){

                $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/fb/aggregate?build=latest&buildtype=nightly",
                        data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#AggregateChartfb',2,data,clickfunction);

                $("#fbAggregateChart").find(".nodata").hide();
                $("#AggregateChartfb").show();

            },
            error: function (a, err, c) {
               // alert(err);
            	$("#AggregateChartfb").hide();
            	$("#fbAggregateChart").find(".nodata").show();

            }
        });
        }


        displayPMDAggregateChart(projectid);
        function displayPMDAggregateChart(projectid){

                $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/pm/aggregate?build=latest&buildtype=nightly",
                        data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#AggregateChartpm',2,data,clickfunction);
                $("#pmAggregateChart").find(".nodata").hide();
                $("#AggregateChartpm").show();

            },
            error: function (a, err, c) {
              //  alert(err);
            	$("#AggregateChartpm").hide();
            	$("#pmAggregateChart").find(".nodata").show();
            }
        });
        }


        function displayLocModulewiseChart(projectid) {
        	var minimizedHeight = 350;
        	$.ajax({
				dataType: "json",
				url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/loc/modulewise?build=latest&buildtype=ci",
				data: null,
				cache: false,
				async:false,
				success: function (data) {
					showReport('#chartLocModuleWise', data);
					$('#chartLocModuleWise').highcharts({
						chart: {
							height: minimizedHeight
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
							//type: 'datetime',
							//maxZoom: 14 * 24 * 3600000, // fourteen days
							categories: data.categories,
							//title: {
							//    text: null
							//}
						},
						colors: ['#c9763f','#60c7c8','#669933'],
						legend: {
							enabled : false
						},
						yAxis: {
							title: {
								text: ''
							}
						},
						credits: {
							enabled: false
						},
						plotOptions: {
							column: {
								pointPadding: 0,
								borderWidth: 0
							}
						},
						legend:{
							enabled : true
						},
						series: [{
							type: 'column',
							name: "All modules Lines of code",
							data: data.data
						}]
					});
				},
				error: function (a, err, c) {
					alert(err);
				}
	        });
        }

        function displayCodeComplexModulewiseChart(projectid) {

        	var minimizedHeight = 350;
        	$.ajax({
				dataType: "json",
				url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/complex/modulewise?build=latest&buildtype=ci",
				data: null,
				cache: false,
				async:false,
				success: function (data) {

					showReport('#chartCodeComplexityModuleWise', data);
					$('#chartCodeComplexityModuleWise').highcharts({
						chart: {
							height: minimizedHeight
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
							//type: 'datetime',
							//maxZoom: 14 * 24 * 3600000, // fourteen days
							categories: data.Categories,
							//title: {
							//    text: null
							//}
						},
						colors: ['#5fa3d3','#60c7c8','#669933'],
						legend: {
							enabled : false
						},
						yAxis: {
							title: {
								text: ''
							}
						},
						credits: {
							enabled: false
						},
						plotOptions: {
							column: {
								pointPadding: 0,
								borderWidth: 0
							}
						},
						legend:{
							enabled : true
						},
						series: [{
							type: 'column',
							name: "Module wise Code Complexity",
							data: data.Data
						}]
					});
				},
				error: function (a, err, c) {
					alert(err);
				}
	        });
        }

        function displayPMDAggregateModulewiseChart(projectid) {
        	var minimizedHeight = 350;

        	$.ajax({
    			dataType: "json",
    			url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/pm/modulewise?build=latest&buildtype=ci",
    			data: null,
    			async:true,
    			cache: false,
    			success: function (data) {
    				showReport('#chartPMDModuleWise', data);
    				$('#chartPMDModuleWise').highcharts({
    					chart: {
    						type: 'column',
    						height: minimizedHeight,
    						//width:370
    					},
    					colors: ['#c9763f','#60c7c8','#669933'],
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

        function displayFBAggregateModulewiseChart (projectid) {
        	var minimizedHeight = 350;
        	$.ajax({
				dataType: "json",
				  url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/fb/modulewise?build=latest&buildtype=ci",
				data: null,
				async:true,
				cache: false,
				success: function (data) {
					showReport('#chartFingbugModuleWise', data);
					$('#chartFingbugModuleWise').highcharts({
						chart: {
							type: 'column',
							height: minimizedHeight,
							//width:370
						},
						colors: ['#c9763f','#60c7c8','#669933'],
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


        function displayCCAggregateModulewiseChart(projectid){
        	var minimizedHeight = 350;

        	$.ajax({
    			dataType: "json",
    			url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/cc/modulewise?build=latest&buildtype=ci",
    			data: null,
    			cache: false,
    			async:false,
    			success: function (data) {
    				showReport('#ccAggregateChartci', data);
    				$('#ccAggregateChartci').highcharts({
    					chart: {
    						height: minimizedHeight
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
    						//type: 'datetime',
    						//maxZoom: 14 * 24 * 3600000, // fourteen days
    						categories: data.categories,
    						//title: {
    						//    text: null
    						//}
    					},
    					colors: ['#5fa3d3','#60c7c8','#669933'],
    					legend: {
    						enabled : false
    					},
    					yAxis: {
    						min: 0,
    						title: {
    							text: ''
    						}
    					},
    					credits: {
    						enabled: false
    					},
    					plotOptions: {
    						column: {
    							pointPadding: 0,
    							borderWidth: 0
    						}
    					},
    					legend:{
    						enabled : true
    					},
    					series: [{
    						type: 'column',
    						name: "All modules aggregated code coverage",
    						data: data.data
    					}]
    				});
    			},
    			error: function (a, err, c) {
    				alert(err);
    			}
            });
        }

        displayBATAggregateChart(projectid);
        function displayBATAggregateChart(projectid){

                $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/bat/aggregate?build=latest&buildtype=nightly",
            data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#AggregateChartbat',2,data,clickfunction);
                $("#btAggregateChart").find(".nodata").hide();
                $("#AggregateChartbat").show();
            },
            error: function (a, err, c) {
                //alert(err);
            	$("#AggregateChartbat").hide();
            	$("#btAggregateChart").find(".nodata").show();
            }
        });
        }


        //displayUtweektrend();
        function displayCustomUttrendData(trendType,objfrom,objto,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/ut/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    				showReport('#chartweekUttrend', data);
    				$('#chartweekUttrend').highcharts({

                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Unit Tests'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});

                },
        	});


        }

function displayCustomCctrendData(trendType,objfrom,objto,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/cc/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
                data: null,
                cache: false,
                async:false,

                success: function (data) {


    				showReport('#chartweekCctrend', data);
    				$('#chartweekCctrend').highcharts({

                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Code Coverage'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});
                },

        	});


        }

function displayCustomFbtrendData(trendType,objfrom,objto,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/fb/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {


			showReport('#chartweekFbtrend', data);
			$('#chartweekFbtrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'FindBug issues'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        },

	});

}

function displayCustomPmtrendData(trendType,objfrom,objto,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/pm/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {




			showReport('#chartweekPmtrend', data);
			$('#chartweekPmtrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'PMD issues'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        },

	});


}

function displayCustomLoctrendData(trendType,objfrom,objto,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/loc/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {


			showReport('#chartweekLoctrend', data);
			$('#chartweekLoctrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Loc'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        },

	});


}


function displayCustomCodeCollabtrendData(trendType,objfrom,objto,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/codecollab/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {



			showReport('#chartweekCodeCollabtrend', data);
		/*	$('#chartweekCodeCollabtrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Reviews'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			}); */
			
			$('#chartweekCodeCollabtrend').highcharts({
				title: {
			                    text: '',
			                    x: -20 //center
			                },
			                subtitle: {
			                    text: '',
			                    x: -20
			                },
			        xAxis: [{
			            categories: data.Categories,
				     title: {
			                        text: 'Build Number'
			                    },
			        }],
			        yAxis: [{ // Primary yAxis
			            gridLineWidth: 0,
			            title: {
			                text: 'Total Reviews',
			                style: {
			                    color: Highcharts.getOptions().colors[0]
			                }
			            },
			            labels: {
			                format: '{value}',
			                style: {
			                    color: Highcharts.getOptions().colors[0]
			                }
			            }

			        }, { // Secondary yAxis
			            gridLineWidth: 0,
			            title: {
			                text: 'Total Time (min)',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            },
			            labels: {
			                format: '{value} min',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            },
			            opposite: true
			        },  { // Tirtiary yAxis
			            gridLineWidth: 0,
			            title: {
			                text: 'Total Bugs/Conversations',
			                style: {
			                    color: Highcharts.getOptions().colors[2]
			                }
			            },
			            labels: {
			                format: '{value}',
			                style: {
			                    color: Highcharts.getOptions().colors[2]
			                }
			            },
			            opposite: true
				}],
			        tooltip: {
			            shared: true
			        },
			        legend: {
			            layout: 'vertical',
			            align: 'left',
			            x: 120,
			            verticalAlign: 'top',
			            y: 80,
			            floating: true,
			            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
			        },
			        series: data.Data,
			    });

        },

	});


}

function displayCustomRegtrendData(trendType,objfrom,objto,projectid) {
	
	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/reg/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {
			showReport('#chartweekregtrend', data);
			$('#chartweekregtrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Regression Tests'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        },

	});

	
}

function displayCustomBattrendData(trendType,objfrom,objto,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/bat/" + trendType + "?" + "fromdate=" + objfrom.day + "/" + objfrom.month + "/" + objfrom.year + "&" + "todate=" + objto.day + "/" + objto.month + "/" + objto.year,
        data: null,
        cache: false,
        async:false,

        success: function (data) {



			showReport('#chartweekbattrend', data);
			$('#chartweekbattrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'BAT Tests'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        },

	});


}


        function displayUttrendData(trendType,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/ut/" + trendType,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    				showReport('#chartweekUttrend', data);
    				$('#chartweekUttrend').highcharts({

                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Unit Tests'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});
                }
        	});

          }


        //displayFbweektrend();
        function displayFbtrendData(trendType,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/fb/" + trendType,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    				showReport('#chartweekFbtrend', data);
    				$('#chartweekFbtrend').highcharts({



                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Issues'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});
                }
        	});

          }


        //displayPmweektrend();
        function displayPmtrendData(trendType,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/pm/" + trendType,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    				showReport('#chartweekPmtrend', data);
    				$('#chartweekPmtrend').highcharts({



                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Issues'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});
                }
        	});

          }


function displayCodeCollabtrendData(trendType,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/codecollab/" + trendType,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    		showReport('#chartweekCodeCollabtrend', data);
    		/*$('#chartweekCodeCollabtrend').highcharts({



                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: [{ // primary yaxis
                    title: {
                        text: 'Reviews'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                    
                },
                { // secondary yaxis
                	title: {
                        text: 'Total Time Spent(min)'
                    },
                    labels: {
                        format: '{value}�C',
                    },
                	
                	opposite: true
                }],
                tooltip: {
                    valueSuffix: '',
                    shared: true
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});*/
		$('#chartweekCodeCollabtrend').highcharts({
	title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
        xAxis: [{
            categories: data.Categories,
	     title: {
                        text: 'Build Number'
                    },
        }],
        yAxis: [{ // Primary yAxis
            gridLineWidth: 0,
            title: {
                text: 'Total Reviews',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            }

        }, { // Secondary yAxis
            gridLineWidth: 0,
            title: {
                text: 'Total Time (min)',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            labels: {
                format: '{value} min',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            opposite: true
        },  { // Tirtiary yAxis
            gridLineWidth: 0,
            title: {
                text: 'Total Bugs/Conversations',
                style: {
                    color: Highcharts.getOptions().colors[2]
                }
            },
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[2]
                }
            },
            opposite: true
	}],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 80,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        series: data.Data,
    });
                }
        	});

          }

function displayLoctrendData(trendType,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/loc/" + trendType,
        data: null,
        cache: false,
        async:false,

        success: function (data) {

			showReport('#chartweekLoctrend', data);
			$('#chartweekLoctrend').highcharts({



        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Loc'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        }
	});

  }

function displayBattrendData(trendType,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/bat/" + trendType,
        data: null,
        cache: false,
        async:false,

        success: function (data) {

			showReport('#chartweekbattrend', data);
			$('#chartweekbattrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'BAT Tests'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        }
	});

  }


function displayRegtrendData(trendType,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/reg/" + trendType,
        data: null,
        cache: false,
        async:false,

        success: function (data) {

			showReport('#chartweekregtrend', data);
			$('#chartweekregtrend').highcharts({

        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Regression Tests'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        }
	});

  }

//displayCcweektrend();

function displayRegcoveragetrendData(trendType,projectid) {

	$.ajax({

		dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/regcc/" + trendType,
        data: null,
        cache: false,
        async:false,

        success: function (data) {

			showReport('#chartweekqacctrend', data);
			$('#chartweekqacctrend').highcharts({



        title: {
            text: '',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: data.Categories,
            title: {
                text: 'Build Number'
            },
        },
        yAxis: {
            title: {
                text: 'Regression Code Coverage (%)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: data.Data,
			});
        }
	});

  }

        function displayCctrendData(trendType,projectid) {

        	$.ajax({

        		dataType: "json",

                url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/cc/" + trendType,
                data: null,
                cache: false,
                async:false,

                success: function (data) {

    				showReport('#chartweekCctrend', data);
    				$('#chartweekCctrend').highcharts({



                title: {
                    text: '',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: data.Categories,
                    title: {
                        text: 'Build Number'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Code Coverage (%)'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ''
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: data.Data,
    				});
                }
        	});

          }

        	displayBATCcAggregateChart();
        function displayBATCcAggregateChart(){

                $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/1/batcc/aggregate?build=latest&buildtype=nightly",
            data: null,
            cache: false,
            async:false,
            success: function (data) {
                HighChartHelper.renderChart('#btcAggregateChart',2,data,clickfunction);
            },
            error: function (a, err, c) {
              //  alert(err);
                $("#btcAggregateChart").find(".nodata").show();
            }
        });
        }


        function displayUTAggregateChartci(projectid){
        	var minimizedHeight = 350;
 $.ajax({
                        dataType: "json",
                        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/" + projectid + "/ut/modulewise?build=latest&buildtype=ci",
                        data: null,
                        async:true,
                        cache: false,
                        success: function (data) {
                                showReport('#utAggregateChartci', data);
                                $('#utAggregateChartci').highcharts({
                                        chart: {
                                                type: 'column',
                                                height: minimizedHeight,
                                                //width:370
                                        },
                                        colors: ['#c9763f','#60c7c8','#669933'],
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

        function showReport(chartselector, data) {
            if (undefined != data.report) {
                $(chartselector).parent().find('.reportlink').attr('href', data.report);
                $(chartselector).parent().find('.reportimg').show();
            }
            else
            {
                $(chartselector).parent().find('.reportimg').hide();
            }
        }

        displayBSAggregateChart();
        function displayBSAggregateChart(){

                $.ajax({
            dataType: "json",

            url: "http://" + dbserver + "/ContinuousIntegration/dashboard/1/bs/aggregate?build=latest&buildtype=nightly",
            data: null,
            cache: false,
            async:false,
            success: function (data) {
            	 $("#BldResult").text(data.result);
                 $("#BldNumber").text(data.buildNumber);
                 $("#loc").text(data.loc);
                 $("#Blddatetime").text(data.datetime);
                 if(data.result != "SUCCESS"){
 					$("#buildReasonlbl").show();
                 	$("#BldReason").text(data.reason);
 				}else{
 					$(".reason").hide();
 				}
            },
            error: function (a, err, c) {
                alert(err);
            }
        });
        }

        window.onload = function(){
        	var myDate = new Date();
        	g_calendarObjectfrom = new JsDatePick({
            useMode:2,
            dateFormat:"%d/%M/%Y",
            target:"inputField",
            isStripped:false,
            selectedDate:{
                year:myDate.getFullYear(),
                month:myDate.getMonth(),
                day:myDate.getDay()
           	},
            yearsRange: new Array(1971,2100),
            limitToToday:true,
        });

        	g_calendarObjectto = new JsDatePick({

                useMode:2,
                dateFormat:"%d/%M/%Y",
                target:"Text2",
                isStripped:false,
                selectedDate:{
                	 year:myDate.getFullYear(),
                     month:myDate.getMonth(),
                     day:myDate.getDay()
               	},
                yearsRange: new Array(1971,2100),
                limitToToday:true,
            });


        };

        displayBScodecollabAggregateChart();
        function displayBScodecollabAggregateChart() {

            $.ajax({
        dataType: "json",

        url: "http://" + dbserver + "/ContinuousIntegration/dashboard/1/codecollab/aggregate?build=latest&buildtype=nightly",
        data: null,
        cache: false,
        async:false,
        success: function (data) {
        	 $("#Bldreviewidcnt").text(data.reviewidcnt);

        },
        error: function (a, err, c) {
            alert(err);
        }
    });

        }

});
