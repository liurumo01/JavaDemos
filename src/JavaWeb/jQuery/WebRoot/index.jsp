<!DOCTYPE html>
<html xmlns:wb=“http://open.weibo.com/wb”>
    <head>
        <title>Virtual Judge</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<style>
			#cssmenu {
				width: auto;
				font-family: 'Open Sans',sans-serif;
				line-height: 1;
			}
			#cssmenu, #cssmenu ul, #cssmenu ul li, #cssmenu ul li a, #cssmenu #menu-button {
				margin: 0;
				padding: 0;
				border: 0;
				list-style: none;
				line-height: 1;
				display: block;
				position: relative;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
			}
			div {
				display: block;
			}
			#cssmenu>ul {
				background-color: #d3d6ff;
				border-radius: 5px;
				height: 35px;
				margin-bottom: 30px;
			}
			#cssmenu, #cssmenu ul, #cssmenu ul li, #cssmenu ul li a, #cssmenu #menu-button {
				margin: 0;
				padding: 0;
				border: 0;
				list-style: none;
				line-height: 1;
				display: block;
				position: relative;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
			}
			ul, menu, dir {
				display: block;
				list-style-type: disc;
				-webkit-margin-before: 1em;
				-webkit-margin-after: 1em;
				-webkit-margin-start: 0px;
				-webkit-margin-end: 0px;
				-webkit-padding-start: 40px;
			}
			#cssmenu:after, #cssmenu>ul:after {
				content: ".";
				display: block;
				clear: both;
				visibility: hidden;
				line-height: 0;
				height: 0;
			}
			#cssmenu, #cssmenu ul, #cssmenu ul li, #cssmenu ul li a, #cssmenu #menu-button {
				list-style: none;
				line-height: 1;
			}
			#cssmenu>ul>li {
				float: left;
			}
			li {
				display: list-item;
				text-align: -webkit-match-parent;
			}
		</style>
    </head>

    <body>
		<div id='cssmenu'>
			<ul>
			    <li id="nav_home"><a href="/vjudge/toIndex.action">Home</a></li>
			    <li id="nav_problem"><a href="/vjudge/problem/toListProblem.action">Problem</a></li>
			    <li id="nav_status"><a href="/vjudge/problem/status.action">Status</a></li>
			    <li id="nav_contest" class='has-sub'><a href="/vjudge/contest/toListContest.action">Contest</a>
			       <!-- <ul>
			          <li><a href='/vjudge/contest/toAddContest.action' class="login">Add Contest</a></li>
			          <li><a href='/vjudge/contest/statistic.action'>Statistic</a></li>
			       </ul> -->
			    </li>
				<li style="float:right">
			        
			        
			            <a class="login" href="javascript:void(0)">LOGIN</a>
			        
			    </li>
			    
			    
			        <li style="float:right">
			            <a class="register" href="javascript:void(0)">REGISTER</a>
			        </li>
			    
			</ul>
		</div>
    </body>
</html>
