<div>	
    <ul class="nav nav-pills">
    
    	<!-- Ê×Ò³  -->
    	<#if active == "home">
    		<li id="home" role="presentation" class="active"><a href="/JavaWeb/finc/home">Home</a></li>
    	<#else>
    		<li id="home" role="presentation"><a href="/JavaWeb/finc/home">Home</a></li>
		</#if>
		
		
		<!-- Í¼±í -->
		<#if active == "chart">
			<li id="chart" role="presentation" class="dropdown active">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			      Chart <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu">
				    <li><a href="/JavaWeb/finc/line">Line</a></li>
				    <li><a href="/JavaWeb/finc/line1">Line1</a></li>
		            <li><a href="/JavaWeb/finc/column">Column</a></li>
		            <li><a href="/JavaWeb/finc/column1">Column1</a></li>
		            <li><a href="/JavaWeb/finc/pie">Pie</a></li>
			    </ul>
		    </li>
	    <#else>
	    	<li id="chart" role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			      Chart <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu">
				    <li><a href="/JavaWeb/finc/line">Line</a></li>
				    <li><a href="/JavaWeb/finc/line1">Line1</a></li>
		            <li><a href="/JavaWeb/finc/column">Column</a></li>
		            <li><a href="/JavaWeb/finc/column1">Column1</a></li>
		            <li><a href="/JavaWeb/finc/pie">Pie</a></li>
			    </ul>
		    </li>
	    </#if>
	    
	    
	    <#if active == "file"> 	    	
			<li role="presentation" class="active"><a href="/JavaWeb/finc/file">File</a></li>
		<#else>
			<li role="presentation"><a href="/JavaWeb/finc/file">File</a></li>
		</#if>
				
		
		<#if active == "user">
		    <li role="presentation" class="dropdown active">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			      Dropdown <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu">
				    <li><a href="/JavaWeb/finc/userList">List</a></li>
		            <li><a href="/JavaWeb/finc/userAdd">Add</a></li>
			    </ul>
		    </li>
	    <#else>
	    	<li role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			      Dropdown <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu">
				    <li><a href="/JavaWeb/finc/userList">List</a></li>
		            <li><a href="/JavaWeb/finc/userAdd">Add</a></li>
			    </ul>
		    </li>
	    </#if>
	    
	    <#if active == "1">
	    	<li role="presentation" class="active"><a href="/JavaWeb/finc/admin"> Go AdminPage </a></li>
	    <#else>
	    	<li role="presentation"><a href="/JavaWeb/finc/admin"> Go AdminPage </a></li>
	    </#if>
	    
	    
	    <#if active == "1">
	    	<li role="presentation" class="active"><a href="/JavaWeb/finc/login">logout</a></li>
	    <#else>
	    	<li role="presentation"><a href="/JavaWeb/finc/login">Logout</a></li>
	    </#if>
	    
	</ul>
</div>
