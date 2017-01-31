<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>DevOps Dashboard</title>

<link rel="stylesheet" type="text/css" media="all"
	href="css/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>

<link href="css/sidebar.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
<link href="css/infra.less" rel="stylesheet/less" type="text/css" />
<link href="css/override.css" rel="stylesheet" type="text/css" />
<link href="css/themes/default.less" rel="stylesheet/less"
	type="text/css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"
	type="text/javascript" charset="UTF-8"></script>

 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<script src="js/less-1.5.0.min.js" type="text/javascript"
	charset="UTF-8"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script src="js/jquery.foggy.min.js"></script>
<script src="js/HighChartHelper.js"></script>
<script src="js/dashboardcharts.js"></script>
<style>
select#product_list {background-color:#777777;height:26px;padding:2px !important;margin-top:2px;color:#fff;border-color:#999;}
select#product_list option {background-color:#454545;color:#fff;height:26px;}
</style>

</head>
<body>
	<div class="container">
		<header class="mainHeader">
			<div class="headerLogo pull-left">
				<img src="img/icnDCSC_24.png" width="24" height="24" alt="SCSC">
				<!--<span class="gutterLeft5"><img src="img/headerLogo.png" width="203" height="26" alt="SCSC"></span>-->
			</div>
			<!--<div class="pull-left"></div>-->
			<nav class="mainNav pull-left">
				<ul>
					<li><a href=""><span class="active">Dashboard</span></a></li>
				</ul>
			</nav>
			<!-- <div class="dropdown pull-right" style="margin-top: -3px !important;">
				<a href="#" class="dropdown-toggle btn btn-small btn-inverse"
					data-toggle="dropdown"><i><img src="img/portrait2.png"
						width="20" height="20" alt="User"></i><span
					class="dimText mediumText spaceLeft5">Steve Brown </span><i
					class="fa fa-chevron-down text-muted smallText"></i></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i
							class="fa fa-wrench spaceRight10 darkText-X"></i><span
							class="mediumText">Preferences</span></a></li>
					<li class="dropdown-submenu"><a href="#"><i
							class="fa fa-sign-out spaceRight10 darkText-X"></i><span
							class="mediumText">Logout</span></a>
				</ul>
			</div> -->
			
			<!-- <div id="selectProd" class="btn-group pull-right clearfix" style="margin-right:20px">
                        <button type="button" class="btn btn-default dropdown-toggle form-control selectProd" data-toggle="dropdown">
                        <span data-bind="label">Select Module</span> <span class="caret pull-right" style="position:absolute; top:45%; right:10px;"></span>
                        </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Security Orchestration</a></li>
                            <li><a href="#">Unified Management Console</a></li>
                            <li><a href="#">Critical System Protection</a></li>
                            <li><a href="#">Data Store</a></li>
                          </ul>
                        </div> -->
                        
                       <div id="select-container"  class="btn-group pull-right clearfix" style="margin-right:20px;">
						</div>
						<div class="selectProjectLabel pull-right gutterRight10 spaceTop5">Select Project:</div>
					<!--  <button id="add" onload="addSelect('select-container');">Add Dropdown</button>-->
						
			
		</header>
		<div id="pageContent">
			<!--<div class="pageTitle">

  <div class="text">Settings</div>
  </div>-->
			<div class="spaceTop20 spaceRight20 spaceLeft20">
				<span class="pull-left pageTitle inlineBlock">
				DevOps Dashboard </span>
				<!-- <span id = "disname">
				</span> -->
			</div>
			<div class="clearFloat"></div>
			<div class="gutterLeft20 gutterRight20 gutterTop20">
				<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
					<li class="active"><a href="#nightly" data-toggle="tab" class="nightlybuildtab">Aggregate Report
							</a></li>
					<li><a href="#cibuild" data-toggle="tab" class="cibuildtab">Module-wise Report
							</a></li>
					<li><a href="#trend" data-toggle="tab" class="trendbuildtab">Trend</a></li>
				</ul>
				<div id="my-tab-content" class="tab-content activeTabContent">
					<div class="tab-pane active" id="nightly">
						<div class="row">
							<div class="col-lg-12 tabSubTitle">
								<div class="wrapper center">
									<!-- <table class="container" cellpadding="3" cellspacing="0">
										<tr>
											<td>Build no.:</td>
											<td class="spaceLeft5 spaceRight20"><span id="BldNumber"></span>
											</td>

											<td class="spaceLeft20 spaceRight5 cell1">LOC :</td>
											<td class="spaceLeft10 spaceRight20"><span id="loc"></span>
											</td>

											<td class="spaceLeft20 spaceRight5 cell1">Result:</td>
											<td class="spaceRight20 text-danger"><span
												id="BldResult"></span></td>
											<td class="reason spaceLeft20 spaceRight5 cell1">
												Reason:</td>
											<td><span id="BldReason" class="reason"></span></td>

											<td class="datetime spaceLeft20 spaceRight5 cell1">
												DateTime:</td>
											<td><span id="Blddatetime" class="datetime"></span></td>

											<td class="spaceLeft20 spaceRight5 cell1">Review ID
												Count:</td>
											<td class="spaceRight20 text-danger"><span
												id="Bldreviewidcnt"></span></td>
										</tr>
									</table> -->
									<div class="builds">
										<span class="caption pull-left boldText gutterRight20">Available Builds:</span>
									    <ul id="ULID">
										</ul>
										
										<div id="pop-up">
											<div class="container space5">
												<table width="100%" cellpadding="0" cellspacing="0">
												<tbody>
												<tr>
												<td class="rowColor">LOC:</td><td class="rowColor"><span id="loc"></span></td>
												</tr>
												<tr>
												<td class="rowColor">Result:</td><td class="rowColor"><span id="BldResult"></span></td>
												</tr>
												<tr>
												<td class="rowColor">Reason:</td><td class="rowColor"><span id="BldReason"></span></td>
												</tr>
												<tr>
												<td class="rowColor">DateTime:</td><td class="rowColor"><span id="Blddatetime"></span></td>
												</tr>
												<tr>
												<td class="rowColor">Review ID Count:</td><td class="rowColor"><span id="Bldreviewidcnt"></span></td>
												</tr>
												</tbody>
												</table>
	          								</div>
          								</div>
									</div>
									<div class="gutterBottom10 gutterTop10">
									<input class="btn btn-xs btn-default" id="but1" type="button" value="Download Appliance (TBD)">
									<input class="btn btn-xs btn-default gutterLeft5" id="but1" type="button" value="Connect Appliance">
									<!--  <input class="btn btn-xs btn-default" id="but2" type="button" value="Button Two">
									<input class="btn btn-xs btn-default" id="but3" type="button" value="Button Three"> -->
								</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Unit Test : Results</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="utAggregateChart" class="c">
											<div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
												<div id="aggregatechartut">							
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Unit Test : Code Coverage</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="ccAggregateChart" class="c">
											<div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
												<div id="aggregatechartcc">							
												</div>
												
											
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Static Code Analysis : FindBug
											issues</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="fbAggregateChart" class="c">
											  <div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
												<div id="AggregateChartfb">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Static Code Analysis : PMD issues</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="pmAggregateChart" class="c">
											    <div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
												<div id="AggregateChartpm">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">BAT : Results</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="btAggregateChart" class="c">
												<div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
												<div id="AggregateChartbat">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						<!-- 	<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">BAT : Code Coverage</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="btcAggregateChart" class="c">
												<div class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div> -->
						</div>

					</div>
					<div class="tab-pane" id="cibuild">
						<div class="row">
							<div class="col-lg-12 tabSubTitle">
								<div class="wrapper center" style="display: none;">
									<table class="container" cellpadding="3" cellspacing="0">
										<tr>
											<td>Build no.:</td>
											<td class="spaceLeft5 spaceRight20">68</td>
											<td class="spaceLeft20 spaceRight5 cell1">Result:</td>
											<td class="spaceRight20 text-danger">Fail</td>
											<td class="spaceLeft20 spaceRight5 cell1">Reason:</td>
											<td>Unknown</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">
										<!--  	<a href="#"> <span class="arrow-back pull-left"></span> <span
											 	class="pull-left btn-back">Back</span></a> --> <span
												class="gutterLeft10">Unit Tests : Modulewise</span>
										</div>

										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="utAggregateChartci" class="c"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Code Coverage All Modules</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="ccAggregateChartci" class="c"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">FindBug (Static Code Analysis) :
											Modulewise</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartFingbugModuleWise" class="c"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Code Complexity : Modulewise</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartCodeComplexityModuleWise" class="c"></div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">LOC : Modulewise</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartLocModuleWise" class="c"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">PMD (Static Code Analysis) :
											Modulewise</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartPMDModuleWise" class="c"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="tab-pane" id="trend">
					<div id="dialog" title="Date Selection">
  					<p>Please select the date range using date controls provided. Click on "Go" button</p>
					</div>

						<div>
							<div class="btn-toolbar pull-left">
								<div class="btn-group">
									<button class="trendbtn btn btn-primary" id="weektrend">1 Week</button>
									<button class="trendbtn btn" id="monthtrend">1 Month</button>
									<button class="trendbtn btn" id="customtrend">Custom</button>
								</div>
							</div>
							<div class="pull-left gutterLeft20 spaceTop10">
							<div class="pull-left gutterLeft20" id="frmdate">From Date: <span class="blueText">2014/06/02</span></div>
							<div class="pull-left gutterLeft20" id="todate">To Date: <span class="blueText">2014/06/09</span>
							</div>
							</div>
							<div class="pull-left" id="daterange">
								<table style="margin-left: 50px;" class="pull-left"
									cellpadding="0" cellspacing="0">
									<tr>
										<td class="spaceRight10"
											style="line-height: 34px; width: 50px; white-space: nowrap;">
											Date Range:</td>
										<td style="width: 200px;">
											<div class="input-group">
												<input class="form-control" id="inputField" type="text" />
												<span class="input-group-addon"><i
													class="fa fa-calendar"></i></span>
											</div>
										</td>
										<td class="spaceLeft20 spaceRight20" style="width: 10px;">
											to</td>
										<td style="width: 200px;">
											<div class="input-group">
												<input class="form-control" id="Text2" type="text" /> <span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</td>
										<td class="spaceLeft20" style="width: 50px;"><input
											class="btn btn-default" style="width: 50px;" id="Button1"
											type="button" class="gobutton" id="gobuttonid" value="Go" /></td>
											
											
									</tr>
								</table>
							</div>
						</div>
						<div class="clearFloat"></div>
						<div class="row gutterTop20">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Unit Test</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
										<!-- 	<div id="customuttrend" class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
													</div> -->
											<div id="chartweekUttrend" class="c">
												
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Code Coverage</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekCctrend" class="c"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">FindBug</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekFbtrend" class="c"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">PMD</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekPmtrend" class="c"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<!-- new row -->
						
						<div class="row gutterTop20">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Code Collaborator Review's</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
										<!-- 	<div id="customuttrend" class="nodata" style="display: none" align="center">
													<img alt="" src="img/nodata.png" width="200px"
														height="200px"></img>
													</div> -->
											<div id="chartweekCodeCollabtrend" class="c">
												
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">Lines of Code</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekLoctrend" class="c"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
				<div class="row gutterTop20">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">BAT Test Cases</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekbattrend" class="c">
												
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">QA Automation (Regression) Test Cases</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekregtrend" class="c">
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row gutterTop20">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="pull-left">QA Automation (Regression) Code Coverage</div>
										<a href="#"><span class="panelIconBox pull-right"><i
												class="fa fa-times darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-expand darkText-X"> </i></span></a><a href="#"><span
											class="panelIconBox pull-right"><i
												class="fa fa-pencil darkText-X"> </i></span></a>
									</div>
									<div class="clearFloat"></div>
									<div class="panelContent">
										<div class="space20">
											<div id="chartweekqacctrend" class="c">
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
				</div>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$('#tabs').tab();
		});
	</script>
	</div>
	<div class="clearFloat">&nbsp;</div>
	<footer class="mainFooter">
		<div class="collapsed pull-left">
			<a href=""><i class="fa fa-chevron-up textGray"></i></a>
		</div>
		<div class="copyright pull-left">Copyright Infosys
			Corporation. All rights reserved</div>
		<div class="logo pull-right">
			<img src="img/infylogo1.JPG" width="75" height="20" alt="Infosys">
		</div>
	</footer>
	</div>
	
	<script type="text/javascript">
        $(document.body).on('click', '.dropdown-menu li', function (event) {

            var $target = $(event.currentTarget);

            $target.closest('#selectProd')
      .find('[data-bind="label"]').text($target.text())
         .end()
      .children('.dropdown-toggle').dropdown('toggle');

            return false;

        });
            </script>
	
	<!-- <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script> -->
	<!-- REQUIRED: Bootstrap Prompt -->
	<!-- <script src="js/include/bootbox.min.js"></script> -->
	<!-- REQUIRED: Bootstrap engine -->
    <script src="js/bootstrap.js"></script>
<!--     <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script> -->
    <!-- <script type="text/javascript">
      $(function() {
        var moveLeft = -105;
        var moveDown = 30;
        
        $('.showPopup').hover(function(e) {
          $('div#pop-up').show()
            .css('top', e.pageY + moveDown)
            .css('left', e.pageX + moveLeft)
            .appendTo('body');
        }, function() {
            setTimeout(function() { $('div#pop-up').hide(); }, 500);
        });
        
      });
    </script> -->
</body>
</html>
