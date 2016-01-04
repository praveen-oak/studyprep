<html lang="en">

    <head>

        <title>Algorithm Practice</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-theme.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="resources/css/algorithm-app.css"/>

        <script src="resources/jquery/1.11.3/jquery-1.11.3.min.js"></script>
        <script src="resources/js/bootstrap/bootstrap.js"></script>
        <script src="resources/js/bootstrap/bootstrap.min.js"></script>

        <script src="resources/js/angular/angular-1.2.16-min.js"></script>
        <script src="resources/js/angular/angular-ui-router-0.2.10-min.js"></script>
        <script src="resources/js/angular/angular-animate-1.2.16-min.js"></script>

        <script src="resources/js/core/algorithmApp.js"></script>

    </head>

    <body role="document" ng-app="algorithmApp" ng-controller="algorithmController">

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    CODE Algorithms
                </a>
                <a class="navbar-brand" rel="home" href="#">
                    <img style="width:90px;height:90px; margin-top: -25px;"
                         src="resources/images/terminal-icon.png">
                </a>
                <a class="navbar-brand">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </a>

            </div>
            <%--<div id="navbar" class="navbar-collapse collapse">--%>
                <%--<ul class="nav navbar-nav">--%>
                    <%--<li class="active"><a href="#">Home</a></li>--%>
                    <%--<li><a href="#about">About</a></li>--%>
                    <%--<li><a href="#contact">Contact</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </nav>

        </br></br></br></br></br></br>

        <div align = "center">

            <h1>
                <img style="width:32px;height:32px;margin-top: -10px; "src="resources/images/code-1.png">
                <span style="color: #28A6CC;">Algorithms</span>
            </h1>

            </br></br>

            <select ng-model="selectedAlgorithmTypeOption" class="form-control algorithm-select"
                    ng-options="algorithmTypeOption.code as algorithmTypeOption.name for algorithmTypeOption in algorithmTypeOptions" >

                <option style="display:none" value="">Select Algorithm Type</option>

            </select>

            &nbsp;

            <select ng-model="selectedAlgorithmOption" class="form-control algorithm-select"
                    ng-options="algorithmOption.code as algorithmOption.name for algorithmOption in loadAlgorithmList()" >

                <option style="display:none" value="">Select Algorithm&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>

            </select>

            </br></br>

            <button type="button" class="btn btn btn-info" ng-click="triggerAlgorithm()">Fire Algorithm</button>

            </br></br></br>

            <div class="alert alert-danger" role="alert" ng-show="showValidationError" style="width:500px">

                <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>--%>
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <span class="sr-only">Error:</span>
                {{validationError}}

            </div>

            <div id="loading-animation" ng-show="showAnimation">

                <img style="width:70px;height:70px;" src="resources/images/loading-box.gif" class="result-content">
                </br>
                <span style="color: #28A6CC;">Loading Results.....</span>

            </div>

            <div id="results" ng-show="showResults" class="result-box">

                <div align="left">

                    <h2>&nbsp;Result</h2>

                    <div class="result-data">

                        </br></br>
                        <div class="algorithm-key result-content">Description</div>
                        <div class="algorithm-value result-content">{{algorithmResponse.description}}</div>
                        </br> </br></br>

                        <div class="algorithm-key result-content">Reference</div>
                        <div class="algorithm-value result-content"><a ng-href="{{algorithmResponse.ref}}">{{algorithmResponse.ref}}</a></div>
                        </br> </br></br>

                        <div class="algorithm-key result-content">Input</div>
                        <div class="algorithm-value result-content">{{algorithmResponse.input}}</div>
                        </br> </br></br>
                        <div class="algorithm-key result-content">Output</div>
                        <div class="algorithm-value result-content">{{algorithmResponse.output}}</div>
                        </br> </br></br>

                    </div>

                    </br>&nbsp;

                    <button type="button" class="btn btn btn-info" ng-click="closeResults()">Close Results</button>

                </div>

            </div>

            </br></br></br></br></br></br></br></br></br></br>

            <div id="footer">
                &#169; Copyright 2015 - Code Algorithms. All Rights Reserved.
            </div>

            </br>

        </div>

    </body>

</html>
