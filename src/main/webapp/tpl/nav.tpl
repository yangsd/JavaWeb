<div>	
    <ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	    <li role="presentation" class="dropdown">
		    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		      Dropdown <span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu">
			    <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li><a href="#">Separated link</a></li>
	            <li><a href="#">One more separated link</a></li>
		    </ul>
	    </li>
	    {{if isAdmin}}
	    	<li role="presentation"><a href="/JavaWeb/html/admin"> Go AdminPage </a></li>
	    {{/if}}
	    <li role="presentation"><a href="/JavaWeb/html/login">logout</a></li>
	</ul>
</div>